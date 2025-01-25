package com.enviro.assessment.grad001.sikhoqangule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Tips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150)
    private String tip;

    @NotNull
    private Long wasteCategoryId;

    // default constructor is required by JPA
    public RecyclingTip() {}

    // to allow easy population when configuring db
    public RecyclingTip(String tip, Long wasteCategoryId) {
        this.tip = tip;
        this.wasteCategoryId = wasteCategoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Long getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(Long wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
    }
}