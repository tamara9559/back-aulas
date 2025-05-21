package aulas.Back.comando;

import java.util.*;

public class ControladorCommand {
    private List<ComandAula> historial = new ArrayList<>();

    public void ejecutar(ComandAula comando) {
        comando.ejecutar();
        historial.add(comando);
    }
}

