package aulas.Back;

import java.util.List;
import java.util.UUID;

interface AulaFactory {
    Aula crearAula();
    List<RecursoTIC> asignarRecursos();
}


