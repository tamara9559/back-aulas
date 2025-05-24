package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import aulas.Back.TipoAulaEnum;

import java.util.List;
import java.util.UUID;

public class AulaTeoricaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        Aula aula = new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Teórica")
                .capacidad(40)
                .sedeId("S1")
                .tipo(TipoAulaEnum.TEORICA)
                .agregarRecurso(new RecursoTIC("4", "Pizarra", "Pizarra blanca", true, 8))
                .agregarRecurso(new RecursoTIC("5", "Proyector", "Proyector básico", true, 8))
                .build();
        return aula;
    }
}

