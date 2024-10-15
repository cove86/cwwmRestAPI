package com.cwwm.cwwmapi.repositories;

import com.cwwm.cwwmapi.domain.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUserEntity, Long > {
    AppUserEntity findByUserName(String userName);
}
