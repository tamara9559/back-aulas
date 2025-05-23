package aulas.Back;
import aulas.Back.flyweight.ConfiguracionAula;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionAulaTest {
    @Test
    void testConstructorAndFields() {
        RecursoTIC proyector = new RecursoTIC("1", "Proyector", "HD", true);
        ConfiguracionAula conf = new ConfiguracionAula(25, List.of(proyector));
        assertEquals(25, conf.capacidad);
        assertEquals(1, conf.recursos.size());
        assertEquals("Proyector", conf.recursos.get(0).getNombre());
    }
}