package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.mapper.ProviderMapper;
import com.sofkaU.storeManagement.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class DeleteProviderUseCase implements Function<String, Mono<Void>> {

    private final IProviderRepository providerRepository;
    private final ProviderMapper providerMapper;


    @Override
    public Mono<Void> apply(String id) {
        return providerRepository
                .findById(id)
                .switchIfEmpty(Mono.error(() -> new Throwable("No provider found with the id: ".concat(id))))
                .flatMap(provider -> providerRepository.deleteById(provider.getId()));

    }
}
