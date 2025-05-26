package aulas.Back.observador;

import aulas.Back.aula.Aula;

/**
 * Interfaz para implementar el patrón Observador sobre objetos de tipo {@link Aula}.
 * <p>
 * Permite definir objetos que serán notificados cada vez que ocurra un cambio relevante en un aula.
 * Las clases que implementen esta interfaz deben definir la acción a realizar en el método {@code actualizar}.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     public class MiObservador implements ObservadorAula {
 *         public void actualizar(Aula aula) {
 *             // lógica de actualización
 *         }
 *     }
 * </pre>
 *
 * @author Jan
 */
public interface ObservadorAula {
    /**
     * Método invocado cuando el estado del aula observada cambia.
     *
     * @param aula Aula que ha sufrido un cambio.
     */
    void actualizar(Aula aula);
}
