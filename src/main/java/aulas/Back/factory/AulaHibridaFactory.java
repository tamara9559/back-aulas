package aulas.Back.factory;

import aulas.Back.aula.Aula;
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
                .build();
    }
}

