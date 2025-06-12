package aulas.back.aula;

import aulas.back.estado.EstadoAulaEnum;
import aulas.back.flyweight.ConfiguracionAula;
import aulas.back.observador.AuditorEventos;

/**
 * Implementa el patrón Builder para facilitar la construcción de objetos {@link Aula}.
 * <p>
 * Permite construir instancias de {@link Aula} de manera flexible y legible,
 * especificando solo los atributos deseados en cada caso.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     Aula aula = new AulaBuilder()
 *         .id("1")
 *         .nombre("Aula 101")
 *         .capacidad(40)
 *         .sedeId("SEDE1")
 *         .tipo(TipoAulaEnum.TEORICA)
 *         .estado(EstadoAulaEnum.LIBRE)
 *         .configuracion(configuracionAula)
 *         .build(auditorEventos); // <-- PASA LA INSTANCIA INYECTADA
 * </pre>
 *
 * @author Jan
 */
public class AulaBuilder {
    private String id;
    private String nombre;
    private int capacidad;
    private String sedeId;
    private TipoAulaEnum tipo;
    private EstadoAulaEnum estado = EstadoAulaEnum.LIBRE;
    private ConfiguracionAula configuracion;

    public AulaBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AulaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AulaBuilder capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public AulaBuilder sedeId(String sedeId) {
        this.sedeId = sedeId;
        return this;
    }

    public AulaBuilder tipo(TipoAulaEnum tipo) {
        this.tipo = tipo;
        return this;
    }

    public AulaBuilder estado(EstadoAulaEnum estado) {
        this.estado = estado;
        return this;
    }

    public AulaBuilder configuracion(ConfiguracionAula config) {
        this.configuracion = config;
        return this;
    }

    /**
     * Construye una nueva instancia de {@link Aula} con los valores especificados en el builder.
     *
     * @param auditorEventos Instancia de AuditorEventos proporcionada por Spring.
     * @return Instancia de {@link Aula}.
     */
    public Aula build(AuditorEventos auditorEventos) {
        Aula aula = new Aula(id, nombre, capacidad, sedeId, tipo, estado);
        aula.setConfiguracion(configuracion);
        aula.agregarObservador(auditorEventos); // Usa la instancia inyectada
        return aula;
    }
}