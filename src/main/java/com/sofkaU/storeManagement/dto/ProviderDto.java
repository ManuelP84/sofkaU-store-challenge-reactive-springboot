package com.sofkaU.storeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto {

    private String id; // = UUID.randomUUID().toString().substring(0, 5);

    private String nit;

    private String name;

    private String phone;

    private String email;

    private String note;
}
