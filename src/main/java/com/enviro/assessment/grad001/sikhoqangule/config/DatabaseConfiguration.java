package com.enviro.assessment.grad001.sikhoqangule.config;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.sikhoqangule.persistence.RecyclingTipRepository;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository categoryRepository,
                                   DisposalGuidelineRepository guidelineRepository,
                                   RecyclingTipRepository tipRepository) {
        return args -> {
            WasteCategory paper = categoryRepository.save(new WasteCategory("Paper", "Normal paper"));
            WasteCategory organic = categoryRepository.save(new WasteCategory("Organic", "Waste from food and gardens"));

            guidelineRepository.save(new DisposalGuideline("Place in blue bin", paper.getId()));
            guidelineRepository.save(new DisposalGuideline("Collect in designated container", organic.getId()));

            tipRepository.save(new RecyclingTip("Check for contamination before recycling", paper.getId()));
            tipRepository.save(new RecyclingTip("Make garden compost", organic.getId()));
        };
    }
}
