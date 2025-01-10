package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;

import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContratServiceImplTest {
    @InjectMocks
    IContratService contratService;

    @Mock
    ContratRepository contratRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRetrieveAllContrats() {

        Contrat contrat1 = new Contrat();
        Contrat contrat2 = new Contrat();
        when(contratRepository.findAll()).thenReturn(Arrays.asList(contrat1, contrat2));


        List<Contrat> result = contratService.retrieveAllContrats();


        assertEquals(2, result.size());
        verify(contratRepository, times(1)).findAll();
    }
}
