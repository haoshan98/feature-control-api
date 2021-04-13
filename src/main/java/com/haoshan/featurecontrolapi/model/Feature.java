package com.haoshan.featurecontrolapi.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "Feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    public Feature(){

    }

    public Feature(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
