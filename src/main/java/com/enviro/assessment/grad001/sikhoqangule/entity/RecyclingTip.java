package com.enviro.assessment.grad001.sikhoqangule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RECYCLE_TIPS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 150, message = "Recycle tip must be between 3 and 150 characters")
    private String tip;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"recyclingTips", "disposalGuidelines"})
    private WasteCategory wasteCategory;
}