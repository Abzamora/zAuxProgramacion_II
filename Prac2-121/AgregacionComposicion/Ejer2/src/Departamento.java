import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private String area;
    private List<Empleado> empleados;

    public Departamento(String nombre, String area){
        this.nombre = nombre;
        this.area = area;
        this.empleados = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void mostrarEmpleado(){
        System.out.println("\nDepartamento: " + this.nombre+"("+this.area+")");
        if (empleados.isEmpty()){
            System.out.println("No tiene empleados asignados");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : empleados) {
                System.out.println(" - "+empleado);
            }
        }
        System.out.println("\n");
    }
    public void cambiarSalario(double nSueldo){
        for(Empleado empleado : empleados){
            empleado.setSueldo(nSueldo);
        }
        System.out.println("Salarios actualizados a "+nSueldo+" para los empleados de '"+this.nombre+"'.");
    }
    public boolean verificaEmpleadosEnComun(Departamento otro){
        for (Empleado empleado1 : empleados) {
            for (Empleado empleado2 : otro.getEmpleados()) {
                if (empleado1.getNombre().equals(empleado2.getNombre())){
                    return true;
                }
            }
        }
        return false;
    }
    public void moverEmplA(Departamento destino){
        for(Empleado empleado : empleados) {
            destino.agregarEmpleado(empleado);
        }
        empleados.clear();
        System.out.println("fueron removidos los empleados de '"+nombre+"' a '"+destino.getNombre()+"'.");
    }
    @Override
    public String toString() {
        return "Departamento{nombre=" + nombre + ", area=" +  area + ", empleados=" + empleados + empleados.size()+"}";
    }
}
