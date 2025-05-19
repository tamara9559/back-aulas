package aulas.Back.decorador;

public abstract class AulaDecorator implements IAula {
    protected IAula aula;

    public AulaDecorator(IAula aula) {
        this.aula = aula;
    }

    public abstract String descripcion();
}

