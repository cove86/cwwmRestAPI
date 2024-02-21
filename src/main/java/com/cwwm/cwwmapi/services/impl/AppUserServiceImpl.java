package com.cwwm.cwwmapi.services.impl;

import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import com.cwwm.cwwmapi.repositories.AppUserRepository;
import com.cwwm.cwwmapi.services.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {this.appUserRepository = appUserRepository;}

    @Override
    public AppUserEntity save(AppUserEntity appUserEntity){return appUserRepository.save(appUserEntity);}
}
