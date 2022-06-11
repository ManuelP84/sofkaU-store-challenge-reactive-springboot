package com.sofkaU.storeManagement.mapper;

import com.sofkaU.storeManagement.collections.Bill;
import com.sofkaU.storeManagement.dto.BillDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class BillMapper {

    private final ModelMapper modelMapper;

    public Function<Bill, BillDto> convertEntityToDto(){
        return bill -> modelMapper.map(bill, BillDto.class);
    }

    public Function<BillDto, Bill> convertDtoToEntity(){
        return billDto -> modelMapper.map(billDto, Bill.class);
    }
}
