package com.haoshan.featurecontrolapi.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FeatureResponse {

    @JsonProperty("canAccess")
    private boolean isEnabled;

    public FeatureResponse(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
