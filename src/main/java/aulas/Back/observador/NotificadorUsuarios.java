package aulas.Back.observador;

import aulas.Back.Aula;

public class NotificadorUsuarios implements ObservadorAula {
    @Override
    public void actualizar(Aula aula) {
        System.out.println("Notificando cambio de estado en aula: " + aula.getNombre());
    }
}