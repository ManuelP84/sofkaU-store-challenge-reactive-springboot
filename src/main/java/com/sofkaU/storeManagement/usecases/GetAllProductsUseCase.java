package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.collections.Product;
import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.dto.ProviderDto;
import com.sofkaU.storeManagement.mapper.ProductMapper;
import com.sofkaU.storeManagement.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase implements Supplier {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDto> get() {
        return productRepository
                .findAll()
                .map(product -> productMapper.convertEntityToDto().apply(product));
    }
}
