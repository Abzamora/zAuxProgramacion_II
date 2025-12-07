public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador archivo = new ArchivoTrabajador();
        Trabajador t1 = new Trabajador("Juan Perez", 1001, 2500.0);
        Trabajador t2 = new Trabajador("Ana Gomez", 1002, 3800.0);
        Trabajador t3 = new Trabajador("Luis Rojas", 1003, 2100.0);
        // b)
        archivo.guardarTrabajador(t1);
        archivo.guardarTrabajador(t2);
        archivo.guardarTrabajador(t3);

        // d)
        archivo.buscarMayorSalario();

        // c)
        archivo.aumentarSalario(1002, t2);

        // e)
        archivo.ordenarPorSalario();
//la pruebita finaaaallll
        System.out.println("\n--- ccargando desde archivo ---");
        ArchivoTrabajador nuevo = new ArchivoTrabajador();
        nuevo.cargarDesdeArchivo();
        nuevo.mostrarTodos();
    }
}