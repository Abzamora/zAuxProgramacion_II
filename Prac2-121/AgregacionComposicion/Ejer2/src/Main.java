public class Main{
    public static void main(String[] args) {
        //a
        Departamento depa1 = new Departamento("Ventas", "Comercial");
        Departamento depa2 = new Departamento("IT","Tecnologia");

        depa1.agregarEmpleado(new Empleado("Ana López", "Vendedora", 2500));
        depa1.agregarEmpleado(new Empleado("Carlos Ruiz", "Supervisor", 3500));
        depa1.agregarEmpleado(new Empleado("Marta Gómez", "Analista", 3000));
        depa1.agregarEmpleado(new Empleado("Luis Pérez", "Vendedor", 2400));
        depa1.agregarEmpleado(new Empleado("Sofía Díaz", "Coordinadora", 3200));
        //agregamos empleados a depa1 y dejamos vacio el depa2 por el momento
        System.out.println("*** ESTADO ***");
        depa1.mostrarEmpleado();
        depa2.mostrarEmpleado();
        //c
        System.out.println("*** CAMBIO SALARIO ***");
        depa1.cambiarSalario(4000);
        depa1.mostrarEmpleado();
        //d
        System.out.println("*** EMPLEADOS EN COMUN ***");
        boolean hayComun = depa1.verificaEmpleadosEnComun(depa2);
        System.out.println("¿Hay empleados en  comun entre departamentos? " + (hayComun ? "Simon" : "Nel"));
        //e
        System.out.println("*** MOVER EMPLEADO DE DEPARTAMENTO ***");
        depa1.moverEmplA(depa2);
        //mostrar
        System.out.println("*** ESTADO Final ***");
        depa1.mostrarEmpleado();
        depa2.mostrarEmpleado();
    }
}