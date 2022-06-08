package com.sofkaU.storeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto {

    private String id;

    private String nit;

    private String name;

    private String phone;

    private String address;

    private String note;
}
