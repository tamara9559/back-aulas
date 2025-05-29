package aulas.Back.flyweight;

import aulas.Back.recursos.RecursoTIC;

import java.util.*;

public class ConfiguracionAulaFactory {
    private static final Map<String, ConfiguracionAula> cache = new HashMap<>();

    public static ConfiguracionAula obtenerConfiguracion(int capacidad, List<RecursoTIC> recursos) {
        String clave = generarClave(capacidad, recursos);
        return cache.computeIfAbsent(clave, k -> new ConfiguracionAula(capacidad, recursos));
    }

    private static String generarClave(int capacidad, List<RecursoTIC> recursos) {
        return capacidad + "-" + recursos.stream().map(RecursoTIC::getNombre).sorted().toList();
    }
}
