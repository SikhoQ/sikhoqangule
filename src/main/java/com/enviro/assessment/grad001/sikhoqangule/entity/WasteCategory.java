package com.enviro.assessment.grad001.sikhoqangule.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a Waste Category.
 */
@Entity
@Table(name = "WASTE_CATEGORIES")
@Data
@NoArgsConstructor
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String categoryName;

    @NotNull
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("wasteCategory")
    private List<DisposalGuideline> disposalGuidelines = new ArrayList<>();

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("wasteCategory")
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    /**
     * Constructs a new Waste Category with the given id, name, and description.
     * Manually implemented to exclude 'disposalGuidelines' and 'recycleTips'
     *
     * @param id the unique identifier for the Waste Category
     * @param categoryName the name of the Waste Category
     * @param description a description of the Waste Category
     */
    public WasteCategory(Long id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }
}
