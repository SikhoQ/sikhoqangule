package com.enviro.assessment.grad001.sikhoqangule.controller;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.service.WasteCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(WasteCategoryController.class)
public class WasteCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WasteCategoryService wasteCategoryService;

    @Test
    public void testGetAllCategories() throws Exception {
        List<WasteCategory> categories = List.of(new WasteCategory("Paper", "Normal paper"));
        when(wasteCategoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].categoryName").value("Paper"));
    }

    @Test
    public void testCreateCategory() throws Exception {
        WasteCategory newCategory = new WasteCategory("Metal", "Metal waste such as cans");
        when(wasteCategoryService.createCategory(any(WasteCategory.class))).thenReturn(newCategory);

        mockMvc.perform(post("/api/categories")
                        .contentType("application/json")
                        .content("{\"categoryName\":\"Metal\",\"description\":\"Metal waste such as cans\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryName").value("Metal"));
    }

    @Test
    public void testGetCategoryById() throws Exception {
        WasteCategory category = new WasteCategory("Paper", "Normal paper");
        when(wasteCategoryService.getCategoryById(anyLong())).thenReturn(category);

        mockMvc.perform(get("/api/categories/1")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryName", is("Paper")))
                .andExpect(jsonPath("$.description", is("Normal paper")));
    }

    @Test
    public void testDeleteCategory() throws Exception {
        doNothing().when(wasteCategoryService).deleteCategory(anyLong());

        mockMvc.perform(delete("/api/categories/1")
                        .contentType("application/json"))
                .andExpect(status().isNoContent());
    }
}
