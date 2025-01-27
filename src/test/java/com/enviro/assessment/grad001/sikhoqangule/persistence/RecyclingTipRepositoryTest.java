package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecyclingTipRepositoryTest {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository; // Needed to save a valid WasteCategory

    @Test
    void testSaveAndFindTip() {
        // Create and save a valid WasteCategory
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        WasteCategory savedCategory = wasteCategoryRepository.save(category);

        // Create a RecyclingTip with the saved WasteCategory
        RecyclingTip tip = new RecyclingTip(null,"Recycle plastics in appropriate bin", savedCategory);
        RecyclingTip savedTip = recyclingTipRepository.save(tip);

        // Verify the RecyclingTip can be retrieved
        Optional<RecyclingTip> found = recyclingTipRepository.findById(savedTip.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getTip()).isEqualTo("Recycle plastics in appropriate bin");
        assertThat(found.get().getWasteCategory().getCategoryName()).isEqualTo("Plastic");
    }

    @Test
    void testDeleteTip() {
        // Create and save a valid WasteCategory
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        WasteCategory savedCategory = wasteCategoryRepository.save(category);

        // Create a RecyclingTip with the saved WasteCategory
        RecyclingTip tip = new RecyclingTip(null, "Use eco-friendly packaging", savedCategory);
        RecyclingTip savedTip = recyclingTipRepository.save(tip);

        // Delete the RecyclingTip
        recyclingTipRepository.delete(savedTip);

        // Verify the RecyclingTip is deleted
        Optional<RecyclingTip> found = recyclingTipRepository.findById(savedTip.getId());
        assertThat(found).isEmpty();
    }
}
