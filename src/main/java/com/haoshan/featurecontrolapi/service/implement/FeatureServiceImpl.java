package com.haoshan.featurecontrolapi.service.implement;

import com.haoshan.featurecontrolapi.exception.CustomNotFoundException;
import com.haoshan.featurecontrolapi.model.Feature;
import com.haoshan.featurecontrolapi.repository.FeatureRepository;
import com.haoshan.featurecontrolapi.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Override
    public Feature getFeatureByName(String name) {
        return featureRepository
                .findFeatureByName(name)
                .orElseThrow(() ->
                new CustomNotFoundException("Feature: {0} could not found.", name)
        );
    }

    @Override
    public void updateOrAddFeature(Feature feature) {
        featureRepository.save(feature);
    }

}
