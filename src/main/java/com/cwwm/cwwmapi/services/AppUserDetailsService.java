package com.cwwm.cwwmapi.services;

import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import com.cwwm.cwwmapi.domain.entities.AppUserPrincipal;
import com.cwwm.cwwmapi.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserEntity appUser = appUserRepository.findByUserName(username);
        if(appUser == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user Not Found");
        }

        return new AppUserPrincipal(appUser);
    }
}
