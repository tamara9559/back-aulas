package aulas.back.flyweight;

import aulas.back.recursos.RecursoTIC;
import java.util.Collections;
import java.util.List;

/**
 * Representa la configuración inmutable de un aula, utilizada como Flyweight para compartir instancias
 * con la misma capacidad y recursos entre diferentes aulas.
 * <p>
 * Esto permite optimizar el uso de memoria cuando múltiples aulas comparten exactamente la misma configuración.
 * </p>
 *
 * <ul>
 *   <li>La capacidad del aula (número de personas)</li>
 *   <li>La lista de recursos TIC asociados, inmutable</li>
 * </ul>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     List&lt;RecursoTIC&gt; recursos = List.of(...);
 *     ConfiguracionAula config = new ConfiguracionAula(30, recursos);
 *     int capacidad = config.getCapacidad();
 *     List&lt;RecursoTIC&gt; recursosConfig = config.getRecursos();
 * </pre>
 *
 * @see ConfiguracionAulaFactory
 *
 * @author Jan
 */
public final class ConfiguracionAula {
    private final int capacidad;
    private final List<RecursoTIC> recursos;

    /**
     * Crea una configuración de aula con la capacidad y recursos especificados.
     * La lista de recursos es inmutable.
     *
     * @param capacidad cantidad máxima de personas que soporta el aula.
     * @param recursos lista de recursos TIC del aula.
     */
    public ConfiguracionAula(int capacidad, List<RecursoTIC> recursos) {
        this.capacidad = capacidad;
        this.recursos = Collections.unmodifiableList(recursos);
    }

    /**
     * Devuelve la capacidad máxima del aula.
     *
     * @return capacidad del aula.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Devuelve la lista inmutable de recursos TIC asociados al aula.
     *
     * @return lista de recursos TIC.
     */
    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConfiguracionAula other)) return false;
        return this.capacidad == other.capacidad && this.recursos.equals(other.recursos);
    }

    @Override
    public int hashCode() {
        return capacidad * 31 + recursos.hashCode();
    }
}


