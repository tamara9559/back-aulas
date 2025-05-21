package aulas.Back.observador;

import aulas.Back.Aula;

public class NotificadorUsuarios implements ObservadorAula {

    public NotificadorUsuarios(Aula aula) {
        // Al crear el notificador, se registra como observador del aula
        aula.agregarObservador(this);
    }

    @Override
    public void actualizar(Aula aula) {
        System.out.println("Notificando cambio de estado en aula: " + aula.getNombre());
    }
}


