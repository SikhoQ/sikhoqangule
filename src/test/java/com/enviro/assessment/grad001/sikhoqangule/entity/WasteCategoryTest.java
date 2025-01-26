package com.enviro.assessment.grad001.sikhoqangule.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WasteCategoryTest {

    @Test
    void testWasteCategoryRelationships() {
        WasteCategory wasteCategory = new WasteCategory("Test category", "Test description");

        DisposalGuideline guideline = new DisposalGuideline("Test guideline", wasteCategory);
        RecyclingTip tip = new RecyclingTip("Test tip", wasteCategory);

        wasteCategory.getDisposalGuidelines().add(guideline);
        wasteCategory.getRecyclingTips().add(tip);

        assertThat(wasteCategory.getDisposalGuidelines()).contains(guideline);
        assertThat(wasteCategory.getRecyclingTips()).contains(tip);
    }
}
