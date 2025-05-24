package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import aulas.Back.TipoAulaEnum;

import java.util.List;
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
                .agregarRecurso(new RecursoTIC("1", "Proyector", "Proyector digital", true, 8))
                .agregarRecurso(new RecursoTIC("2", "Cámara", "Cámara 4K", true, 8))
                .agregarRecurso(new RecursoTIC("3", "Micrófono", "Micrófono ambiente", true, 8))
                .build();
    }
}
