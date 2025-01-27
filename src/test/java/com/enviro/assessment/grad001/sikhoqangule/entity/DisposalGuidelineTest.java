package com.enviro.assessment.grad001.sikhoqangule.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DisposalGuidelineTest {

    @Test
    void testGuidelineCreation() {
        WasteCategory category = new WasteCategory(null, "Paper", "Paper waste");
        DisposalGuideline guideline = new DisposalGuideline(null, "Recycle in appropriate bin", category);

        assertThat(guideline.getGuideline()).isEqualTo("Recycle in appropriate bin");
        assertThat(guideline.getWasteCategory().getCategoryName()).isEqualTo("Paper");
    }
}
