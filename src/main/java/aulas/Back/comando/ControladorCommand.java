package aulas.Back.comando;

import java.util.*;

public class ControladorCommand {
    private List<ComandoAula> historial = new ArrayList<>();

    public void ejecutar(ComandoAula comando) {
        comando.ejecutar();
        historial.add(comando);
    }
}

