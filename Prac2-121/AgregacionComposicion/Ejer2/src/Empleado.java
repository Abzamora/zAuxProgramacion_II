public class Empleado {
    private String nombre;
    private String cargo;
    private double sueldo;

    public Empleado(String nombre, String cargo, double sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", cargo=" + cargo + ", sueldo=" + sueldo + "]";
    }
}