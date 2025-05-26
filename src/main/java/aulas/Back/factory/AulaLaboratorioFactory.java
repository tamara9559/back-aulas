package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;
import aulas.Back.aula.TipoAulaEnum;

import java.util.UUID;

public class AulaLaboratorioFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula de Laboratorio")
                .capacidad(25)
                .sedeId("S1")
                .tipo(TipoAulaEnum.LABORATORIO)
                .agregarRecurso(new RecursoTIC("6", "Computadores", "PCs de alto rendimiento", EstadoRecurso.DISPONIBLE, 8))
                .agregarRecurso(new RecursoTIC("7", "Red LAN", "Conexión LAN dedicada", EstadoRecurso.DISPONIBLE, 8))
                .agregarRecurso(new RecursoTIC("8", "Proyector", "Proyector multimedia", EstadoRecurso.DISPONIBLE, 8))
                .build();
    }
}

