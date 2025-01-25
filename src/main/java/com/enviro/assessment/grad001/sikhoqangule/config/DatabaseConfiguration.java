package com.enviro.assessment.grad001.sikhoqangule.config;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfiguration {
    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository categoryRepository) {
        return args -> {
            WasteCategory paper = new WasteCategory("Paper", "Normal paper");
            WasteCategory organicWaste = new WasteCategory("Organic", "Waste from food and gardens");

            DisposalGuideline paperDisposalGuideline = new DisposalGuideline("Place in blue bin", paper);
            DisposalGuideline organicWasteDisposalGuideline = new DisposalGuideline("Collect in designated container", organicWaste);

            RecyclingTip paperRecyclingTip = new RecyclingTip("Check for contamination before recycling", paper);
            RecyclingTip organicWasteRecyclingTip = new RecyclingTip("Make garden compost", organicWaste);

            paper.getDisposalGuidelines().add(paperDisposalGuideline);
            paper.getRecyclingTips().add(paperRecyclingTip);

            organicWaste.getDisposalGuidelines().add(organicWasteDisposalGuideline);
            organicWaste.getRecyclingTips().add(organicWasteRecyclingTip);

            categoryRepository.saveAll(List.of(paper, organicWaste));
        };
    }
}