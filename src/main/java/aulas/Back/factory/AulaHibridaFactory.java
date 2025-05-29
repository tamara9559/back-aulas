package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;
import aulas.Back.decorador.AulaAireAcondicionado;
import aulas.Back.decorador.AulaConcreta;
import aulas.Back.decorador.AulaProyector;
import aulas.Back.decorador.IAula;

import java.util.UUID;

public class AulaHibridaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        Aula aulaBase = new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Híbrida")
                .capacidad(30)
                .sedeId("S1")
                .tipo(TipoAulaEnum.HIBRIDA)
                .build();

        IAula decorada = new AulaConcreta(aulaBase);
        decorada = new AulaAireAcondicionado(decorada);
        decorada = new AulaProyector(decorada);

        return ((AulaConcreta) decorada).getAula();

    }
}


