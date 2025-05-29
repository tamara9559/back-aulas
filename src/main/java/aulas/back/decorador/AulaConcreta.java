package aulas.back.decorador;

import aulas.back.aula.Aula;
import aulas.back.recursos.RecursoTIC;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta de {@link Aula} utilizada como base para aplicar decoradores.
 * <p>
 * Esta clase representa un aula básica a la que se le pueden agregar características adicionales
 * mediante el uso del patrón Decorator (por ejemplo, aire acondicionado, proyector, etc.).
 * Sirve como punto de partida para envolver con decoradores específicos.
 * </p>
 *
 * <b>Ejemplo de uso:</b>
 * <pre>
 *     Aula aulaBase = new AulaConcreta("Aula 101");
 *     Aula aulaConAire = new AulaAireAcondicionado(aulaBase);
 *     System.out.println(aulaConAire.getDescripcion());
 * </pre>
 *
 * @author Jan
 */
public class AulaConcreta implements IAula {
    /**
     * Crea una instancia concreta de aula con el nombre especificado.
     *
     * @param nombre Nombre del aula.
     */
    private final Aula aula;

    public AulaConcreta(Aula aula) {
        this.aula = aula;
    }
    /**
     * Devuelve la descripción básica del aula concreta.
     *
     * @return Descripción del aula.
     */
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


