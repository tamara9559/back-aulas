package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;
import aulas.Back.aula.TipoAulaEnum;

import java.util.UUID;

public class AulaHibridaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Híbrida")
                .capacidad(30)
                .sedeId("S1")
                .tipo(TipoAulaEnum.HIBRIDA)
                .agregarRecurso(new RecursoTIC("1", "Proyector", "Proyector digital", EstadoRecurso.DISPONIBLE, 8))
                .agregarRecurso(new RecursoTIC("2", "Cámara", "Cámara 4K", EstadoRecurso.DISPONIBLE, 8))
                .agregarRecurso(new RecursoTIC("3", "Micrófono", "Micrófono ambiente", EstadoRecurso.DISPONIBLE, 8))
                .build();
    }
}
