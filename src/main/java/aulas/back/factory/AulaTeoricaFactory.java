package aulas.back.factory;

import aulas.back.aula.Aula;
import aulas.back.aula.TipoAulaEnum;

import java.util.UUID;

import aulas.back.builder.AulaBuilder;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.flyweight.ConfiguracionAulaFactory;
import aulas.back.observador.AuditorEventos;
import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;

import java.util.List;

/**
 * Fábrica concreta que implementa {@link AulaFactory} para crear aulas teóricas.
 * <p>
 * Utiliza el patrón Factory Method junto con Builder y Flyweight para construir un aula teórica
 * con recursos TIC básicos como pizarra y proyector, y una configuración estándar.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     AulaFactory factory = new AulaTeoricaFactory();
 *     Aula aulaTeorica = factory.crearAula();
 * </pre>
 *
 * @author Jan
 */
public class AulaTeoricaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return null;
    }

    /**
     * Crea una nueva instancia de {@link Aula} de tipo teórica,
     * equipada con pizarra y proyector.
     *
     * @return Aula teórica configurada.
     */

    @Override
    public Aula crearAula(AuditorEventos auditorEventos) {
        List<RecursoTIC> recursos = List.of(
                new RecursoTIC("1", "Pizarra", "Pizarra blanca", EstadoRecurso.DISPONIBLE, 1),
                new RecursoTIC("2", "Proyector", "Proyector básico", EstadoRecurso.DISPONIBLE, 1)
        );

        ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(40, recursos);

        return new AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Teórica")
                .capacidad(40)
                .sedeId("S1")
                .tipo(TipoAulaEnum.TEORICA)
                .configuracion(config)
                .build(auditorEventos);
    }
}


