package com.sofkaU.storeManagement.mapper;

import com.sofkaU.storeManagement.collections.Product;
import com.sofkaU.storeManagement.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public Function<Product, ProductDto> convertEntityToDto(){
        return product -> modelMapper.map(product, ProductDto.class);
    }

    public Function<ProductDto, Product> convertDtoToEntity(){
        return productDto -> modelMapper.map(productDto, Product.class);
    }
}
