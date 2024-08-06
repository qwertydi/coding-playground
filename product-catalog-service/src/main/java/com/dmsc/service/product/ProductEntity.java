package com.dmsc.service.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private int availability;
}
