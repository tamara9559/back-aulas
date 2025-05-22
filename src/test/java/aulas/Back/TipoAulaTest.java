package aulas.Back;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TipoAulaTest {

    @Test
    void testConstructorYGetters() {
        TipoAula tipoAula = new TipoAula("T1", "Teórica", "Aula para clases teóricas");
        assertEquals("T1", tipoAula.getId());
        assertEquals("Teórica", tipoAula.getNombre());
        assertEquals("Aula para clases teóricas", tipoAula.getDescripcion());
    }

    @Test
    void testSetters() {
        TipoAula tipoAula = new TipoAula("T1", "Teórica", "Aula para clases teóricas");
        tipoAula.setNombre("Laboratorio");
        tipoAula.setDescripcion("Aula para prácticas");
        assertEquals("Laboratorio", tipoAula.getNombre());
        assertEquals("Aula para prácticas", tipoAula.getDescripcion());
    }
}
