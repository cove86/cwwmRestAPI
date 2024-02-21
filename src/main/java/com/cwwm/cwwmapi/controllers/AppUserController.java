package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.domain.dto.AppUserDto;
import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.mappers.Mapper;
import com.cwwm.cwwmapi.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;

    private final Mapper<AppUserEntity, AppUserDto> appUserMapper;

    AppUserController(Mapper<AppUserEntity, AppUserDto> appUserMapper, AppUserService appUserService) {
        this.appUserMapper = appUserMapper;
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<AppUserDto> save(@RequestBody AppUserDto appUser) {
        AppUserEntity appUserEntity = appUserMapper.mapFrom(appUser);
        AppUserEntity savedAppUserEntity = appUserService.save(appUserEntity);
        return new ResponseEntity(appUserMapper.mapTo(savedAppUserEntity), HttpStatus.CREATED);
    }
}
