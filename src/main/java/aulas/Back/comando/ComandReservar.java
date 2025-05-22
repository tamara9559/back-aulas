package aulas.Back.comando;

import aulas.Back.Aula;
import aulas.Back.estado.EstadoReservada;

/**
 * Comando concreto que implementa la acción de reservar un aula.
 * <p>
 * Utiliza el patrón Command para encapsular la operación de cambiar el estado de un aula a "reservada".
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     Aula aula = ...;
 *     ComandAula comando = new ComandReservar(aula);
 *     comando.ejecutar();
 * </pre>
 *
 * @author Jan
 */
public class ComandReservar implements ComandAula {
    /** Aula sobre la que se ejecutará la acción de reservar. */
    private Aula aula;

    /**
     * Crea un comando para reservar el aula especificada.
     *
     * @param aula Aula a reservar.
     */
    public ComandReservar(Aula aula) {
        this.aula = aula;
    }

    /**
     * Ejecuta el comando, cambiando el estado del aula a {@link EstadoReservada}.
     */
    @Override
    public void ejecutar() {
        aula.cambiarEstado(new EstadoReservada());
    }
}

