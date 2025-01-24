package com.enviro.assessment.grad001.sikhoqangule.model;

import jakarta.persistence.Entity;

@Entity
public class WasteCategory {

    private Long id;  // will be primary key in db

    // these will be other columns
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
