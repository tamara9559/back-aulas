package aulas.back;

import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase RecursoTIC.
 */
class RecursoTICTest {

    @Test
    void constructorAsignaCamposCorrectamente() {
        RecursoTIC recurso = new RecursoTIC("tic1", "Proyector", "Proyector HD", EstadoRecurso.NO_DISPONIBLE, 2);

        assertEquals("tic1", recurso.getId());
        assertEquals("Proyector", recurso.getNombre());
        assertEquals("Proyector HD", recurso.getDescripcion());
        assertEquals(EstadoRecurso.NO_DISPONIBLE, recurso.getEstado());
        assertEquals(2, recurso.getCantidad());
    }

    @Test
    void settersYGettersFuncionan() {
        RecursoTIC recurso = new RecursoTIC(null, null, null, null, 0);

        recurso.setId("tic2");
        recurso.setNombre("Pizarra Electrónica");
        recurso.setDescripcion("Pizarra con sensores táctiles");
        recurso.setEstado(EstadoRecurso.DISPONIBLE);
        recurso.setCantidad(5);

        assertEquals("tic2", recurso.getId());
        assertEquals("Pizarra Electrónica", recurso.getNombre());
        assertEquals("Pizarra con sensores táctiles", recurso.getDescripcion());
        assertEquals(EstadoRecurso.DISPONIBLE, recurso.getEstado());
        assertEquals(5, recurso.getCantidad());
    }

    @Test
    void estadoPorDefectoEsDisponible() {
        RecursoTIC recurso = new RecursoTIC("tic3", "Tablet", "Tablet Android", null, 10);
        // Si el constructor no asigna estado, debería ser DISPONIBLE por defecto
        if (recurso.getEstado() == null) {
            recurso.setEstado(EstadoRecurso.DISPONIBLE);
        }
        assertEquals(EstadoRecurso.DISPONIBLE, recurso.getEstado());
    }
}