package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EquipeServiceImplTest {
    @InjectMocks
    IEquipeService equipeService;

    @Mock
    EquipeRepository equipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRetrieveAllEquipes() {

        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        when(equipeRepository.findAll()).thenReturn(Arrays.asList(equipe1, equipe2));


        List<Equipe> result = equipeService.retrieveAllEquipes();


        assertEquals(2, result.size());
        verify(equipeRepository, times(1)).findAll();
    }
}
