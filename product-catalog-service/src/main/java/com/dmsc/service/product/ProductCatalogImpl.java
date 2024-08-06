package com.dmsc.service.product;

import com.dmsc.service.model.product.CategoryRequest;
import com.dmsc.service.model.product.ListProducts;
import com.dmsc.service.model.product.ProductResponse;
import com.dmsc.service.model.product.ProductServiceGrpc;
import com.dmsc.service.utils.ProductConverterUtils;
import com.dmsc.service.utils.ValidationUtils;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.modelmapper.protobuf.ProtobufModule;
import reactor.core.publisher.Flux;

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
}
