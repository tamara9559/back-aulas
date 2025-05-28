package aulas.Back.aula;

import java.util.HashMap;
import java.util.Map;

public class PrototipoAula{
    private static final Map<String, Aula> prototipos = new HashMap<>();

    public static void registrar(String clave, Aula prototipo) {
        prototipos.put(clave, prototipo);
    }

    public static Aula clonar(String clave) {
        Aula prototipo = prototipos.get(clave);
        return prototipo != null ? prototipo.clone() : null;
    }
}

