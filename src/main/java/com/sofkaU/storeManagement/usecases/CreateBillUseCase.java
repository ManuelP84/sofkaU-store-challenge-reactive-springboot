package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.BillDto;
import com.sofkaU.storeManagement.mapper.BillMapper;
import com.sofkaU.storeManagement.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class CreateBillUseCase implements Function<BillDto, Mono<BillDto>> {

    private final IBillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<BillDto> apply(BillDto billDto) {
        return billRepository
                .save(billMapper
                        .convertDtoToEntity()
                        .apply(billDto))
                .map(bill -> billMapper.convertEntityToDto().apply(bill));
    }
}
