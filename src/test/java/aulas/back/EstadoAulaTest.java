package aulas.back;

import aulas.back.estado.EstadoAulaEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstadoAulaTest {

    @Test
    void valoresEnumSonCorrectos() {
        assertNotNull(EstadoAulaEnum.LIBRE);
        assertNotNull(EstadoAulaEnum.RESERVADA);
        assertNotNull(EstadoAulaEnum.EN_MANTENIMIENTO);
    }

    @Test
    void valueOfDevuelveElEnumCorrecto() {
        assertEquals(EstadoAulaEnum.LIBRE, EstadoAulaEnum.valueOf("LIBRE"));
        assertEquals(EstadoAulaEnum.RESERVADA, EstadoAulaEnum.valueOf("RESERVADA"));
    }
}