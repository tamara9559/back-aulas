package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;

import java.util.UUID;

import aulas.Back.flyweight.ConfiguracionAula;
import aulas.Back.flyweight.ConfiguracionAulaFactory;
import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;

import java.util.List;


public class AulaTeoricaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        List<RecursoTIC> recursos = List.of(
                new RecursoTIC("1", "Pizarra", "Pizarra blanca", EstadoRecurso.DISPONIBLE, 1),
                new RecursoTIC("2", "Proyector", "Proyector básico", EstadoRecurso.DISPONIBLE, 1)
        );

        ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(40, recursos);

        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Teórica")
                .capacidad(40)
                .sedeId("S1")
                .tipo(TipoAulaEnum.TEORICA)
                .configuracion(config)
                .build();
    }
}



