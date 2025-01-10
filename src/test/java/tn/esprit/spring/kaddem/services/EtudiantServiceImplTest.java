package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplTest {
    @InjectMocks
    IEtudiantService etudiantService;

    @Mock
    EtudiantRepository etudiantRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRetrieveAllEtudiants() {

        Etudiant Etudiant1 = new Etudiant();
        Etudiant Etudiant2 = new Etudiant();
        when(etudiantRepository.findAll()).thenReturn(Arrays.asList(Etudiant1, Etudiant2));


        List<Etudiant> result = etudiantService.retrieveAllEtudiants();


        assertEquals(2, result.size());
        verify(etudiantRepository, times(1)).findAll();
    }
}
