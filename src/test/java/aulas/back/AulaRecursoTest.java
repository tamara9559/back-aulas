package aulas.back;

import aulas.back.aula.AulaRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AulaRecursoTest {

    @Test
    void constructorCompletoAsignaCamposCorrectamente() {
        AulaRecurso ar = new AulaRecurso("id123", "aula1", "recurso1", 5);
        assertEquals("id123", ar.getId());
        assertEquals("aula1", ar.getAulaId());
        assertEquals("recurso1", ar.getRecursoId());
        assertEquals(5, ar.getCantidad());
    }

    @Test
    void constructorSinIdAsignaCamposCorrectamente() {
        AulaRecurso ar = new AulaRecurso("aula1", "recurso1", 3);
        assertNull(ar.getId());
        assertEquals("aula1", ar.getAulaId());
        assertEquals("recurso1", ar.getRecursoId());
        assertEquals(3, ar.getCantidad());
    }

    @Test
    void settersYGettersFuncionanParaTodosLosCampos() {
        AulaRecurso ar = new AulaRecurso();
        ar.setId("id999");
        ar.setAulaId("aulaX");
        ar.setRecursoId("recursoY");
        ar.setCantidad(12);

        assertEquals("id999", ar.getId());
        assertEquals("aulaX", ar.getAulaId());
        assertEquals("recursoY", ar.getRecursoId());
        assertEquals(12, ar.getCantidad());
    }
}