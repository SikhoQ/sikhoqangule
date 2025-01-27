package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DisposalGuidelineRepositoryTest {

    @Autowired
    private DisposalGuidelineRepository repository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository; // Needed to save a valid WasteCategory

    @Test
    void testSaveAndFindGuideline() {
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        WasteCategory savedCategory = wasteCategoryRepository.save(category);

        DisposalGuideline guideline = new DisposalGuideline(null, "Dispose of in eco-friendly bin", savedCategory);
        DisposalGuideline saved = repository.save(guideline);

        Optional<DisposalGuideline> found = repository.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getGuideline()).isEqualTo("Dispose of in eco-friendly bin");
        assertThat(found.get().getWasteCategory().getCategoryName()).isEqualTo("Plastic");
    }

    @Test
    void testDeleteGuideline() {
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        WasteCategory savedCategory = wasteCategoryRepository.save(category);

        DisposalGuideline guideline = new DisposalGuideline(null, "Dispose of in eco-friendly bin", savedCategory);
        DisposalGuideline saved = repository.save(guideline);

        repository.delete(saved);

        Optional<DisposalGuideline> found = repository.findById(saved.getId());
        assertThat(found).isEmpty();
    }
}
