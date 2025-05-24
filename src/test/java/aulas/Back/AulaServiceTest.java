package aulas.Back;

import aulas.Back.repository.AulaRepository;
import aulas.Back.service.AulaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AulaServiceTest {

    private AulaRepository aulaRepository;
    private AulaService aulaService;

    @BeforeEach
    void setUp() {
        aulaRepository = mock(AulaRepository.class);
        aulaService = new AulaService(aulaRepository);
    }

    @Test
    void testListarAulas() {
        List<Aula> aulas = List.of(new Aula("1", "Aula1", 30, "SEDE1", "TIPO1", null, null));
        when(aulaRepository.findAll()).thenReturn(aulas);

        List<Aula> result = aulaService.listarAulas();
        assertEquals(1, result.size());
        assertEquals("Aula1", result.get(0).getNombre());
    }

    @Test
    void testCrearAula() {
        Aula aula = new Aula("1", "Aula1", 30, "SEDE1", "TIPO1", null, null);
        when(aulaRepository.save(aula)).thenReturn(aula);

        Aula result = aulaService.crearAula(aula);
        assertEquals("Aula1", result.getNombre());
    }

    @Test
    void testObtenerAulaExists() {
        Aula aula = new Aula("1", "Aula1", 30, "SEDE1", "TIPO1", null, null);
        when(aulaRepository.findById("1")).thenReturn(Optional.of(aula));

        Aula result = aulaService.obtenerAula("1");
        assertNotNull(result);
        assertEquals("Aula1", result.getNombre());
    }

    @Test
    void testObtenerAulaNotExists() {
        when(aulaRepository.findById("2")).thenReturn(Optional.empty());

        Aula result = aulaService.obtenerAula("2");
        assertNull(result);
    }

    @Test
    void testEliminarAulaExists() {
        when(aulaRepository.existsById("1")).thenReturn(true);
        doNothing().when(aulaRepository).deleteById("1");

        boolean result = aulaService.eliminarAula("1");
        assertTrue(result);
    }

    @Test
    void testEliminarAulaNotExists() {
        when(aulaRepository.existsById("2")).thenReturn(false);

        boolean result = aulaService.eliminarAula("2");
        assertFalse(result);
    }
}