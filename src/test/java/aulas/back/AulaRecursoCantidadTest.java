package aulas.back.aula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AulaRecursoCantidadTest {

    @Test
    void incrementarCantidadDeRecurso() {
        AulaRecurso ar = new AulaRecurso("aula1", "recurso1", 2);
        ar.setCantidad(ar.getCantidad() + 3);
        assertEquals(5, ar.getCantidad());
    }

    @Test
    void decrementarCantidadDeRecursoSinNegativo() {
        AulaRecurso ar = new AulaRecurso("aula2", "recurso2", 2);
        ar.setCantidad(Math.max(0, ar.getCantidad() - 5));
        assertEquals(0, ar.getCantidad());
    }
}
