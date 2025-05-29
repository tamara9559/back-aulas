package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;
import aulas.Back.builder.AulaBuilder;
import aulas.Back.decorador.AulaAireAcondicionado;
import aulas.Back.decorador.AulaConcreta;
import aulas.Back.decorador.AulaProyector;
import aulas.Back.decorador.IAula;
import aulas.Back.flyweight.ConfiguracionAula;
import aulas.Back.flyweight.ConfiguracionAulaFactory;
import aulas.Back.recursos.RecursoTIC;

import java.util.List;
import java.util.UUID;

public class AulaHibridaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        List<RecursoTIC> recursosBase = List.of(
                new RecursoTIC("1", "Proyector", "Proyector digital", null, 1),
                new RecursoTIC("2", "Aire Acondicionado", "Aire tipo split", null, 1)
        );
        ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(30, recursosBase);

        Aula aulaBase = new AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Híbrida")
                .capacidad(config.getCapacidad())
                .sedeId("S1")
                .tipo(TipoAulaEnum.HIBRIDA)
                .configuracion(config)
                .build();

        IAula decorada = new AulaConcreta(aulaBase);
        decorada = new AulaProyector(decorada);
        decorada = new AulaAireAcondicionado(decorada);

        List<RecursoTIC> recursos = decorada.getRecursos();

        return aulaBase;
    }
}





