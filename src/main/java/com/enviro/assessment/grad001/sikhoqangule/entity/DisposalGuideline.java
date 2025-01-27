package com.enviro.assessment.grad001.sikhoqangule.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Disposal Guideline.
 */
@Entity
@Table(name = "DISPOSAL_GUIDELINES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100, message = "Disposal guideline must be between 3 and 100 characters")
    private String guideline;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"recyclingTips", "disposalGuidelines"})
    private WasteCategory wasteCategory;
}