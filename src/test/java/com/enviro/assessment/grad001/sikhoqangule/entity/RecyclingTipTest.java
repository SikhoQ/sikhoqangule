package com.enviro.assessment.grad001.sikhoqangule.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RecyclingTipTest {

    @Test
    void testTipCreation() {
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        RecyclingTip tip = new RecyclingTip(null, "Recycle plastics in appropriate bin", category);

        assertThat(tip.getTip()).isEqualTo("Recycle plastics in appropriate bin");
        assertThat(tip.getWasteCategory().getCategoryName()).isEqualTo("Plastic");
    }
}
