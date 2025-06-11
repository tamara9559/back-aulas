package aulas.back;

import aulas.back.aula.Aula;
import aulas.back.aula.TipoAulaEnum;
import aulas.back.estado.*;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.observador.ObservadorAula;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AulaTest {

    @Test
    void constructorVacioYSettersFuncionan() {
        Aula aula = new Aula();
        aula.setId("A1");
        aula.setNombre("Aula 101");
        aula.setCapacidad(50);
        aula.setSedeId("SEDE1");
        aula.setTipo(TipoAulaEnum.TEORICA);
        aula.setEstado(EstadoAulaEnum.RESERVADA);

        // Crear recursos TIC para la configuración
        List<RecursoTIC> recursos = new ArrayList<>();
        recursos.add(new RecursoTIC("1","Proyector","anaskas", EstadoRecurso.EN_MANTENIMIENTO, 20));
        ConfiguracionAula config = new ConfiguracionAula(50, recursos);
        aula.setConfiguracion(config);

        assertEquals("A1", aula.getId());
        assertEquals("Aula 101", aula.getNombre());
        assertEquals(50, aula.getCapacidad());
        assertEquals("SEDE1", aula.getSedeId());
        assertEquals(TipoAulaEnum.TEORICA, aula.getTipo());
        assertEquals(EstadoAulaEnum.RESERVADA, aula.getEstado());
        assertEquals(config, aula.getConfiguracion());
        assertEquals(50, aula.getConfiguracion().getCapacidad());
        assertEquals(recursos, aula.getConfiguracion().getRecursos());
    }

    @Test
    void constructorCompletoFunciona() {
        Aula aula = new Aula("A2", "Aula 102", 40, "SEDE2", TipoAulaEnum.LABORATORIO, EstadoAulaEnum.LIBRE);

        assertEquals("A2", aula.getId());
        assertEquals("Aula 102", aula.getNombre());
        assertEquals(40, aula.getCapacidad());
        assertEquals("SEDE2", aula.getSedeId());
        assertEquals(TipoAulaEnum.LABORATORIO, aula.getTipo());
        assertEquals(EstadoAulaEnum.LIBRE, aula.getEstado());
    }

    @Test
    void constructorDeCopiaFunciona() {
        Aula original = new Aula("A3", "Aula 103", 30, "SEDE3", TipoAulaEnum.HIBRIDA, EstadoAulaEnum.EN_MANTENIMIENTO);
        Aula copia = new Aula(original);

        assertEquals(original.getId(), copia.getId());
        assertEquals(original.getNombre(), copia.getNombre());
        assertEquals(original.getCapacidad(), copia.getCapacidad());
        assertEquals(original.getSedeId(), copia.getSedeId());
        assertEquals(original.getTipo(), copia.getTipo());
        assertEquals(original.getEstado(), copia.getEstado());
    }

    @Test
    void copiaMetodoCreaNuevaInstanciaIgual() {
        Aula original = new Aula("A4", "Aula 104", 25, "SEDE4", TipoAulaEnum.TEORICA, EstadoAulaEnum.INHABILITADA);
        Aula copia = original.copia();

        assertNotSame(original, copia);
        assertEquals(original.getId(), copia.getId());
        assertEquals(original.getNombre(), copia.getNombre());
        assertEquals(original.getCapacidad(), copia.getCapacidad());
        assertEquals(original.getSedeId(), copia.getSedeId());
        assertEquals(original.getTipo(), copia.getTipo());
        assertEquals(original.getEstado(), copia.getEstado());
    }

    @Test
    void getEstadoActualDevuelveInstanciaCorrecta() {
        Aula aula = new Aula();
        aula.setEstado(EstadoAulaEnum.LIBRE);
        assertInstanceOf(EstadoLibre.class, aula.getEstadoActual());

        aula.setEstado(EstadoAulaEnum.RESERVADA);
        assertInstanceOf(EstadoReservada.class, aula.getEstadoActual());

        aula.setEstado(EstadoAulaEnum.EN_MANTENIMIENTO);
        assertInstanceOf(EstadoMantenimiento.class, aula.getEstadoActual());

        aula.setEstado(EstadoAulaEnum.INHABILITADA);
        assertInstanceOf(EstadoInhabilitada.class, aula.getEstadoActual());
    }

    @Test
    void getDescripcionEstadoDevuelveDescripcionCorrecta() {
        Aula aula = new Aula();
        aula.setEstado(EstadoAulaEnum.LIBRE);
        assertEquals("Libre", aula.getDescripcionEstado());

        aula.setEstado(EstadoAulaEnum.RESERVADA);
        assertEquals("Reservada", aula.getDescripcionEstado());

        aula.setEstado(EstadoAulaEnum.EN_MANTENIMIENTO);
        assertEquals("En mantenimiento", aula.getDescripcionEstado());

        aula.setEstado(EstadoAulaEnum.INHABILITADA);
        assertEquals("no habilitada", aula.getDescripcionEstado());
    }
    @Test
    void agregarYNotificarObservadoresFunciona() {
        Aula aula = new Aula();
        final boolean[] notificado = {false};

        ObservadorAula observador = updatedAula -> notificado[0] = true;
        aula.agregarObservador(observador);
        aula.notificarObservadores();

        assertTrue(notificado[0]);
    }
}
