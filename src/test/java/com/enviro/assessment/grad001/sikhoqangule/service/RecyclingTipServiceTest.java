package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.entity.RecyclingTip;
import com.enviro.assessment.grad001.sikhoqangule.persistence.RecyclingTipRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecyclingTipServiceTest {

    @Mock
    private RecyclingTipRepository repository;

    @InjectMocks
    private RecyclingTipService service;

    @Test
    void testGetAllRecyclingTips() {
        RecyclingTip tip = new RecyclingTip(null, "Recycle plastics in appropriate bin", null);
        when(repository.findAll()).thenReturn(List.of(tip));

        List<RecyclingTip> result = service.getAllTips();
        assertThat(result).hasSize(1);
        assertThat(result.getFirst().getTip()).isEqualTo("Recycle plastics in appropriate bin");
    }

    @Test
    void testCreateRecyclingTip() {
        RecyclingTip tip = new RecyclingTip(null, "Use eco-friendly packaging", null);
        when(repository.save(any(RecyclingTip.class))).thenReturn(tip);

        RecyclingTip result = service.createTip(tip);
        assertThat(result.getTip()).isEqualTo("Use eco-friendly packaging");
    }
}
