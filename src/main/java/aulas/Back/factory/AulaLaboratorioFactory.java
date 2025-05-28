package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;

import java.util.UUID;

/**
 * Factory para crear una instancia preconfigurada de un Aula de tipo Laboratorio.
 * Los recursos deben asignarse posteriormente mediante AulaRecursoService.
 */
public class AulaLaboratorioFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula de Laboratorio")
                .capacidad(25)
                .sedeId("S1")
                .tipo(TipoAulaEnum.LABORATORIO)
                .build();
    }
}


