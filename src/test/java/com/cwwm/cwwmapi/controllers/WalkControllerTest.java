package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.TestData;
import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import com.cwwm.cwwmapi.services.WalkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class WalkControllerTest {

    private WalkService walksService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public WalkControllerTest(MockMvc mockMvc, WalkService walkService){
        this.mockMvc = mockMvc;
        this.walksService = walkService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatCreateWalkSuccessfullyReturnsHttp201() throws Exception {
        WalkEntity testWalkA = TestData.createWalkEntityA();
        testWalkA.setId(null);
        String walkJson = objectMapper.writeValueAsString(testWalkA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/walks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(walkJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }


        @Test
        @WithMockUser(roles="USER")
        public void testThatCreateWalkSuccessfullyReturnsSavedWalk() throws Exception {
            WalkDto testWalkDtoA = TestData.createWalkDtoA();
            testWalkDtoA.setId(null);
            String walkJson = objectMapper.writeValueAsString(testWalkDtoA);

            mockMvc.perform(
                    MockMvcRequestBuilders.post("/api/v1/walks")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(walkJson)
            ).andExpect(
                    MockMvcResultMatchers.jsonPath("$.id").isNumber()
            ).andExpect(MockMvcResultMatchers.jsonPath("$.walkStartLocation").value("TestStartA")
            ).andExpect(MockMvcResultMatchers.jsonPath("$.walkEndLocation").value("TestEndA")
            ).andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.0)
            ).andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1234)
            ).andExpect(MockMvcResultMatchers.jsonPath("$.duration").value("2hrs"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.routeMap").value("TestRoute"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value("Today"));

    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatGetWalksSuccessfullyReturnsHttpStatus200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/walks")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    @WithMockUser(roles="USER")
    public void testThatGetWalksSuccessfullyReturnsListOfWalks() throws Exception {
        WalkEntity walkEntity = TestData.createWalkEntityA();
        walksService.save(walkEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/walks")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.[0].id").isNumber()
                ).andExpect(MockMvcResultMatchers.jsonPath("$.[0].walkStartLocation").value("TestStartA")
                ).andExpect(MockMvcResultMatchers.jsonPath("$.[0].walkEndLocation").value("TestEndA")
                ).andExpect(MockMvcResultMatchers.jsonPath("$.[0].rating").value(3.0)
                ).andExpect(MockMvcResultMatchers.jsonPath("$.[0].userId").value(1234)
                ).andExpect(MockMvcResultMatchers.jsonPath("$.[0].duration").value("2hrs"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].routeMap").value("TestRoute"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].createdAt").value("Today"));
    }


}
