package com.sofkaU.storeManagement.mapper;

import com.sofkaU.storeManagement.collections.ReceiptOrder;
import com.sofkaU.storeManagement.dto.ReceiptOrderDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class ReceiptOrderMapper {

    private final ModelMapper modelMapper;

    public Function<ReceiptOrder, ReceiptOrderDto> convertEntityToDto(){
        return receiptOrder -> modelMapper.map(receiptOrder, ReceiptOrderDto.class);
    }

    public Function<ReceiptOrderDto, ReceiptOrder> convertDtoToEntity(){
        return receiptOrderDto -> modelMapper.map(receiptOrderDto, ReceiptOrder.class);
    }
}
