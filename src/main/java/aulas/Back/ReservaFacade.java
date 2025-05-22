package aulas.Back;

import aulas.Back.comando.ComandReservar;
import aulas.Back.comando.ControladorCommand;
import aulas.Back.estado.EstadoReservada;
import aulas.Back.validadores.ValidadorReserva;
import aulas.Back.validadores.ValidadorCapacidad;
import aulas.Back.validadores.ValidadorRecursos;
import aulas.Back.validadores.ValidadorDisponibilidad;

/**
 * Fachada para gestionar el proceso de reserva de aulas.
 * <p>
 * Se encarga de validar el aula a reservar mediante una cadena de validadores
 * (Capacidad, Recursos, Disponibilidad) y, si es válida, ejecuta el comando para reservar el aula
 * utilizando un controlador de comandos.
 * </p>
 * <p>
 * Implementa el patrón de diseño Facade para simplificar la interacción con el proceso
 * de reserva y el patrón Chain of Responsibility para la validación.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     ReservaFacade reservaFacade = new ReservaFacade();
 *     boolean exito = reservaFacade.reservarAula(aula);
 * </pre>
 *
 * @author Jan
 */
public class ReservaFacade {

    /** Controlador que ejecuta los comandos relacionados con la reserva. */
    private ControladorCommand controlador = new ControladorCommand();

    /** Cadena de validadores para asegurar que el aula cumple los requisitos de reserva. */
    private ValidadorReserva validador;

    /**
     * Constructor.
     * Configura la cadena de validadores en el orden: capacidad, recursos, disponibilidad.
     */
    public ReservaFacade() {
        this.validador = new ValidadorCapacidad(
                new ValidadorRecursos(
                        new ValidadorDisponibilidad(null)
                )
        );
    }

    /**
     * Intenta reservar un aula.
     * <p>
     * Si el aula pasa todas las validaciones, crea y ejecuta el comando para reservarla.
     * </p>
     *
     * @param aula Aula a reservar.
     * @return {@code true} si la reserva fue exitosa, {@code false} si falló alguna validación.
     */
    public boolean reservarAula(Aula aula) {
        if (validador.validar(aula)) {
            // Crear comando para reservar aula y ejecutarlo a través del controlador
            ComandReservar comando = new ComandReservar(aula);
            controlador.ejecutar(comando);
            return true;
        }
        return false;
    }
}

