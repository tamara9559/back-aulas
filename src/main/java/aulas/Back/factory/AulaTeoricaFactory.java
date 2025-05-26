package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;
import aulas.Back.aula.TipoAulaEnum;

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
                .agregarRecurso(new RecursoTIC("4", "Pizarra", "Pizarra blanca", EstadoRecurso.DISPONIBLE, 8))
                .agregarRecurso(new RecursoTIC("5", "Proyector", "Proyector básico", EstadoRecurso.DISPONIBLE, 8))
                .build();
        return aula;
    }
}

