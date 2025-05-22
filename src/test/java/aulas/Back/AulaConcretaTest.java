package aulas.Back;

import aulas.Back.decorador.AulaConcreta;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AulaConcretaTest {
    @Test
    void testAulaConcreta() {
        RecursoTIC Pizarro = new RecursoTIC("2", "Pizarrón", "Blanco", true);
        AulaConcreta aula = new AulaConcreta("Aula 1", 30, List.of(Pizarro));
        assertEquals("Aula 1", aula.getNombre());
        assertEquals(30, aula.getCapacidad());
        assertEquals(1, aula.getRecursos().size());
        assertTrue(aula.getRecursos().contains(Pizarro));
        assertTrue(aula.descripcion().contains("Aula base"));
    }
}