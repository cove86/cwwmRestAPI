package com.cwwm.cwwmapi.mappers.Impl;

import com.cwwm.cwwmapi.mappers.Mapper;
import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapperImpl implements Mapper<RestaurantEntity, RestaurantDto> {

    private ModelMapper modelMapper;

    public RestaurantMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDto mapTo(RestaurantEntity restaurantEntity) {
        return modelMapper.map(restaurantEntity, RestaurantDto.class);
    }

    @Override
    public RestaurantEntity mapFrom(RestaurantDto restaurantDto) {
        return modelMapper.map(restaurantDto, RestaurantEntity.class);
    }
}
