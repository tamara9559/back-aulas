package aulas.Back;

class Sede {
    private String id;
    private String nombre;
    private String ubicacion;

    public Sede(String id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

    }

    public float calcularDistancia(Sede otra) {
        return 0.0f; // simulación
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


}
