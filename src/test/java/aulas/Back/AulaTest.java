package aulas.Back;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AulaTest {

    @Test
    void testConstructorYGetters() {
        Aula aula = new Aula("1", "Aula 101", 30, "SEDE1", "TIPO1", null, List.of());
        assertEquals("1", aula.getId());
        assertEquals("Aula 101", aula.getNombre());
        assertEquals(30, aula.getCapacidad());
        assertEquals("SEDE1", aula.getSedeId());
        assertEquals("TIPO1", aula.getTipoId());
    }

    @Test
    void testSetters() {
        Aula aula = new Aula("1", "Aula 101", 30, "SEDE1", "TIPO1", null, List.of());
        aula.setNombre("Aula 102");
        aula.setCapacidad(35);
        aula.setSedeId("SEDE2");
        assertEquals("Aula 102", aula.getNombre());
        assertEquals(35, aula.getCapacidad());
        assertEquals("SEDE2", aula.getSedeId());
    }
}
