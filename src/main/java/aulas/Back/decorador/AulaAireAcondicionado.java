package aulas.Back.decorador;

import aulas.Back.recursos.EstadoRecurso;
import aulas.Back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;

/**
 * Decorador que añade un Aire Acondicionado a un aula.
 */
public class AulaAireAcondicionado extends AulaDecorator {

    public AulaAireAcondicionado(IAula aula) {
        super(aula);
    }

    @Override
    public List<RecursoTIC> getRecursos() {
        List<RecursoTIC> recursos = new ArrayList<>(aula.getRecursos());
        recursos.add(new RecursoTIC("AC1", "Aire Acondicionado", "Unidad de aire 18000 BTU", EstadoRecurso.DISPONIBLE, 1));
        return recursos;
    }

    @Override
    public String descripcion() {
        return aula.descripcion() + " + Aire Acondicionado";
    }
}



