package aulas.back;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AuditoriaEventoTest {

    @Test
    void constructorDeNegocioAsignaCamposCorrectamente() {
        String tipoEntidad = "Aula";
        String entidadId = "aula123";
        String tipoOperacion = "CAMBIO_ESTADO";
        String descripcion = "El aula cambió a estado: RESERVADA";

        AuditoriaEvento evento = new AuditoriaEvento(tipoEntidad, entidadId, tipoOperacion, descripcion);

        assertNull(evento.getId());
        assertEquals(tipoEntidad, evento.getTipoEntidad());
        assertEquals(entidadId, evento.getEntidadId());
        assertEquals(tipoOperacion, evento.getTipoOperacion());
        assertEquals(descripcion, evento.getDescripcion());
        assertNotNull(evento.getFecha());
    }

    @Test
    void settersYGettersFuncionanCorrectamente() {
        AuditoriaEvento evento = new AuditoriaEvento();
        String tipoEntidad = "Aula";
        String entidadId = "aula456";
        String tipoOperacion = "CREACION";
        String descripcion = "Creación de aula";
        Date fecha = new Date();

        evento.setId("idtest");
        evento.setTipoEntidad(tipoEntidad);
        evento.setEntidadId(entidadId);
        evento.setTipoOperacion(tipoOperacion);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);

        assertEquals("idtest", evento.getId());
        assertEquals(tipoEntidad, evento.getTipoEntidad());
        assertEquals(entidadId, evento.getEntidadId());
        assertEquals(tipoOperacion, evento.getTipoOperacion());
        assertEquals(descripcion, evento.getDescripcion());
        assertEquals(fecha, evento.getFecha());
    }
}