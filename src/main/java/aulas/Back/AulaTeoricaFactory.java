package aulas.Back;

import java.util.List;
import java.util.UUID;

class AulaTeoricaFactory implements AulaFactory {
    @Override
    public Aula crearAula() {
        Aula aula = new Aula.AulaBuilder()
                .id(UUID.randomUUID().toString())
                .nombre("Aula Teórica")
                .capacidad(40)
                .tipoId("TEO")
                .build();
        aula.asignarRecursos(asignarRecursos());
        return aula;
    }

    @Override
    public List<RecursoTIC> asignarRecursos() {
        return List.of(
                new RecursoTIC("4", "Pizarra", "Pizarra blanca", true),
                new RecursoTIC("5", "Proyector", "Proyector básico", true)
        );
    }
}
