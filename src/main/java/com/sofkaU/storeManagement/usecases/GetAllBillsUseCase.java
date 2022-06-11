package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.BillDto;
import com.sofkaU.storeManagement.mapper.BillMapper;
import com.sofkaU.storeManagement.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllBillsUseCase implements Supplier {

    private final IBillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Flux<BillDto> get() {
        return billRepository
                .findAll()
                .map(bill -> billMapper.convertEntityToDto().apply(bill));
    }
}
