import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArchivoTrabajador {
    private String nombreArch;
    private ArrayList<Trabajador> trabajadores;

    public ArchivoTrabajador() {
        this.nombreArch = "trabajadores.dat";
        this.trabajadores = new ArrayList<>();
    }

    // a)
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            oos.writeObject(trabajadores);
            System.out.println("Archivo '" + nombreArch + "' creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
    // b
    public void guardarTrabajador(Trabajador t) {
        trabajadores.add(t);
        crearArchivo(); // Cada vez que se guarda uno, se actualiza el archivo
        System.out.println("Trabajador guardado: " + t.getNombre());
    }
    // c)
    public void aumentarSalario(int carnet, Trabajador t) {
        if (t.getCarnet() == carnet) {
            t.setSalario(t.getSalario() * 1.10); // Aumento del 10%
            crearArchivo(); // Persistir cambio
            System.out.println("Salario aumentado para " + t.getNombre() + ". Nuevo salario: " + t.getSalario());
        }
    }

    // d)
    public Trabajador buscarMayorSalario() {
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores registrados.");
            return null;
        }
        Trabajador mayor = trabajadores.get(0);
        for (Trabajador t : trabajadores) {
            if (t.getSalario() > mayor.getSalario()) {
                mayor = t;
            }
        }
        System.out.println("Trabajador con mayor salario: " + mayor);
        return mayor;
    }
    // e)
    public void ordenarPorSalario() {
        Collections.sort(trabajadores, Comparator.comparingDouble(Trabajador::getSalario));
        System.out.println("Trabajadores ordenados por salario:");
        trabajadores.forEach(System.out::println);
        crearArchivo(); // Guardar el orden actualizado
    }
    @SuppressWarnings("unchecked")
    public void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArch))) {
            trabajadores = (ArrayList<Trabajador>) ois.readObject();
            System.out.println("Datos cargados desde el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
// muestra todos pero es opcional para las pruebas
    public void mostrarTodos() {
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores.");
        } else {
            trabajadores.forEach(System.out::println);
        }
    }
}