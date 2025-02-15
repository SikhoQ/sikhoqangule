package com.enviro.assessment.grad001.sikhoqangule.config;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * Configuration class for initializing the database with pre-defined waste categories,
 * disposal guidelines, and recycling tips.
 */
@Configuration
public class DatabaseConfiguration {

    /**
     * Bean method for initializing the database with waste categories and their associated
     * disposal guidelines and recycling tips.
     *
     * @param categoryRepository the repository for managing WasteCategory entities
     * @return a CommandLineRunner to run the initialization code
     */
    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository categoryRepository) {
        return args -> {
            WasteCategory paper = new WasteCategory(null, "Paper", "Normal paper");
            WasteCategory organicWaste = new WasteCategory(null, "Organic", "Waste from food and gardens");

            DisposalGuideline paperDisposalGuideline = new DisposalGuideline(null, "Place in appropriate bin", paper);
            DisposalGuideline organicWasteDisposalGuideline = new DisposalGuideline(null, "Collect in designated container", organicWaste);

            RecyclingTip paperRecyclingTip = new RecyclingTip(null, "Check for contamination before recycling", paper);
            RecyclingTip organicWasteRecyclingTip = new RecyclingTip(null, "Make garden compost", organicWaste);

            paper.getDisposalGuidelines().add(paperDisposalGuideline);
            paper.getRecyclingTips().add(paperRecyclingTip);

            organicWaste.getDisposalGuidelines().add(organicWasteDisposalGuideline);
            organicWaste.getRecyclingTips().add(organicWasteRecyclingTip);

            categoryRepository.saveAll(List.of(paper, organicWaste));
        };
    }
}