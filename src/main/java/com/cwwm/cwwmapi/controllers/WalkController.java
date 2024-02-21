package com.cwwm.cwwmapi.controllers;

import com.cwwm.cwwmapi.domain.dto.RestaurantDto;
import com.cwwm.cwwmapi.domain.entities.RestaurantEntity;
import com.cwwm.cwwmapi.mappers.Mapper;
import com.cwwm.cwwmapi.domain.dto.WalkDto;
import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import com.cwwm.cwwmapi.services.WalkService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/walks")
public class WalkController {

    private final WalkService walkService;
    private Mapper<WalkEntity, WalkDto> walkMapper;

    WalkController(Mapper<WalkEntity, WalkDto> walkMapper, WalkService walkService) {
        this.walkMapper = walkMapper;
        this.walkService = walkService;
    }

    @PostMapping
    public ResponseEntity<WalkDto> save(@RequestBody WalkDto walkDto) {
        WalkEntity walkEntity = walkMapper.mapFrom(walkDto);
        WalkEntity savedWalkEntity = walkService.save(walkEntity);
        return new ResponseEntity(walkMapper.mapTo(savedWalkEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public List<WalkDto> listWalks() {
        List<WalkEntity> walks = walkService.findAll();
        return walks.stream()
                .map(walkMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<WalkDto> update(@PathVariable Long id, @RequestBody WalkDto walkDto){
        WalkEntity walkEntity = walkMapper.mapFrom(walkDto);
        boolean walkExists = walkService.isExists(id);
        WalkEntity savedWalkEntity = walkService.update(id, walkEntity);
        WalkDto savedUpdatedWalkDto = walkMapper.mapTo(savedWalkEntity);

        if(walkExists) {
            return new ResponseEntity(savedUpdatedWalkDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<WalkDto> getWalkById(@PathVariable Long id) {
        Optional<WalkEntity>  foundWalk = walkService.getOne(id);
        return foundWalk.map(walkEntity -> {
            WalkDto walkDto = walkMapper.mapTo(walkEntity);
            return new ResponseEntity<>(walkDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteWalk(@PathVariable Long id){
        walkService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
