package com.cwwm.cwwmapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {

    private Long id;

    private String restaurantName;

    private String location;

    private String description;

    private Double rating;

    private Long addedBy;

    private String createdAt;
}
