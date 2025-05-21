package aulas.Back.decorador;

import aulas.Back.RecursoTIC;
import java.util.List;

public abstract class AulaDecorator implements IAula {
    protected IAula aula;

    public AulaDecorator(IAula aula) {
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
        return aula.getRecursos();
    }

    @Override
    public abstract String descripcion();
}


