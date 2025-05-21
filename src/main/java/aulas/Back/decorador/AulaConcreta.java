package aulas.Back.decorador;

import aulas.Back.RecursoTIC;
import java.util.List;

public class AulaConcreta implements IAula {
    private String nombre;
    private int capacidad;
    private List<RecursoTIC> recursos;

    public AulaConcreta(String nombre, int capacidad, List<RecursoTIC> recursos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.recursos = recursos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public List<RecursoTIC> getRecursos() {
        return recursos;
    }

    @Override
    public String descripcion() {
        return "Aula base: " + nombre;
    }
}

