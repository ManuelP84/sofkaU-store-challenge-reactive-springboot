package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.mapper.ProviderMapper;
import com.sofkaU.storeManagement.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class CreateProviderUseCase implements Function<ProviderDto, Mono<ProviderDto>> {

    private final IProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Override
    public Mono<ProviderDto> apply(ProviderDto providerDto) {
        return providerRepository
                .save(providerMapper.convertDtoToEntity().apply(providerDto))
                .map(provider -> providerMapper.convertEntityToDto().apply(provider));
    }
}
