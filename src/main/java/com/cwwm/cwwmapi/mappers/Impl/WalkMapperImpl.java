package com.cwwm.cwwmapi.mappers.Impl;

import com.cwwm.cwwmapi.mappers.Mapper;
import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WalkMapperImpl implements Mapper<WalkEntity, WalkDto> {

    private ModelMapper modelMapper;

    public WalkMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WalkDto mapTo(WalkEntity walkEntity) {
        return modelMapper.map(walkEntity, WalkDto.class);
    }

    @Override
    public WalkEntity mapFrom(WalkDto walkDto) {
        return modelMapper.map(walkDto, WalkEntity.class);
    }
}
