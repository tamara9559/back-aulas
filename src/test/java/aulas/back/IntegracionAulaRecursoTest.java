package aulas.back;

import aulas.back.aula.Aula;
import aulas.back.aula.AulaRecurso;
import aulas.back.aula.TipoAulaEnum;
import aulas.back.estado.EstadoAulaEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegracionAulaRecursoTest {

    @Test
    void agregarRecursoAAulaYVerificarCantidad() {
        // Simulación de integración: Aula + AulaRecurso
        Aula aula = new Aula(
                "id1234",           // id
                "Aula 2",          // nombre
                40,                // capacidad
                "SEDE1",           // sedeId
                TipoAulaEnum.LABORATORIO, // tipo
                EstadoAulaEnum.RESERVADA  // estado
        );
        List<AulaRecurso> recursos = new ArrayList<>();
        AulaRecurso proyector = new AulaRecurso("aula1", "proyector", 2);
        recursos.add(proyector);

        // Simulamos asignación de recursos a un aula (lógica ficticia)
        // Por ejemplo: aula.setRecursos(recursos); (si tu clase lo permite)
        // Aquí solo comprobamos el vínculo lógico
        assertEquals("aula1", proyector.getAulaId());
        assertEquals(2, proyector.getCantidad());
    }

    @Test
    void cambiarEstadoDeAulaYVerificarRecursos() {
        Aula aula = new Aula(
                "id123",           // id
                "Aula 1",          // nombre
                40,                // capacidad
                "SEDE1",           // sedeId
                TipoAulaEnum.TEORICA, // tipo
                EstadoAulaEnum.LIBRE  // estado
        );
        AulaRecurso pc = new AulaRecurso("idAula", "pc", 10);

        aula.setEstado(EstadoAulaEnum.RESERVADA);
        assertEquals(EstadoAulaEnum.RESERVADA, aula.getEstado());
        assertEquals("idAula", pc.getAulaId());
        assertEquals(10, pc.getCantidad());
    }
}