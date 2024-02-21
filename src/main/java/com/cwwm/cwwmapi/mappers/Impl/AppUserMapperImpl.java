package com.cwwm.cwwmapi.mappers.Impl;

import com.cwwm.cwwmapi.domain.dto.AppUserDto;
import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import com.cwwm.cwwmapi.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapperImpl implements Mapper<AppUserEntity, AppUserDto> {

    private ModelMapper modelMapper;

    public AppUserMapperImpl(ModelMapper modelMapper){this.modelMapper = modelMapper;}

    @Override
    public AppUserDto mapTo(AppUserEntity appUserEntity) {
        return modelMapper.map(appUserEntity, AppUserDto.class);
    }

    @Override
    public AppUserEntity mapFrom(AppUserDto appUserDto) {
        return modelMapper.map(appUserDto, AppUserEntity.class);
    }
}
