package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import com.cwwm.cwwmapi.mappers.Mapper;
import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    private Mapper<RestaurantEntity, RestaurantDto> restaurantMapper;

    RestaurantController(Mapper<RestaurantEntity, RestaurantDto> restaurantMapper, RestaurantService restaurantService) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurant) {
        RestaurantEntity restaurantEntity = restaurantMapper.mapFrom(restaurant);
        RestaurantEntity savedRestaurantEntity = restaurantService.save(restaurantEntity);
        return new ResponseEntity(restaurantMapper.mapTo(savedRestaurantEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<RestaurantDto> listRestaurants() {
        List<RestaurantEntity> restaurants = restaurantService.findAll();
        return restaurants.stream()
                .map(restaurantMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable("id") Long id ,@RequestBody RestaurantDto restaurantDto) {
        RestaurantEntity restaurantEntity = restaurantMapper.mapFrom(restaurantDto);
        boolean restaurantExists = restaurantService.isExists(id);
        RestaurantEntity savedRestaurantEntity = restaurantService.update(id, restaurantEntity);
        RestaurantDto saveUpdatedRestaurantDto = restaurantMapper.mapTo(savedRestaurantEntity);

        if(restaurantExists) {
            return new ResponseEntity(saveUpdatedRestaurantDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<RestaurantDto> getWalkById(@PathVariable("id") Long id) {
        Optional<RestaurantEntity>  foundRestaurant = restaurantService.getOne(id);
        return foundRestaurant.map(restaurantEntity -> {
            RestaurantDto restaurantDto = restaurantMapper.mapTo(restaurantEntity);
            return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(path= "/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Long id){
        restaurantService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
