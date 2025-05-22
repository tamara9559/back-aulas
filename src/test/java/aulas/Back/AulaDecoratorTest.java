package aulas.Back;

import aulas.Back.decorador.AulaConcreta;
import aulas.Back.decorador.AulaDecorator;
import aulas.Back.decorador.IAula;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AulaDecoratorTest {
    static class DecoradorEjemplo extends AulaDecorator {
        public DecoradorEjemplo(IAula aula) {
            super(aula);
        }
        @Override
        public String descripcion() {
            return aula.descripcion() + " + Decorador ejemplo";
        }
    }

    @Test
    void testDecorator() {
        IAula base = new AulaConcreta("Aula 2", 20, List.of());
        IAula decorada = new DecoradorEjemplo(base);
        assertEquals("Aula 2", decorada.getNombre());
        assertEquals(20, decorada.getCapacidad());
        assertTrue(decorada.descripcion().contains("Decorador ejemplo"));
    }
}
