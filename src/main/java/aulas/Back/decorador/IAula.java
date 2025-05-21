package aulas.Back.decorador;

import aulas.Back.RecursoTIC;

import java.util.List;

public interface IAula {
    String getNombre();
    int getCapacidad();
    List<RecursoTIC> getRecursos();
    String descripcion();
}

