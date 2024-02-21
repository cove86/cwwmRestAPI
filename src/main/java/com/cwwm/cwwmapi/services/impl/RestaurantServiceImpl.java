package com.cwwm.cwwmapi.services.impl;

import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.repositories.RestaurantRepository;
import com.cwwm.cwwmapi.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;


    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantEntity save(RestaurantEntity restaurantEntity) {
        return restaurantRepository.save(restaurantEntity);
    }

    @Override
    public RestaurantEntity update(Long id, RestaurantEntity restaurant){
        restaurant.setId(id);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<RestaurantEntity> getOne(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<RestaurantEntity> findAll() {
        return StreamSupport
                .stream(
                        restaurantRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RestaurantEntity> findOne(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return restaurantRepository.existsById(id);
    }

    @Override
    public void delete(Long id){
        restaurantRepository.deleteById(id);
    }
}
