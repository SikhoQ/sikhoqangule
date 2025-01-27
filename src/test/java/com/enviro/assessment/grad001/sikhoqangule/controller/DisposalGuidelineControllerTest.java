package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.service.DisposalGuidelineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DisposalGuidelineController.class)
class DisposalGuidelineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DisposalGuidelineService disposalGuidelineService;

    @Test
    void testGetAllGuidelines() throws Exception {
        DisposalGuideline guideline = new DisposalGuideline(null, "Recycle in appropriate bin", null);
        when(disposalGuidelineService.getAllGuidelines()).thenReturn(List.of(guideline));

        mockMvc.perform(get("/api/guidelines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].guideline").value("Recycle in appropriate bin"));
    }

    @Test
    void testCreateGuideline() throws Exception {
        DisposalGuideline guideline = new DisposalGuideline(null, "Dispose of in eco-friendly bin", null);
        when(disposalGuidelineService.createGuideline(any(DisposalGuideline.class))).thenReturn(guideline);

        mockMvc.perform(post("/api/guidelines")
                        .contentType("application/json")
                        .content("{\"guideline\":\"Dispose of in eco-friendly bin\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guideline").value("Dispose of in eco-friendly bin"));
    }
}
