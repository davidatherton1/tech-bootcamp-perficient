package com.perficient.techbootcampdavid.controller;

import com.perficient.techbootcampdavid.entity.Studio;
import com.perficient.techbootcampdavid.service.StudioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/studios")
    public List<Studio> studios(){
        return studioService.getStudios();
    }

    @PostMapping("/addStudio")
    public ResponseEntity<Void> addStudio(@RequestParam(value="name", defaultValue = "No Name") String name){
        return studioService.addStudio(name);
    }

    @GetMapping("/studio/{id}")
    public Optional<Studio> getStudioById(@PathVariable Long id){
        return studioService.getStudioById(id);
    }

    @DeleteMapping("/studio/delete/{id}")
    public ResponseEntity<Void> deleteStudioById(@PathVariable Long id){
        return studioService.deleteStudioById(id);
    }
}
