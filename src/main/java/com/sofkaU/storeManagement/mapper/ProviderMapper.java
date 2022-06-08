package com.sofkaU.storeManagement.mapper;

import com.sofkaU.storeManagement.collections.Provider;
import com.sofkaU.storeManagement.dto.ProviderDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class ProviderMapper {

    private final ModelMapper modelMapper;

    public Function<Provider, ProviderDto> convertEntityToDto(){
        return provider -> modelMapper.map(provider, ProviderDto.class);
    }

    public Function<ProviderDto, Provider> convertDtoToEntity(){
        return providerDto -> modelMapper.map(providerDto, Provider.class);
    }
}
