package com.haoshan.featurecontrolapi.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table (name = "UserPermission")
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int userId;
    @NotNull
    private int featureId;
    @NotNull
    private boolean isEnabled;

    public UserPermission(){

    }

    public UserPermission(int userId, int featureId, boolean isEnabled) {
        this.userId = userId;
        this.featureId = featureId;
        this.isEnabled = isEnabled;
    }
}
