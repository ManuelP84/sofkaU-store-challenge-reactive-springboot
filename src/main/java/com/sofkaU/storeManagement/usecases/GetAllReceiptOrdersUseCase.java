package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.ReceiptOrderDto;
import com.sofkaU.storeManagement.mapper.ReceiptOrderMapper;
import com.sofkaU.storeManagement.repository.IReceiptOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllReceiptOrdersUseCase implements Supplier {

    private final IReceiptOrderRepository receiptOrderRepository;
    private final ReceiptOrderMapper receiptOrderMapper;

    @Override
    public Flux<ReceiptOrderDto> get() {
        return receiptOrderRepository
                .findAll()
                .map(receiptOrder -> receiptOrderMapper.convertEntityToDto().apply(receiptOrder));
    }
}
