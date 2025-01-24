package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.model.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.persistence.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public Optional<DisposalGuideline> getGuidelineById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline createGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public DisposalGuideline updateGuideline(Long id, DisposalGuideline disposalGuidelineUpdate) {
        DisposalGuideline disposalGuideline = repository.findById(id).orElseThrow(() -> new RuntimeException("Disposal guideline not found"));
        disposalGuideline.setGuideline(disposalGuidelineUpdate.getGuideline());
        disposalGuideline.setWasteCategoryId(disposalGuidelineUpdate.getWasteCategoryId());
        return repository.save(disposalGuideline);
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }
}