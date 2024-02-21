package com.cwwm.cwwmapi.repositories;

import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
}
