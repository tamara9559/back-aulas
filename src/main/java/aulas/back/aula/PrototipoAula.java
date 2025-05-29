package aulas.back.aula;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementa el patrón Prototype para la creación y gestión de prototipos de aulas.
 * <p>
 * Esta clase permite registrar instancias de {@link Aula} como prototipos asociados a una clave
 * y posteriormente clonar dichos prototipos cuando se requiera una nueva instancia con las mismas características.
 * Es útil para crear múltiples aulas similares de forma eficiente y centralizada.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     Aula aulaBase = new Aula(...);
 *     PrototipoAula.registrar("teorica", aulaBase);
 *     Aula copia = PrototipoAula.clonar("teorica");
 * </pre>
 *
 * @author Jan
 */
public class PrototipoAula{
    private static final Map<String, Aula> prototipos = new HashMap<>();

    private PrototipoAula() {
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no debe ser instanciada.");
    }

    /**
     * Registra un prototipo de aula asociándolo a una clave única.
     *
     * @param clave     Identificador único del prototipo.
     * @param prototipo Instancia de {@link Aula} que servirá como prototipo.
     */
    public static void registrar(String clave, Aula prototipo) {
        prototipos.put(clave, prototipo);
    }
    /**
     * Clona el prototipo de aula asociado a la clave especificada.
     *
     * @param clave Identificador único del prototipo a clonar.
     * @return Nueva instancia de {@link Aula} clonada del prototipo, o {@code null} si no existe el prototipo.
     */
    public static Aula clonar(String clave) {
        Aula prototipo = prototipos.get(clave);
        return prototipo != null ? prototipo.copia() : null;
    }
}

