package com.dmsc.service.product;

import com.dmsc.service.model.product.AdminProductServiceGrpc;
import com.dmsc.service.model.product.ItemRequest;
import com.dmsc.service.model.product.Product;
import com.dmsc.service.model.product.ProductResponse;
import com.dmsc.service.utils.ProductConverterUtils;
import com.dmsc.service.utils.ValidationUtils;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;

@GrpcService
public class ProductManagementImpl extends AdminProductServiceGrpc.AdminProductServiceImplBase {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductManagementImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
        this.modelMapper.typeMap(ProductEntity.class, ProductResponse.class)
                .setConverter(ProductConverterUtils.getProductEntityProductResponseConverter());
    }

    @Override
    public void add(Product request, StreamObserver<ProductResponse> responseObserver) {
        // TODO Add validations
        ProductEntity toStore = modelMapper.map(request, ProductEntity.class);
        productRepository.save(toStore)
                .map(x -> modelMapper.map(x, ProductResponse.class))
                .subscribe(x -> {
                    responseObserver.onNext(x);
                    responseObserver.onCompleted();
                }, responseObserver::onError);
    }

    @Override
    public void delete(ItemRequest request, StreamObserver<Empty> responseObserver) {
        if (ValidationUtils.failedValidations(request.getId(), responseObserver)) {
            return;
        }

        productRepository.deleteById(request.getId())
                .doOnSuccess(x -> responseObserver.onNext(Empty.newBuilder().build()))
                .doOnError(x -> responseObserver.onError(Status.NOT_FOUND.withDescription("Not Found").asRuntimeException()))
                .subscribe();
    }
}
