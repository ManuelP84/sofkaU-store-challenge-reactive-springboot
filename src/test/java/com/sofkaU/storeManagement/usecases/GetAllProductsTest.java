package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.collections.Product;
import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.mapper.ProductMapper;
import com.sofkaU.storeManagement.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class GetAllProductsTest {

    private GetAllProductsUseCase getAllProductsUseCase;

    @Autowired
    private ProductMapper productMapper;

    @Mock
    IProductRepository productRepository;

    @BeforeEach
    void setUp(){
        getAllProductsUseCase = new GetAllProductsUseCase(productRepository, productMapper);
    }

    @Test
    void getAllProducts(){
        //Set a provider
        ProviderDto providerTest = new ProviderDto();
        providerTest.setId("4t6w9q");
        providerTest.setNit("9002343");
        providerTest.setName("Fadesa");
        providerTest.setPhone("3166234144");
        providerTest.setEmail("fadesa@gmail.com");
        providerTest.setNote("Tools");

        //Set a product
        Product productTest = new Product();
        productTest.setId("91185");
        productTest.setName("Screwdriver");
        productTest.setDescription("Repair");
        productTest.setMin(5);
        productTest.setMax(20);
        productTest.setQuantity(10);
        productTest.setPrice(30000.0);
        productTest.setProvider(providerTest);

        Mockito.when(productRepository.findAll()).thenReturn(Flux.just(productTest));

        Flux<ProductDto> fluxProducts = getAllProductsUseCase.get();

        StepVerifier.create(fluxProducts)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(productRepository).findAll();

    }

}
