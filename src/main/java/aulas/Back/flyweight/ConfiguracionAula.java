package aulas.Back.flyweight;

import aulas.Back.recursos.RecursoTIC;
import java.util.Collections;
import java.util.List;

public final class ConfiguracionAula {
    private final int capacidad;
    private final List<RecursoTIC> recursos;

    public ConfiguracionAula(int capacidad, List<RecursoTIC> recursos) {
        this.capacidad = capacidad;
        this.recursos = Collections.unmodifiableList(recursos);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConfiguracionAula other)) return false;
        return this.capacidad == other.capacidad && this.recursos.equals(other.recursos);
    }

    @Override
    public int hashCode() {
        return capacidad * 31 + recursos.hashCode();
    }

}


