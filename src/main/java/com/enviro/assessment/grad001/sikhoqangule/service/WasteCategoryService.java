package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import com.enviro.assessment.grad001.sikhoqangule.persistence.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Long id) {
        return repository.findById(id);
    }

    public WasteCategory createCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }

    public WasteCategory updateCategory(Long id, WasteCategory wasteCategoryUpdate) {
        WasteCategory wasteCategory = repository.findById(id).orElseThrow(() -> new RuntimeException("Waste category not found"));
        wasteCategory.setName(wasteCategoryUpdate.getName());
        wasteCategory.setDescription(wasteCategoryUpdate.getDescription());
        return repository.save(wasteCategory);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}