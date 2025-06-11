package aulas.back.factory;

import aulas.back.aula.Aula;
import aulas.back.aula.TipoAulaEnum;
import aulas.back.builder.AulaBuilder;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.flyweight.ConfiguracionAulaFactory;
import aulas.back.observador.AuditorEventos;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;

import java.util.List;
import java.util.UUID;

public class AulaLaboratorioFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return null;
    }

    @Override
    public Aula crearAula(AuditorEventos auditorEventos) {
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
                .build(auditorEventos);
    }

}