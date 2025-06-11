package aulas.back;

import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegracionConfiguracionAulaTest {

    @Test
    void crearConfiguracionAulaConListaDeRecursos() {
        RecursoTIC proyector = new RecursoTIC("id1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1);
        RecursoTIC pc = new RecursoTIC("id2", "PC", "PC para estudiantes", EstadoRecurso.DISPONIBLE, 10);
        RecursoTIC pizarra = new RecursoTIC("id3", "Pizarra Digital", "tablero para la clase", EstadoRecurso.DISPONIBLE, 2);

        List<RecursoTIC> recursos = Arrays.asList(proyector, pc, pizarra);
        ConfiguracionAula config = new ConfiguracionAula(30, recursos);

        assertEquals(30, config.getCapacidad());
        assertEquals(3, config.getRecursos().size());
        assertEquals("Proyector", config.getRecursos().get(0).getNombre());
        assertEquals("PC", config.getRecursos().get(1).getNombre());
        assertEquals("Pizarra Digital", config.getRecursos().get(2).getNombre());
    }

    @Test
    void losRecursosPuedenSerRecorridos() {
        RecursoTIC proyector = new RecursoTIC("id1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1);
        RecursoTIC pc = new RecursoTIC("id2", "PC", "PC para estudiantes", EstadoRecurso.DISPONIBLE, 10);
        List<RecursoTIC> recursos = Arrays.asList(proyector, pc);
        ConfiguracionAula config = new ConfiguracionAula(20, recursos);

        long cantidadPC = config.getRecursos().stream().filter(r -> r.getNombre().equals("PC")).count();
        assertEquals(1, cantidadPC);
    }
}
