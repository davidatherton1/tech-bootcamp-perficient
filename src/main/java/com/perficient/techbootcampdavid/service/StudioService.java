package com.perficient.techbootcampdavid.service;

import com.perficient.techbootcampdavid.entity.Studio;
import com.perficient.techbootcampdavid.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudioService {
    @Autowired
    private StudioRepository studioRepository;

    private final AtomicLong counter = new AtomicLong();

    public List<Studio> getStudios(){
        List<Studio> list = new ArrayList<>();
        studioRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public ResponseEntity<Void> addStudio(String name){
        Studio studio = new Studio(counter.incrementAndGet(), name);
        studioRepository.save(studio);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public Optional<Studio> getStudioById(Long id){
        return studioRepository.findById(id);
    }

    public ResponseEntity<Void> deleteStudioById(Long id){
        studioRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
