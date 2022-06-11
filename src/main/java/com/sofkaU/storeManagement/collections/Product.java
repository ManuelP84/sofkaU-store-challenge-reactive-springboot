package com.sofkaU.storeManagement.collections;

import com.sofkaU.storeManagement.dto.ProviderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private Integer min;

    private Integer max;

    private Integer quantity;

    private Double price;

    private ProviderDto provider;
}
