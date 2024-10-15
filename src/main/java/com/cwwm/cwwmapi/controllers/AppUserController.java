package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import com.cwwm.cwwmapi.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/register")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUserEntity register(@RequestBody AppUserEntity appUser){
        return appUserService.register(appUser);
    }
}
