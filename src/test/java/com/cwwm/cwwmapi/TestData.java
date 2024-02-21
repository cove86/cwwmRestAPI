package com.cwwm.cwwmapi;

import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;

public final class TestData {

    private TestData() {

    }

    public static WalkEntity createWalkEntityA() {
        return WalkEntity.builder()
                .id(1L)
                .walkName("TestA")
                .walkStart("TestStartA")
                .walkEnd("TestEndA")
                .rating(3.0)
                .userId("TESTA")
                .build();
    }

    public static WalkEntity createWalkEntityForRestaurantA() {
        return WalkEntity.builder()
                .id(1L)
                .walkName("TestARestaurant")
                .walkStart("TestStartARestaurant")
                .walkEnd("TestEndARestuarant")
                .rating(3.0)
                .userId("TESTARestaurant")
                .build();
    }

    public static WalkDto createWalkDtoA() {
        return WalkDto.builder()
                .id(1L)
                .walkName("TestA")
                .walkStart("TestStartA")
                .walkEnd("TestEndA")
                .rating(3.0)
                .userId("TESTA")
                .build();
    }

    public static WalkDto createWalkDtoRestaurantA() {
        return WalkDto.builder()
                .id(1L)
                .walkName("TestRestaurantA")
                .walkStart("TestStartA")
                .walkEnd("TestEndA")
                .rating(3.0)
                .userId("TESTA")
                .build();
    }

    public static RestaurantEntity createRestaurantEntityA() {
                WalkEntity walkEntity = createWalkEntityForRestaurantA();
        return RestaurantEntity.builder()
                .id(1L)
                .restaurantName("TestA")
                .rating(3.0)
                .userId("TESTA")
                .walkId(12345L)
                .build();
    }

    public static RestaurantDto createRestaurantDtoA() {
                WalkDto walkDto = createWalkDtoRestaurantA();
        return RestaurantDto.builder()
                .id(1L)
                .restaurantName("TestA")
                .rating(3.0)
                .userId("TESTA")
                .walkId(12345L)
                .build();
    }
}

