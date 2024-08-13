package com.dmsc.service.product;

import com.dmsc.service.model.product.ItemRequest;
import com.dmsc.service.model.product.Product;
import com.dmsc.service.model.product.ProductResponse;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class ProductManagementImplTest {

    private ProductManagementImpl classUnderTest;
    private ProductRepository mockProductRepository;

    @BeforeEach
    void setUp() {
        mockProductRepository = mock(ProductRepository.class);
        classUnderTest = new ProductManagementImpl(mockProductRepository);
    }

    @Test
    void testAddProduct() {
        /* Preparation */
        Product request = Product.newBuilder().setAvailability(1).setCategory("cat").setName("name").setDescription("description").setPrice(1L).build();
        StreamRecorder<ProductResponse> responseObserver = StreamRecorder.create();

        ProductEntity build = ProductEntity.builder().name("name").availability(1).id("id").category("cat").description("description").price(BigDecimal.ONE).build();
        Mockito.when(mockProductRepository.save(any(ProductEntity.class))).thenReturn(Mono.just(build));

        /* Execution */
        classUnderTest.add(request, responseObserver);

        /* Validation */
        Boolean completeWithinTime = assertDoesNotThrow(() -> responseObserver.awaitCompletion(5, TimeUnit.SECONDS));
        if (!completeWithinTime) {
            fail("The call did not terminate in time");
        }
        assertNull(responseObserver.getError());
        List<ProductResponse> values = responseObserver.getValues();
        assertNotNull(values);
    }

    @Test
    void testAddProductInvalidRequest() {
        /* Preparation */
        Product request = Product.newBuilder().build();
        StreamRecorder<ProductResponse> responseObserver = StreamRecorder.create();

        ProductEntity build = ProductEntity.builder().name("name").availability(1).id("id").category("cat").price(BigDecimal.ONE).build();
        Mockito.when(mockProductRepository.save(any(ProductEntity.class))).thenReturn(Mono.just(build));

        /* Execution */
        classUnderTest.add(request, responseObserver);

        /* Validation */
        Boolean completeWithinTime = assertDoesNotThrow(() -> responseObserver.awaitCompletion(5, TimeUnit.SECONDS));
        if (!completeWithinTime) {
            fail("The call did not terminate in time");
        }
        assertNotNull(responseObserver.getError());
    }

    @Nested
    class DeleteProduct {
        @Test
        void successful() {
            /* Preparation */
            ItemRequest request = ItemRequest.newBuilder().setId("id").build();
            StreamRecorder<Empty> responseObserver = StreamRecorder.create();

            Mockito.when(mockProductRepository.deleteById("id")).thenReturn(Mono.empty());

            /* Execution */
            classUnderTest.delete(request, responseObserver);

            /* Validation */
            Boolean completeWithinTime = assertDoesNotThrow(() -> responseObserver.awaitCompletion(5, TimeUnit.SECONDS));
            if (!completeWithinTime) {
                fail("The call did not terminate in time");
            }
            assertNull(responseObserver.getError());
        }

        @Test
        void databaseError() {
            /* Preparation */
            ItemRequest request = ItemRequest.newBuilder().setId("id").build();
            StreamRecorder<Empty> responseObserver = StreamRecorder.create();

            Mockito.when(mockProductRepository.deleteById("id")).thenReturn(Mono.error(RuntimeException::new));

            /* Execution */
            classUnderTest.delete(request, responseObserver);

            /* Validation */
            Boolean completeWithinTime = assertDoesNotThrow(() -> responseObserver.awaitCompletion(5, TimeUnit.SECONDS));
            if (!completeWithinTime) {
                fail("The call did not terminate in time");
            }
            StatusRuntimeException error = (StatusRuntimeException) responseObserver.getError();
            assertNotNull(error);
            assertEquals(Status.NOT_FOUND.getCode(), error.getStatus().getCode());
        }
    }
}