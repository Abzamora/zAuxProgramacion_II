import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Charangueria tienda = new Charangueria();

        boolean[] todasBuenas = {true,true,true,true,true,true,true,true,true,true};
        boolean[] muchasRotas = {true,false,false,false,false,false,false,false,true,false};
        boolean[] algunasRotas = {true,true,true,true,true,false,false,true,true,true};

        tienda.agregar(new Charango("Madera de pino", 10, todasBuenas));
        tienda.agregar(new Charango("Quirquincho", 10, muchasRotas));
        tienda.agregar(new Charango("Madera de nogal", 10, algunasRotas));
        tienda.agregar(new Charango("Quirquincho", 8, todasBuenas));
        tienda.agregar(new Charango("Madera de cedro", 10, todasBuenas));
        tienda.agregar(new Charango("Fibra de carbono", 10, muchasRotas));

        System.out.println("=== ESTADO INICIAL ===");
        tienda.mostrarTodos();

        // b)
        System.out.println(">>> Eliminando charangos con más de 6 cuerdas rotas...");
        tienda.eliminarConMasDe6Rotas();
        tienda.mostrarTodos();

        // c)
        tienda.listarPorMaterial("quirquincho");

        // d)
        tienda.buscarCon10Cuerdas();

        // e)
        System.out.println(">>> Ordenando por material...");
        tienda.ordenarPorMaterial();
        tienda.mostrarTodos();

        tienda.guardar("charangos.json");
        System.out.println("Datos guardados en charangos.json");

        Charangueria nueva = new Charangueria();
        nueva.cargar("charangos.json");
        System.out.println("\n=== DATOS CARGADOS DESDE ARCHIVO ===");
        nueva.mostrarTodos();
    }
}