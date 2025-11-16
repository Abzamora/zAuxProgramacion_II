public class Main {
    public static void main(String[] args) {
        Ropero ropero = new Ropero("Madera de roble");
        // b
        ropero.agregarPrenda(new Ropa("Camisa", "Algodón"));
        ropero.agregarPrenda(new Ropa("Pantalón", "Jeans"));
        ropero.agregarPrenda(new Ropa("Camisa", "Lino"));
        ropero.agregarPrenda(new Ropa("Chaqueta", "Algodón"));
        ropero.agregarPrenda(new Ropa("Camisa", "Poliéster"));
        ropero.agregarPrenda(new Ropa("Falda", "Lana"));
        ropero.mostrarTodo();
        //d material "Algodón" y tipo "Camisa"
        ropero.mostrarPorMaterialYTipo("Algodón", "Camisa");
        //c material "Algodón" o tipo "Pantalón"
        int eliminadas = ropero.eliminarPorMaterialOTipo("Algodón", "Pantalón");
        System.out.println("Se eliminaron " + eliminadas + " prendas.\n");
        ropero.mostrarTodo();
        // d
        ropero.mostrarPorMaterialYTipo("Algodón", "Camisa");
    }
}