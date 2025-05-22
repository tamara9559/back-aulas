package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;

import java.util.List;
import java.util.UUID;

public class AulaHibridaFactory implements AulaFactory {
    @Override
    public Aula crearAula() {
        return new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Híbrida")
                .capacidad(30)
                .tipoId("HIB")
                .build();
    }


    private List<RecursoTIC> asignarRecursos() {
        return List.of(
                new RecursoTIC("1", "Proyector", "Proyector digital", true),
                new RecursoTIC("2", "Cámara", "Cámara 4K", true),
                new RecursoTIC("3", "Micrófono", "Micrófono ambiente", true)
        );
    }
}