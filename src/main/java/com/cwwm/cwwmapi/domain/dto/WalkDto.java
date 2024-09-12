package com.cwwm.cwwmapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalkDto {

    private Long id;

    private Long userId;

    private String walkStartLocation;

    private String walkEndLocation;

    private String duration;

    private String routeMap;

    private Double rating;

    private String createdAt;


}
