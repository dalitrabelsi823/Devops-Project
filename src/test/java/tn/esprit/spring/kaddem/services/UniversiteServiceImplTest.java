package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UniversiteServiceImplTest {
    @InjectMocks
    IUniversiteService universiteService;

    @Mock
    UniversiteRepository universiteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRetrieveAllUniversites() {

        Universite universite1 = new Universite();
        Universite universite2 = new Universite();
        when(universiteRepository.findAll()).thenReturn(Arrays.asList(universite1, universite2));


        List<Universite> result = universiteService.retrieveAllUniversites();


        assertEquals(2, result.size());
        verify(universiteRepository, times(1)).findAll();
    }
}
