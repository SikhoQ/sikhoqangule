package com.enviro.assessment.grad001.sikhoqangule.service;

import com.enviro.assessment.grad001.sikhoqangule.entity.DisposalGuideline;
import com.enviro.assessment.grad001.sikhoqangule.persistence.DisposalGuidelineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DisposalGuidelineServiceTest {

    @Mock
    private DisposalGuidelineRepository repository;

    @InjectMocks
    private DisposalGuidelineService service;

    @Test
    void testGetAllGuidelines() {
        DisposalGuideline guideline = new DisposalGuideline(null, "Recycle in appropriate bin", null);
        when(repository.findAll()).thenReturn(List.of(guideline));

        List<DisposalGuideline> result = service.getAllGuidelines();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getGuideline()).isEqualTo("Recycle in appropriate bin");
    }

    @Test
    void testCreateGuideline() {
        DisposalGuideline guideline = new DisposalGuideline(null, "Dispose of in eco-friendly bin", null);
        when(repository.save(any(DisposalGuideline.class))).thenReturn(guideline);

        DisposalGuideline result = service.createGuideline(guideline);
        assertThat(result.getGuideline()).isEqualTo("Dispose of in eco-friendly bin");
    }
}
