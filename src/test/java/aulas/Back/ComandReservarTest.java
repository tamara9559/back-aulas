package aulas.Back;

import aulas.Back.estado.EstadoReservada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComandReservarTest {
    @Test
    void testEjecutarReserva() {
        Aula aula = new Aula("1", "Aula 1", 30, "SEDE", "TIPO", null, null);
        ComandReservar comando = new ComandReservar(aula);
        comando.ejecutar();
        assertTrue(aula.getEstadoActual() instanceof EstadoReservada);
    }
}