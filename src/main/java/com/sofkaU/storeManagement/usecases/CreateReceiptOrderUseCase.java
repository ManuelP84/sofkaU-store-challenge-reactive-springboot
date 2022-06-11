package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.ReceiptOrderDto;
import com.sofkaU.storeManagement.mapper.ReceiptOrderMapper;
import com.sofkaU.storeManagement.repository.IReceiptOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class CreateReceiptOrderUseCase implements Function<ReceiptOrderDto, Mono<ReceiptOrderDto>> {

    private final IReceiptOrderRepository receiptOrderRepository;
    private final ReceiptOrderMapper receiptOrderMapper;


    @Override
    public Mono<ReceiptOrderDto> apply(ReceiptOrderDto receiptOrderDto) {
        return receiptOrderRepository
                .save(receiptOrderMapper.convertDtoToEntity().apply(receiptOrderDto))
                .map(receiptOrder -> receiptOrderMapper.convertEntityToDto().apply(receiptOrder));
    }
}
