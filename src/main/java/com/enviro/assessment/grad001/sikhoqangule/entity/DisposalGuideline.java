package com.enviro.assessment.grad001.sikhoqangule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String guideline;

    @NotNull
    private Long wasteCategoryId;

    // default constructor is required by JPA
    public DisposalGuideline() {}

    // to allow easy population when configuring db
    public DisposalGuideline(String guideline, Long wasteCategoryId) {
        this.guideline = guideline;
        this.wasteCategoryId = wasteCategoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public Long getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(Long wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
    }
}