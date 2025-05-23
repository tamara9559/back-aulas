package aulas.Back.service;

import aulas.Back.Aula;

import java.util.*;

public class AulaService {

    private final Map<String, Aula> aulas = new HashMap<>();

    public List<Aula> listarAulas() {
        return new ArrayList<>(aulas.values());
    }

    public Aula crearAula(Aula aula) {
        aulas.put(aula.getId(), aula);
        return aula;
    }

    public Aula obtenerAula(String id) {
        return aulas.get(id);
    }

    public boolean eliminarAula(String id) {
        return aulas.remove(id) != null;
    }

    public void limpiar() {
        aulas.clear();
    }
}
