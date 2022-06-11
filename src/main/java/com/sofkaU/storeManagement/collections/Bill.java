package com.sofkaU.storeManagement.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bill")
public class Bill {

    @Id
    private String id;

    private LocalDate date;

    private String customerName;

    private String sellerName;

    private Double paid;

    private List<ProductItem> products;
}
