package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;

import java.util.UUID;

public class AulaTeoricaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Teórica")
                .capacidad(40)
                .sedeId("S1")
                .tipo(TipoAulaEnum.TEORICA)
                .build();
    }
}


