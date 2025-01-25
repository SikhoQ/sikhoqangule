package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.persistence.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getTipById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip createTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public RecyclingTip updateTip(Long id, RecyclingTip recyclingTipUpdate) {
        RecyclingTip recyclingTip = repository.findById(id).orElseThrow(() -> new RuntimeException("Recycling tip not found"));
        recyclingTip.setTip(recyclingTipUpdate.getTip());
        recyclingTip.setWasteCategoryId(recyclingTipUpdate.getWasteCategoryId());
        return repository.save(recyclingTip);
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}