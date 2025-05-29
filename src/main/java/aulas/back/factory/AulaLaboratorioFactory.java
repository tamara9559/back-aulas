package aulas.back.factory;

import aulas.back.aula.Aula;
import aulas.back.aula.TipoAulaEnum;
import aulas.back.builder.AulaBuilder;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.flyweight.ConfiguracionAulaFactory;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;

import java.util.List;
import java.util.UUID;

/**
 * Fábrica concreta que implementa {@link AulaFactory} para crear aulas de laboratorio.
 * <p>
 * Utiliza el patrón Factory Method, junto con Builder y Flyweight, para componer un aula de laboratorio
 * con recursos TIC específicos como computadores, red LAN y proyector, y una configuración predefinida.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     AulaFactory factory = new AulaLaboratorioFactory();
 *     Aula aulaLab = factory.crearAula();
 * </pre>
 *
 * @author Jan
 */
public class AulaLaboratorioFactory implements AulaFactory {

    /**
     * Crea una nueva instancia de {@link Aula} de tipo laboratorio,
     * equipada con computadores, red LAN y proyector.
     *
     * @return Aula de laboratorio configurada.
     */
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



