package com.cwwm.cwwmapi.services.impl;

import com.cwwm.cwwmapi.domain.entities.WalkEntity;
import com.cwwm.cwwmapi.repositories.WalkRepository;
import com.cwwm.cwwmapi.services.WalkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WalkServiceImpl implements WalkService {

    private final WalkRepository walkRepository;

    public WalkServiceImpl(WalkRepository walkRepository) {
        this.walkRepository = walkRepository;
    }

    @Override
    public WalkEntity save(WalkEntity walkEntity) {
        return walkRepository.save(walkEntity);
    }

    @Override
    public List<WalkEntity> findAll() {
        return StreamSupport
                .stream(
                        walkRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public WalkEntity update(Long id, WalkEntity walk){
        walk.setId(id);
        return walkRepository.save(walk);

    }

    @Override
    public Optional<WalkEntity> getOne(Long id) {
        return walkRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id){
        return walkRepository.existsById(id);
    }

    @Override
    public void delete(Long id){walkRepository.deleteById(id);}

}
