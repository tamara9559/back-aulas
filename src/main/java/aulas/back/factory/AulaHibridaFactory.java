package aulas.back.factory;

import aulas.back.aula.Aula;
import aulas.back.aula.TipoAulaEnum;
import aulas.back.aula.AulaBuilder;
import aulas.back.decorador.AulaAireAcondicionado;
import aulas.back.decorador.AulaConcreta;
import aulas.back.decorador.AulaProyector;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.flyweight.ConfiguracionAulaFactory;
import aulas.back.auditoria.AuditorEventos;
import aulas.back.recursos.RecursoTIC;

import java.util.List;
import java.util.UUID;

/**
 * Fábrica concreta que implementa {@link AulaFactory} para crear aulas híbridas.
 * <p>
 * Utiliza el patrón Factory Method junto con Builder, Flyweight y Decorator para componer
 * un aula híbrida con características y recursos predefinidos, como proyector y aire acondicionado.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     AulaFactory factory = new AulaHibridaFactory();
 *     Aula aulaHibrida = factory.crearAula();
 * </pre>
 *
 * @author Jan
 */
public class AulaHibridaFactory implements AulaFactory {

    @Override
    public Aula crearAula() {
        return null;
    }

    /**
     * Crea una nueva instancia de {@link Aula} de tipo híbrida,
     * equipada con proyector y aire acondicionado.
     *
     * @return Aula híbrida configurada.
     */
    @Override
    public Aula crearAula(AuditorEventos auditorEventos) {
        // Recursos base: proyector y aire acondicionado
        List<RecursoTIC> recursosBase = List.of(
                new RecursoTIC("1", "Proyector", "Proyector digital", null, 1),
                new RecursoTIC("2", "Aire Acondicionado", "Aire tipo split", null, 1)
        );
        // Patrón Flyweight para configuración de aula
        ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(30, recursosBase);
        // Patrón Builder para construir el aula base
        Aula aulaBase = new AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Híbrida")
                .capacidad(config.getCapacidad())
                .sedeId("S1")
                .tipo(TipoAulaEnum.HIBRIDA)
                .configuracion(config)
                .build(auditorEventos);
        // Patrón Decorator para agregar funcionalidad y recursos
        new AulaAireAcondicionado(new AulaProyector(new AulaConcreta(aulaBase)));
        // Recupera la lista de recursos ya decorados (no se usa en la instancia base)


        return aulaBase;
    }
}





