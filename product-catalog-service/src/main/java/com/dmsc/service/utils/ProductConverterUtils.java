package com.dmsc.service.utils;

import com.dmsc.service.model.product.ProductResponse;
import com.dmsc.service.product.ProductEntity;
import org.modelmapper.Converter;

public final class ProductConverterUtils {
    private ProductConverterUtils() {
        // prevent initialization
    }

    public static Converter<ProductEntity, ProductResponse> getProductEntityProductResponseConverter() {
        return context -> {
            ProductEntity source = context.getSource();
            return ProductResponse.newBuilder()
                    .setPrice(source.getPrice().longValue())
                    .setName(source.getName())
                    .setCategory(source.getCategory())
                    .setId(source.getId())
                    .setAvailability(source.getAvailability())
                    .setDescription(source.getDescription())
                    .build();
        };
    }
}
