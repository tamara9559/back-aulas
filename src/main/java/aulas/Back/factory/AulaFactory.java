package aulas.Back.factory;

import aulas.Back.Aula;
import aulas.Back.RecursoTIC;
import java.util.List;

interface AulaFactory {
    Aula crearAula();
    List<RecursoTIC> asignarRecursos();
}


