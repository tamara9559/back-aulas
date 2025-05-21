package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;

import java.util.List;
import java.util.UUID;

class AulaLaboratorioFactory implements AulaFactory {
    @Override
    public Aula crearAula() {
        Aula aula = new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula de Laboratorio")
                .capacidad(25)
                .tipoId("LAB")
                .build();
        aula.asignarRecursos(asignarRecursos());
        return aula;
    }


    private List<RecursoTIC> asignarRecursos() {
        return List.of(
                new RecursoTIC("6", "Computadores", "PCs de alto rendimiento", true),
                new RecursoTIC("7", "Red LAN", "Conexión LAN dedicada", true),
                new RecursoTIC("8", "Proyector", "Proyector multimedia", true)
        );
    }
}
