package com.enviro.assessment.grad001.sikhoqangule.exception;

import com.enviro.assessment.grad001.sikhoqangule.service.DisposalGuidelineService;
import com.enviro.assessment.grad001.sikhoqangule.service.WasteCategoryService;
import com.enviro.assessment.grad001.sikhoqangule.service.RecyclingTipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WasteCategoryService wasteCategoryService;

    @MockitoBean
    private DisposalGuidelineService disposalGuidelineService;

    @MockitoBean
    private RecyclingTipService recyclingTipService;

    @Test
    void testResourceNotFound() throws Exception {
        when(wasteCategoryService.getCategoryById(1L))
                .thenThrow(new ResourceNotFoundException("Category not found"));

        mockMvc.perform(get("/api/categories/1")).andExpect(status().isNotFound());
    }
}
