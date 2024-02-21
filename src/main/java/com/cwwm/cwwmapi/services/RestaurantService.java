package com.cwwm.cwwmapi.services;

import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    RestaurantEntity save(RestaurantEntity restaurantEntity);

    List<RestaurantEntity> findAll();

    Optional<RestaurantEntity> findOne(Long id);
    boolean isExists(Long id);

    RestaurantEntity update(Long id, RestaurantEntity restaurant);

    Optional<RestaurantEntity> getOne(Long id);

    void delete(Long id);
}
