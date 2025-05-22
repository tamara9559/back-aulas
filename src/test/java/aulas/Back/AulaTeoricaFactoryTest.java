package aulas.Back;
import aulas.Back.factory.AulaFactory;
import aulas.Back.factory.AulaTeoricaFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AulaTeoricaFactoryTest {
    @Test
    void testCrearAula() {
        AulaFactory factory = new AulaTeoricaFactory();
        Aula aula = factory.crearAula();
        assertEquals("Aula Teórica", aula.getNombre());
        assertEquals(40, aula.getCapacidad());
        assertFalse(aula.getRecursos().isEmpty());
    }
}
