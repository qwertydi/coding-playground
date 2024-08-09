package com.dmsc.service.product;

import com.dmsc.service.model.product.*;
import com.dmsc.service.utils.ProductConverterUtils;
import com.dmsc.service.utils.ValidationUtils;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.modelmapper.protobuf.ProtobufModule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@GrpcService
public class ProductCatalogImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductCatalogImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
        this.modelMapper.registerModule(new ProtobufModule());
        this.modelMapper.typeMap(ProductEntity.class, ProductResponse.class)
                .setConverter(ProductConverterUtils.getProductEntityProductResponseConverter());
    }

    @Override
    public void list(Empty request, StreamObserver<ListProducts> responseObserver) {
        Flux<ProductResponse> dbResponse = productRepository.findAll()
                .map(entity -> modelMapper.map(entity, ProductResponse.class));

        dbResponse
                .collectList()
                .map(objects -> ListProducts.newBuilder().addAllProducts(objects).build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );
    }

    @Override
    public void listByCategory(CategoryRequest request, StreamObserver<ListProducts> responseObserver) {
        if (ValidationUtils.failedValidations(request.getCategory(), responseObserver)) {
            return;
        }
        Flux<ProductResponse> dbResponse = productRepository.findByCategory(request.getCategory())
                .map(entity -> modelMapper.map(entity, ProductResponse.class));

        dbResponse.collectList()
                .map(objects -> ListProducts.newBuilder().addAllProducts(objects).build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );
    }

    @Override
    public void increaseStock(ProductStockQuantity request, StreamObserver<Empty> responseObserver) {
        productRepository.findById(request.getId())
                .switchIfEmpty(Mono.defer(() -> Mono.error(Status.NOT_FOUND.asException())))
                .flatMap(productEntity -> {
                    productEntity.setAvailability(productEntity.getAvailability() + request.getQuantity());
                    return productRepository.save(productEntity);
                })
                .subscribe(x -> {
                    responseObserver.onNext(Empty.newBuilder().build());
                    responseObserver.onCompleted();
                }, responseObserver::onError);
    }

    @Override
    public void decreaseStock(ProductStockQuantity request, StreamObserver<Empty> responseObserver) {
        productRepository.findById(request.getId())
                .switchIfEmpty(Mono.defer(() -> Mono.error(Status.NOT_FOUND.asException())))
                .flatMap(productEntity -> {
                    int availability = productEntity.getAvailability();
                    int quantity = request.getQuantity();
                    if (availability - quantity < 0) {
                        return Mono.error(Status.OUT_OF_RANGE.asException());
                    }
                    productEntity.setAvailability(availability - quantity);
                    return productRepository.save(productEntity);
                })
                .subscribe(x -> {
                    responseObserver.onNext(Empty.newBuilder().build());
                    responseObserver.onCompleted();
                }, responseObserver::onError);
    }

    @Override
    public void productById(ItemRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.productById(request, responseObserver);
    }
}
