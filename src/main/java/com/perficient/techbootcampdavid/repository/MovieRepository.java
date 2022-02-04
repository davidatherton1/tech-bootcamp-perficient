package com.perficient.techbootcampdavid.repository;

import com.perficient.techbootcampdavid.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
