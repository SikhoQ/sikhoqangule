package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.service.RecyclingTipService;
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

@WebMvcTest(controllers = RecyclingTipController.class)
class RecyclingTipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecyclingTipService recyclingTipService;

    @Test
    void testGetAllRecyclingTips() throws Exception {
        RecyclingTip tip = new RecyclingTip(null, "Recycle plastics in appropriate bin", null);
        when(recyclingTipService.getAllTips()).thenReturn(List.of(tip));

        mockMvc.perform(get("/api/tips"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tip").value("Recycle plastics in appropriate bin"));
    }

    @Test
    void testCreateRecyclingTip() throws Exception {
        RecyclingTip tip = new RecyclingTip(null, "Use eco-friendly packaging", null);
        when(recyclingTipService.createTip(any(RecyclingTip.class))).thenReturn(tip);

        mockMvc.perform(post("/api/tips")
                        .contentType("application/json")
                        .content("{\"tip\":\"Use eco-friendly packaging\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tip").value("Use eco-friendly packaging"));
    }
}
