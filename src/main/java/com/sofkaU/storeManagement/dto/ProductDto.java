package com.sofkaU.storeManagement.dto;

import com.sofkaU.storeManagement.collections.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @Id
    private String id;

    private String name;

    private String description;

    private Integer min;

    private Integer max;

    private Integer quantity;

    private String providerNit;

}
