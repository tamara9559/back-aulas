package aulas.back;

import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ConfiguracionAula.
 */
class ConfiguracionAulaTest {

    @Test
    void constructorAsignaCamposCorrectamente() {
        List<RecursoTIC> recursos = List.of(
                new RecursoTIC("1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1),
                new RecursoTIC("2", "Pizarra", "Pizarra blanca", EstadoRecurso.DISPONIBLE, 2)
        );
        ConfiguracionAula config = new ConfiguracionAula(30, recursos);

        assertEquals(30, config.getCapacidad());
        assertEquals(recursos, config.getRecursos());
        assertTrue(config.getRecursos().containsAll(recursos));
    }

    @Test
    void recursosEsInmutable() {
        List<RecursoTIC> recursos = new ArrayList<>();
        recursos.add(new RecursoTIC("1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1));
        ConfiguracionAula config = new ConfiguracionAula(10, recursos);

        // Se intenta modificar la lista original después de crear la configuración
        recursos.add(new RecursoTIC("2", "Tablet", "Tablet Android", EstadoRecurso.DISPONIBLE, 5));
        assertEquals(1, config.getRecursos().size(), "La lista de recursos debe ser inmutable e independiente de la lista original");

        // Se intenta modificar la lista devuelta por getRecursos()
        assertThrows(UnsupportedOperationException.class, () -> {
            config.getRecursos().add(new RecursoTIC("3", "Notebook", "Notebook", EstadoRecurso.DISPONIBLE, 10));
        }, "La lista de recursos debe ser inmutable");
    }

    @Test
    void equalsYHashCodeFuncionan() {
        List<RecursoTIC> recursos1 = List.of(
                new RecursoTIC("1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1)
        );
        List<RecursoTIC> recursos2 = List.of(
                new RecursoTIC("1", "Proyector", "Proyector HD", EstadoRecurso.DISPONIBLE, 1)
        );

        ConfiguracionAula config1 = new ConfiguracionAula(20, recursos1);
        ConfiguracionAula config2 = new ConfiguracionAula(20, recursos2);

        assertEquals(config1, config2, "Configuraciones con la misma capacidad y recursos deben ser iguales");
        assertEquals(config1.hashCode(), config2.hashCode(), "El hashCode debe ser igual para objetos iguales");

        ConfiguracionAula config3 = new ConfiguracionAula(25, recursos1);
        assertNotEquals(config1, config3, "Configuraciones con diferente capacidad no deben ser iguales");
    }
}