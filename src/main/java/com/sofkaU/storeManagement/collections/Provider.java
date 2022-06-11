package com.sofkaU.storeManagement.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "provider")
public class Provider {

    @Id
    private String id;

    private String nit;

    private String name;

    private String phone;

    private String email;

    private String note;
}
