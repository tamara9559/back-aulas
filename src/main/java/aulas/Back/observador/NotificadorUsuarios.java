package aulas.Back.observador;

import aulas.Back.aula.Aula;

/**
 * Observador concreto que notifica a los usuarios cuando hay un cambio de estado en un aula.
 * <p>
 * Al instanciarse, este notificador se registra automáticamente como observador del aula proporcionada.
 * Cuando se produce un cambio de estado en el aula, se dispara el método {@code actualizar},
 * donde se puede implementar la lógica de notificación a los usuarios interesados.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     Aula aula = ...;
 *     NotificadorUsuarios notificador = new NotificadorUsuarios(aula);
 * </pre>
 *
 * @author Jan
 */
public class NotificadorUsuarios implements ObservadorAula {

    /**
     * Constructor. Al crear el notificador, se registra como observador del aula indicada.
     *
     * @param aula Aula a la que se asociará este notificador.
     */
    public NotificadorUsuarios(Aula aula) {
        // Al crear el notificador, se registra como observador del aula
        aula.agregarObservador(this);
    }

    /**
     * Método invocado cuando el estado del aula cambia.
     * Aquí se puede implementar la lógica específica de notificación a los usuarios.
     *
     * @param aula Aula que ha cambiado de estado.
     */
    @Override
    public void actualizar(Aula aula) {
        System.out.println("Notificando cambio de estado en aula: " + aula.getNombre());
    }
}
