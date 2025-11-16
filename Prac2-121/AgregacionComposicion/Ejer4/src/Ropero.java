public class Ropero {
    private String material;
    private Ropa[] ropas;
    private int nroRopas;

    public Ropero(String material) {
        this.material = material;
        this.ropas = new Ropa[20];
        this.nroRopas = 0;
    }

    public boolean agregarPrenda(Ropa ropa) {
        if (nroRopas < 20) {
            ropas[nroRopas++] = ropa;
            return true;
        }
        System.out.println("Ropero lleno. No se puede agregar más.");
        return false;
    }

    public int eliminarPorMaterialOTipo(String mat, String tipo) {
        int eliminados = 0;
        for (int i = 0; i < nroRopas; i++) {
            Ropa r = ropas[i];
            if (r.getMaterial().equalsIgnoreCase(mat) || r.getTipo().equalsIgnoreCase(tipo)) {
                //mueve el ultimo al espacio
                ropas[i] = ropas[--nroRopas];
                ropas[nroRopas] = null;
                eliminados++;
                i--;//n esta posicion
            }
        }
        return eliminados;
    }

    public void mostrarPorMaterialYTipo(String mat, String tipo) {
        System.out.println("Prendas de material '" + mat + "' y tipo '" + tipo + "':");
        boolean encontrado = false;
        for (int i = 0; i < nroRopas; i++) {
            Ropa r = ropas[i];
            if (r.getMaterial().equalsIgnoreCase(mat) && r.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println("  - " + r);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("  (Ninguna prenda coincide)");
        }
        System.out.println();
    }

    public void mostrarTodo() {
        System.out.println("*** Contenido del ropero (" + material + ") ***");
        if (nroRopas == 0) {
            System.out.println("  (Vacío)");
        } else {
            for (int i = 0; i < nroRopas; i++) {
                System.out.println("  [" + i + "] " + ropas[i]);
            }
        }
        System.out.println("Total: " + nroRopas + " prendas\n");
    }
}
