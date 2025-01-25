package com.enviro.assessment.grad001.sikhoqangule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(max = 255)
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisposalGuideline> disposalGuidelines = new ArrayList<>();

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    // default constructor is required by JPA
    public WasteCategory() {}

    // to allow easy population when configuring db
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

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
