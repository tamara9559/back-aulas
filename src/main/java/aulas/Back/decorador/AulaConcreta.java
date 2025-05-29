package aulas.Back.decorador;

import aulas.Back.aula.Aula;
import aulas.Back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador de un objeto Aula a la interfaz IAula para aplicar decoradores.
 */
public class AulaConcreta implements IAula {

    private final Aula aula;

    public AulaConcreta(Aula aula) {
        this.aula = aula;
    }

    @Override
    public String getNombre() {
        return aula.getNombre();
    }

    @Override
    public int getCapacidad() {
        return aula.getCapacidad();
    }

    @Override
    public List<RecursoTIC> getRecursos() {
        return new ArrayList<>(); 
    }


    @Override
    public String descripcion() {
        return "Aula base: " + aula.getNombre();
    }

    public Aula getAula() {
        return aula;
    }
}


