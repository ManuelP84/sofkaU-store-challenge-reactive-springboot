package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.mapper.ProviderMapper;
import com.sofkaU.storeManagement.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllProvidersUseCase implements Supplier {

    private final IProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Override
    public Flux<ProviderDto> get() {
        return providerRepository
                .findAll()
                .map(provider -> providerMapper.convertEntityToDto().apply(provider));
    }
}
