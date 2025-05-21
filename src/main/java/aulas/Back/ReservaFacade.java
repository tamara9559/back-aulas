package aulas.Back;

import aulas.Back.comando.ComandReservar;
import aulas.Back.comando.ControladorCommand;
import aulas.Back.estado.EstadoReservada;
import aulas.Back.validadores.ValidadorReserva;
import aulas.Back.validadores.ValidadorCapacidad;
import aulas.Back.validadores.ValidadorRecursos;
import aulas.Back.validadores.ValidadorDisponibilidad;

public class ReservaFacade {

    private ControladorCommand controlador = new ControladorCommand();

    // Configurar cadena de validadores al crear la fachada
    private ValidadorReserva validador;

    public ReservaFacade() {
        this.validador = new ValidadorCapacidad(
                new ValidadorRecursos(
                        new ValidadorDisponibilidad(null)
                )
        );
    }

    // Recibe un aula para reservar, valida, crea comando y ejecuta
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


