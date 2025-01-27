package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WasteCategoryServiceTest {

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close(); // Ensure the mocks are cleaned up
    }

    @Mock
    private WasteCategoryRepository repository;

    @InjectMocks
    private WasteCategoryService service;

    @Test
    void testGetCategoryById() {
        WasteCategory category = new WasteCategory(null, "Plastic", "Plastic waste");
        when(repository.findById(1L)).thenReturn(Optional.of(category));

        WasteCategory result = service.getCategoryById(1L);
        assertThat(result.getCategoryName()).isEqualTo("Plastic");
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreateCategory() {
        WasteCategory category = new WasteCategory(null, "Paper", "Paper waste");
        when(repository.save(any(WasteCategory.class))).thenReturn(category);

        WasteCategory result = service.createCategory(category);
        assertThat(result.getCategoryName()).isEqualTo("Paper");
        verify(repository, times(1)).save(category);
    }
}
