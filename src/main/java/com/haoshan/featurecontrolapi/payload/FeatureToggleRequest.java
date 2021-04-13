package com.haoshan.featurecontrolapi.payload;

import lombok.Data;

@Data
public class FeatureToggleRequest {

    private String featureName;
    private String email;
    private boolean enable;
}
