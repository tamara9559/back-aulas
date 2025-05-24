package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import aulas.Back.TipoAulaEnum;

import java.util.List;
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
                .agregarRecurso(new RecursoTIC("6", "Computadores", "PCs de alto rendimiento", true, 8))
                .agregarRecurso(new RecursoTIC("7", "Red LAN", "Conexión LAN dedicada", true, 8))
                .agregarRecurso(new RecursoTIC("8", "Proyector", "Proyector multimedia", true, 8))
                .build();
    }
}

