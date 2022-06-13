package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.collections.Provider;
import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.mapper.ProviderMapper;
import com.sofkaU.storeManagement.repository.IProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class GetAllProvidersTest {

    private GetAllProvidersUseCase getAllProvidersUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    IProviderRepository providerRepository;

    @BeforeEach
    void setUp(){
        getAllProvidersUseCase = new GetAllProvidersUseCase(providerRepository, providerMapper);
    }

    @Test
    void getAllProviders(){

        //Set a provider
        Provider providerTest = new Provider();
        providerTest.setId("4t6w9q");
        providerTest.setNit("9002343");
        providerTest.setName("Fadesa");
        providerTest.setPhone("3166234144");
        providerTest.setEmail("fadesa@gmail.com");
        providerTest.setNote("Tools");

        Mockito.when(providerRepository.findAll()).thenReturn(Flux.just(providerTest));

        Flux<ProviderDto> fluxProviders = getAllProvidersUseCase.get();

        StepVerifier.create(fluxProviders)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(providerRepository).findAll();

    }


}
