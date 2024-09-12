package com.cwwm.cwwmapi.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String restaurantName;

    private String location;

    private String description;

    private Double rating;

    private Long addedBy;

    private String createdAt;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "walk_id")
//    private WalkEntity walkEntity;
//    private Long walkId;

}
