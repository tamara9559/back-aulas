package aulas.Back;
import aulas.Back.repository.RecursoRepository;
import aulas.Back.service.RecursoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecursoServiceTest {

    private RecursoRepository recursoRepository;
    private RecursoService recursoService;

    @BeforeEach
    void setUp() {
        recursoRepository = mock(RecursoRepository.class);
        recursoService = new RecursoService(recursoRepository);
    }

    @Test
    void testListarRecursos() {
        List<RecursoTIC> recursos = List.of(new RecursoTIC("1", "Proyector", "HD", true, 5));
        when(recursoRepository.findAll()).thenReturn(recursos);

        List<RecursoTIC> result = recursoService.listarRecursos();
        assertEquals(1, result.size());
        assertEquals("Proyector", result.get(0).getNombre());
    }

    @Test
    void testCrearRecurso() {
        RecursoTIC recurso = new RecursoTIC("1", "Proyector", "HD", true, 5);
        when(recursoRepository.save(recurso)).thenReturn(recurso);

        RecursoTIC result = recursoService.crearRecurso(recurso);
        assertEquals("Proyector", result.getNombre());
    }

    @Test
    void testObtenerRecursoExists() {
        RecursoTIC recurso = new RecursoTIC("1", "Proyector", "HD", true, 5);
        when(recursoRepository.findById("1")).thenReturn(Optional.of(recurso));

        RecursoTIC result = recursoService.obtenerRecurso("1");
        assertNotNull(result);
        assertEquals("Proyector", result.getNombre());
    }

    @Test
    void testObtenerRecursoNotExists() {
        when(recursoRepository.findById("2")).thenReturn(Optional.empty());

        RecursoTIC result = recursoService.obtenerRecurso("2");
        assertNull(result);
    }

    @Test
    void testEliminarRecursoExists() {
        when(recursoRepository.existsById("1")).thenReturn(true);
        doNothing().when(recursoRepository).deleteById("1");

        boolean result = recursoService.eliminarRecurso("1");
        assertTrue(result);
    }

    @Test
    void testEliminarRecursoNotExists() {
        when(recursoRepository.existsById("2")).thenReturn(false);

        boolean result = recursoService.eliminarRecurso("2");
        assertFalse(result);
    }
}
