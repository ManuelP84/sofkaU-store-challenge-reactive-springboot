package com.sofkaU.storeManagement.dto;

import com.sofkaU.storeManagement.collections.ProductItem;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BillDto {

    private String id;

    private LocalDate date;

    private String customerName;

    private String sellerName;

    private Double paid;

    private List<ProductItem> products;
}
