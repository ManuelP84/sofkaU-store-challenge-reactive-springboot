package com.sofkaU.storeManagement.usecases;

import com.sofkaU.storeManagement.dto.ProductDto;
import com.sofkaU.storeManagement.mapper.ProductMapper;
import com.sofkaU.storeManagement.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class CreateProductUseCase implements Function<ProductDto, Mono<ProductDto>> {

    private final IProductRepository productRepository;
    private final ProductMapper      productMapper;


    @Override
    public Mono<ProductDto> apply(ProductDto productDto) {
        return productRepository
                .save(productMapper
                        .convertDtoToEntity()
                        .apply(productDto))
                .map(product -> productMapper.convertEntityToDto().apply(product));
    }
}
