package com.enviro.assessment.grad001.sikhoqangule.config;

import com.enviro.assessment.grad001.sikhoqangule.model.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.model.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.model.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.sikhoqangule.persistence.RecyclingTipRepository;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DatabaseConfiguration {
    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository categoryRepository,
                                   DisposalGuidelineRepository guidelineRepository,
                                   RecyclingTipRepository tipRepository) {
        return args -> {
            WasteCategory paper = categoryRepository.save(new WasteCategory(null, "Paper", "Normal paper"));
            WasteCategory organic = categoryRepository.save(new WasteCategory(null, "Organic", "Waste from food and gardens"));

            guidelineRepository.save(new DisposalGuideline(null, "Place in blue bin", paper.getId()));
            guidelineRepository.save(new DisposalGuideline(null, "Collect in designated container", organic.getId()));

            tipRepository.save(new RecyclingTip(null, "Check for contamination before recycling", paper.getId()));
            tipRepository.save(new RecyclingTip(null, "Make garden compost", organic.getId()));
        };
    }
}
