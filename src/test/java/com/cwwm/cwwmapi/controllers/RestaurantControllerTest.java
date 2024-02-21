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
    public void testThatCreateRestaurantSuccessfullyReturnsSavedRestaurant() throws Exception {
        RestaurantDto testRestaurantDtoA = TestData.createRestaurantDtoA();
        WalkDto createWalkDtoRestaurantA = TestData.createWalkDtoRestaurantA();
        String walkJson = objectMapper.writeValueAsString(testRestaurantDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(walkJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.restaurantName").value("TestA")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.0)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("TESTA")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.walkId").isNumber())
        ;
    }

    @Test
    public void testThatGetRestaurantsSuccessfullyReturnsHttpStatus200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
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
        ).andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value("TESTA"))
        ;

    }
}
