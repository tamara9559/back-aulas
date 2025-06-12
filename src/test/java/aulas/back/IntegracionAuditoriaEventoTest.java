package aulas.back;

import aulas.back.auditoria.AuditoriaEvento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegracionAuditoriaEventoTest {

    @Test
    void creaEventoDeAuditoriaPorCambioDeEstado() {
        // Simula que un aula cambia de estado y se registra auditoría
        String tipoEntidad = "Aula";
        String entidadId = "idAula";
        String tipoOperacion = "CAMBIO_ESTADO";
        String descripcion = "El aula cambió a estado: RESERVADA";

        AuditoriaEvento evento = new AuditoriaEvento(tipoEntidad, entidadId, tipoOperacion, descripcion);

        assertEquals("Aula", evento.getTipoEntidad());
        assertEquals("idAula", evento.getEntidadId());
        assertEquals("CAMBIO_ESTADO", evento.getTipoOperacion());
        assertEquals("El aula cambió a estado: RESERVADA", evento.getDescripcion());
        assertNotNull(evento.getFecha());
    }
}