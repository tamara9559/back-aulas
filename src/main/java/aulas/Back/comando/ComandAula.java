package aulas.Back.comando;

/**
 * Interfaz para el patrón Command aplicada a operaciones sobre aulas.
 * <p>
 * Permite encapsular una acción o comando que puede ejecutarse sobre un aula,
 * facilitando la parametrización, el registro y la ejecución diferida de acciones.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     ComandAula comando = new ReservarAulaComando(aula);
 *     comando.ejecutar();
 * </pre>
 *
 * @author Jan
 */
public interface ComandAula {
    /**
     * Ejecuta la acción encapsulada por el comando.
     */
    void ejecutar();
}