package com.sofkaU.storeManagement.collections;

import lombok.Data;

@Data
public class ProductItem {

    private String id;

    private String name;

    private Integer quantity;

    private Double price;

    private Double subTotal;
}
