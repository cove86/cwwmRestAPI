package com.cwwm.cwwmapi.services;

import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;

import java.util.List;
import java.util.Optional;

public interface WalkService {

    WalkEntity save(WalkEntity walkEntity);

    List<WalkEntity> findAll();

    boolean isExists(Long id);

    WalkEntity update(Long id, WalkEntity walk);

    Optional<WalkEntity> getOne(Long id);

    void delete(Long id);

}
