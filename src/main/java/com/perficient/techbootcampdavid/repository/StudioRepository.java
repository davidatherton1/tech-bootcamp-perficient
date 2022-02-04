package com.perficient.techbootcampdavid.repository;

import com.perficient.techbootcampdavid.entity.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {
    List<Studio> findByName(String name);
}
