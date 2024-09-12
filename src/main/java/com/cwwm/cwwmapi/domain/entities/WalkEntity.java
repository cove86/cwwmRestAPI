package com.cwwm.cwwmapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "walks")
public class WalkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String walkStartLocation;

    private String walkEndLocation;

    private String duration;

    private String routeMap;

    private Double rating;

    private String createdAt;

}
