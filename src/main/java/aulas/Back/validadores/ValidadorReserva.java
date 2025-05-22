package aulas.Back.validadores;

/**
 * Interfaz para la validación de reservas de aulas.
 * Permite implementar distintas validaciones encadenadas bajo el patrón Chain of Responsibility.
 *
 * @author Jan
 */
public interface ValidadorReserva {
    /**
     * Valida si el aula cumple con las condiciones específicas de este validador.
     *
     * @param aula Aula a validar.
     * @return {@code true} si el aula pasa la validación, {@code false} en caso contrario.
     */
    boolean validar(aulas.Back.Aula aula);
}
