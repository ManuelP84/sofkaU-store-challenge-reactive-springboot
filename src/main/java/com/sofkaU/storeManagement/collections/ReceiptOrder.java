package com.sofkaU.storeManagement.collections;

import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.dto.ProviderDto;
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
@Document(collection = "receiptOrder")
public class ReceiptOrder {

    @Id
    private String id;

    private ProductDto product;

    private Integer quantityAdded;

    private LocalDate date = LocalDate.now();
}
