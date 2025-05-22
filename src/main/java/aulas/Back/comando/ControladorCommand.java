package aulas.Back.comando;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manejar la ejecución y el historial de comandos sobre aulas usando el patrón Command.
 * <p>
 * Permite ejecutar comandos que implementan {@link ComandAula} y mantiene un historial de los comandos ejecutados.
 * Esto puede facilitar funcionalidades adicionales como deshacer o auditar acciones sobre aulas.
 * </p>
 *
 * Ejemplo de uso:
 * <pre>
 *     ControladorCommand controlador = new ControladorCommand();
 *     ComandAula comando = new ComandReservar(aula);
 *     controlador.ejecutar(comando);
 * </pre>
 *
 * @author Jan
 */
public class ControladorCommand {
    /** Historial de comandos ejecutados. */
    private List<ComandAula> historial = new ArrayList<>();

    /**
     * Ejecuta el comando dado y lo añade al historial.
     *
     * @param comando Comando a ejecutar sobre el aula.
     */
    public void ejecutar(ComandAula comando) {
        comando.ejecutar();
        historial.add(comando);
    }
}
