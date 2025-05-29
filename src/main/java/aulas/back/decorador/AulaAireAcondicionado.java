package aulas.back.decorador;

import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;
/**
 * Decorador concreto que añade la característica de aire acondicionado a un aula.
 * <p>
 * Utiliza el patrón Decorator para extender la funcionalidad de {@link Aula}, permitiendo
 * agregar dinámicamente la propiedad de tener aire acondicionado sin modificar la clase base.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     Aula aulaBase = ...;
 *     Aula aulaConAire = new AulaAireAcondicionado(aulaBase);
 *     System.out.println(aulaConAire.getDescripcion()); // Incluye "Aire acondicionado"
 * </pre>
 *
 * @author Jan
 */
public class AulaAireAcondicionado extends AulaDecorator {

    /**
     * Crea una nueva instancia del decorador para añadir aire acondicionado al aula especificada.
     *
     * @param aula Aula base a decorar.
     */
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



