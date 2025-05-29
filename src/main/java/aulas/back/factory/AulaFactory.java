package aulas.back.factory;

import aulas.back.aula.Aula;

/**
 * Interfaz para la creación de instancias de {@link Aula} utilizando el patrón Factory.
 * <p>
 * Permite abstraer la lógica de creación de aulas, facilitando la integración con otros
 * patrones como Flyweight para reutilizar configuraciones.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     AulaFactory factory = ...;
 *     Aula aula = factory.crearAula();
 * </pre>
 *
 * @author Jan
 */
public interface AulaFactory {
    /**
     * Crea una nueva instancia de {@link Aula} utilizando la configuración definida.
     *
     * @return Aula creada.
     */
    Aula crearAula();
}

