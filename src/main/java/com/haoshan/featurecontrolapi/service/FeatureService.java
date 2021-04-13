package com.haoshan.featurecontrolapi.service;

import com.haoshan.featurecontrolapi.model.Feature;

public interface FeatureService {

    Feature getFeatureByName(String name);

    void updateOrAddFeature(Feature feature);
}
