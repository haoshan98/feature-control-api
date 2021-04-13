package com.haoshan.featurecontrolapi.repository;

import com.haoshan.featurecontrolapi.model.Feature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FeatureRepository extends CrudRepository<Feature, Integer> {

    @Query(name = "SELECT * FROM feature " +
                  "WHERE name = :name", nativeQuery = true)
    Optional<Feature> findFeatureByName(@Param("name") String name);

}
