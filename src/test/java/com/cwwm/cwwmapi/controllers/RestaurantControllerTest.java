package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.TestData;
import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import com.cwwm.cwwmapi.services.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RestaurantControllerTest {

    private RestaurantService restaurantService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public RestaurantControllerTest (MockMvc mockMvc, RestaurantService restaurantService) {
        this.mockMvc = mockMvc;
        this.restaurantService = restaurantService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatCreateRestaurantSuccessfullyReturnsHttp201() throws Exception {
        RestaurantEntity testRestaurantA = TestData.createRestaurantEntityA();
        testRestaurantA.setId(null);
        String restaurantJson = objectMapper.writeValueAsString(testRestaurantA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(restaurantJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatCreateRestaurantSuccessfullyReturnsSavedRestaurant() throws Exception {
        RestaurantDto testRestaurantDtoA = TestData.createRestaurantDtoA();
        String walkJson = objectMapper.writeValueAsString(testRestaurantDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(walkJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.restaurantName").value("TestA")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.0)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.location").value("TestLocation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Test Description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addedBy").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value("Today"))
        ;
    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatGetRestaurantsSuccessfullyReturnsHttpStatus200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatGetRestaurantsSuccessfullyReturnsListOfRestaurants() throws Exception {
        RestaurantEntity restaurantEntity = TestData.createRestaurantEntityA();
        restaurantService.save(restaurantEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$[0].restaurantName").value("TestA")
        ).andExpect(MockMvcResultMatchers.jsonPath("$[0].rating").value(3.0)
        ).andExpect(MockMvcResultMatchers.jsonPath("$[0].addedBy").value(123L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].location").value("TestLocation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].description").value("Test Description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].createdAt").value("Today"));

    }
}
