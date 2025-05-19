package aulas.Back.flyweight;

import aulas.Back.RecursoTIC;
import java.util.List;

public class ConfiguracionAula {
    public int capacidad;
    public List<RecursoTIC> recursos;

    public ConfiguracionAula(int capacidad, List<RecursoTIC> recursos) {
        this.capacidad = capacidad;
        this.recursos = recursos;
    }
}

