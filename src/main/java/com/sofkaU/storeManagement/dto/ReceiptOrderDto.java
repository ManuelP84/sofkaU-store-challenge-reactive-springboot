package com.sofkaU.storeManagement.dto;

import com.sofkaU.storeManagement.collections.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptOrderDto {

    private String id;

    private ProductDto product;

    private Integer quantityAdded;

    private LocalDate date = LocalDate.now();
}
