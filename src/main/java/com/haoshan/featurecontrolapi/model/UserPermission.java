package com.haoshan.featurecontrolapi.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table (name = "UserPermission")
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private int userId;
    @NotBlank
    private int featureId;
    @NotBlank
    private boolean isEnabled;

    public UserPermission(){

    }

    public UserPermission(int userId, int featureId, boolean isEnabled) {
        this.userId = userId;
        this.featureId = featureId;
        this.isEnabled = isEnabled;
    }
}
