package com.enviro.assessment.grad001.sikhoqangule.persistence;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WasteCategoryRepositoryTest {

    @Autowired
    private WasteCategoryRepository repository;

    @Test
    void testSaveAndFindWasteCategory() {
        WasteCategory category = new WasteCategory("TestCategory", "Test description");
        WasteCategory savedCategory = repository.save(category);

        Optional<WasteCategory> foundCategory = repository.findById(savedCategory.getId());
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getCategoryName()).isEqualTo("TestCategory");
    }

    @Test
    void testDeleteWasteCategory() {
        WasteCategory category = new WasteCategory("TestCategory2", "Test description 2");
        WasteCategory savedCategory = repository.save(category);

        repository.delete(savedCategory);
        Optional<WasteCategory> foundCategory = repository.findById(savedCategory.getId());
        assertThat(foundCategory).isEmpty();
    }
}
