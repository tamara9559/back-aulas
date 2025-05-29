package aulas.Back.factory;

import aulas.Back.aula.Aula;
import aulas.Back.aula.TipoAulaEnum;
import aulas.Back.builder.AulaBuilder;
import aulas.Back.flyweight.ConfiguracionAula;
import aulas.Back.flyweight.ConfiguracionAulaFactory;
import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;

import java.util.List;
import java.util.UUID;

public class AulaLaboratorioFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        List<RecursoTIC> recursos = List.of(
                new RecursoTIC("6", "Computadores", "Equipos con software científico", EstadoRecurso.DISPONIBLE, 10),
                new RecursoTIC("7", "Red LAN", "Conectividad dedicada", EstadoRecurso.DISPONIBLE, 1),
                new RecursoTIC("8", "Proyector", "Proyector para visualización técnica", EstadoRecurso.DISPONIBLE, 1)
        );

        ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(25, recursos);

        return new AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula de Laboratorio")
                .capacidad(25)
                .sedeId("S1")
                .tipo(TipoAulaEnum.LABORATORIO)
                .configuracion(config)
                .build();
    }
}



