import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Charangueria {
    public ArrayList<Charango> charangos = new ArrayList<>();

    public void agregar(Charango c) {
        charangos.add(c);
    }

    public void mostrarTodos() {
        System.out.println("=== CHARANGOS REGISTRADOS ===");
        for (Charango c : charangos) c.mostrar();
        System.out.println();
    }

    public void guardar(String archivo) {
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter(archivo)) {
            gson.toJson(this, fw);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);
        }
    }

    public void cargar(String archivo) {
        Gson gson = new Gson();
        try (FileReader fr = new FileReader(archivo)) {
            Charangueria temp = gson.fromJson(fr, Charangueria.class);
            this.charangos = temp.charangos;
        } catch (Exception e) {
            System.out.println("Error al cargar: " + e);
        }
    }

    // b)
    public void eliminarConMasDe6Rotas() {
        charangos.removeIf(c -> {
            int rotas = 0;
            for (boolean b : c.cuerdas) if (!b) rotas++;
            return rotas > 6;
        });
    }

    // c)
    public void listarPorMaterial(String material) {
        System.out.println("Charangos de material '" + material + "':");
        charangos.stream()
                .filter(c -> c.material.equalsIgnoreCase(material))
                .forEach(Charango::mostrar);
        System.out.println();
    }

    // d)
    public void buscarCon10Cuerdas() {
        System.out.println("Charangos con 10 cuerdas:");
        charangos.stream()
                .filter(c -> c.nroCuerdas == 10)
                .forEach(Charango::mostrar);
        System.out.println();
    }

    // e)
    public void ordenarPorMaterial() {
        charangos.sort(Comparator.comparing(c -> c.material.toLowerCase()));
    }
}