public class Pais {

    private int id;
    private String nombre;
    private double indiceDesarrollo;

    // Constructor vacío (requerido para frameworks, serialización, etc.)
    public Pais() {
    }

    // Constructor con parámetros
    public Pais(int id, String nombre, double indiceDesarrollo) {
        this.id = id;
        this.nombre = nombre;
        this.indiceDesarrollo = indiceDesarrollo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIndiceDesarrollo() {
        return indiceDesarrollo;
    }

    public void setIndiceDesarrollo(double indiceDesarrollo) {
        this.indiceDesarrollo = indiceDesarrollo;
    }

    // toString
    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", indiceDesarrollo=" + indiceDesarrollo +
                '}';
    }
}
