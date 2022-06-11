package com.sofkaU.storeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptOrderDto {

    private String id;

    private ProviderDto provider;

    private String productId;

    private Integer quantity;

    private LocalDate date;
}
