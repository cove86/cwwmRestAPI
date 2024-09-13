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
                .walkStartLocation("TestStartA")
                .walkEndLocation("TestEndA")
                .duration("2hrs")
                .routeMap("TestRoute")
                .rating(3.0)
                .userId(1234L)
                .createdAt("Today")
                .build();
    }

    public static WalkDto createWalkDtoA() {
        return WalkDto.builder()
                .id(1L)
                .walkStartLocation("TestStartA")
                .walkEndLocation("TestEndA")
                .duration("2hrs")
                .routeMap("TestRoute")
                .rating(3.0)
                .userId(1234L)
                .createdAt("Today")
                .build();
    }

    public static RestaurantEntity createRestaurantEntityA() {
        return RestaurantEntity.builder()
                .id(1L)
                .restaurantName("TestA")
                .location("TestLocation")
                .description("Test Description")
                .rating(3.0)
                .addedBy(123L)
                .createdAt("Today")
                .build();
    }

    public static RestaurantDto createRestaurantDtoA() {
        return RestaurantDto.builder()
                .id(1L)
                .restaurantName("TestA")
                .location("TestLocation")
                .description("Test Description")
                .rating(3.0)
                .addedBy(123L)
                .createdAt("Today")
                .build();
    }
}

