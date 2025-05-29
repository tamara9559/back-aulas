package aulas.Back.decorador;

import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;

/**
 * Decorador que añade un Proyector (Videobeam) a un aula.
 */
public class AulaProyector extends AulaDecorator {

    public AulaProyector(IAula aula) {
        super(aula);
    }

    @Override
    public List<RecursoTIC> getRecursos() {
        List<RecursoTIC> recursos = new ArrayList<>(aula.getRecursos());
        recursos.add(new RecursoTIC("PR1", "Videobeam", "Proyector 4K multimedia", EstadoRecurso.DISPONIBLE, 1));
        return recursos;
    }

    @Override
    public String descripcion() {
        return aula.descripcion() + " + Videobeam";
    }
}


