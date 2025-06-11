package aulas.back.decorador;

import aulas.back.recursos.EstadoRecurso;
import aulas.back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;
/**
 * Decorador concreto que añade la característica de proyector (Videobeam) a un aula.
 * <p>
 * Utiliza el patrón Decorator para extender dinámicamente la funcionalidad de un aula
 * añadiendo el recurso TIC "Videobeam" sin modificar la estructura de la clase base.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     IAula aulaBase = ...;
 *     IAula aulaConProyector = new AulaProyector(aulaBase);
 *     System.out.println(aulaConProyector.descripcion()); // Incluye "Videobeam"
 *     List&lt;RecursoTIC&gt; recursos = aulaConProyector.getRecursos(); // Incluye el proyector
 * </pre>
 *
 * @author Jan
 */
public class AulaProyector extends AulaDecorator {
    /**
     * Crea una instancia que decora el aula dada con la característica de proyector.
     *
     * @param aula Aula base a decorar, implementando la interfaz {@link IAula}.
     */
    public AulaProyector(IAula aula) {
        super(aula);
    }
    /**
     * Devuelve la lista de recursos TIC del aula, incluyendo el proyector añadido por el decorador.
     *
     * @return Lista de recursos TIC con el proyector añadido.
     */
    @Override
    public List<RecursoTIC> getRecursos() {
        List<RecursoTIC> recursos = new ArrayList<>(aula.getRecursos());
        recursos.add(new RecursoTIC("PR1", "Videobeam", "Proyector 4K multimedia", EstadoRecurso.DISPONIBLE, 1));
        return recursos;
    }
    /**
     * Devuelve la descripción del aula, agregando la mención del proyector.
     *
     * @return Descripción del aula con la característica de Videobeam.
     */
    @Override
    public String descripcion() {
        return aula.descripcion() + " + Videobeam";
    }
}


