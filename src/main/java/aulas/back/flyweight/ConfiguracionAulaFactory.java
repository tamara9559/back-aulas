package aulas.back.flyweight;

import aulas.back.recursos.RecursoTIC;
import java.util.*;

/**
 * Fábrica Flyweight para la creación y reutilización de instancias {@link ConfiguracionAula}.
 * <p>
 * Implementa el patrón Flyweight almacenando en caché las configuraciones de aula ya creadas
 * para evitar la duplicación de objetos con la misma capacidad y conjunto de recursos TIC.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     List&lt;RecursoTIC&gt; recursos = List.of(...);
 *     ConfiguracionAula config = ConfiguracionAulaFactory.obtenerConfiguracion(30, recursos);
 * </pre>
 *
 * Si se solicita una configuración con la misma capacidad y recursos, se devuelve la instancia ya existente.
 *
 * @see ConfiguracionAula
 *
 * @author Jan
 */
public class ConfiguracionAulaFactory {
    private static final Map<String, ConfiguracionAula> cache = new HashMap<>();

    private ConfiguracionAulaFactory() {
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no debe ser instanciada.");
    }
    /**
     * Devuelve una instancia compartida de {@link ConfiguracionAula} que coincide con la capacidad y recursos especificados.
     * Si la configuración ya existe, la reutiliza; de lo contrario, la crea y la almacena en caché.
     *
     * @param capacidad capacidad máxima del aula.
     * @param recursos lista de recursos TIC del aula.
     * @return instancia compartida de {@link ConfiguracionAula}.
     */
    public static ConfiguracionAula obtenerConfiguracion(int capacidad, List<RecursoTIC> recursos) {
        String clave = generarClave(capacidad, recursos);
        return cache.computeIfAbsent(clave, k -> new ConfiguracionAula(capacidad, recursos));
    }

    /**
     * Genera una clave única para identificar la configuración a partir de la capacidad y los nombres
     * de los recursos TIC (ordenados alfabéticamente).
     *
     * @param capacidad capacidad del aula.
     * @param recursos lista de recursos TIC.
     * @return clave única para la configuración.
     */
    private static String generarClave(int capacidad, List<RecursoTIC> recursos) {
        return capacidad + "-" + recursos.stream().map(RecursoTIC::getNombre).sorted().toList();
    }
}