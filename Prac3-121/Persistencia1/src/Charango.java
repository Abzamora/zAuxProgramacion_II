public class Charango {
    public String material;
    public int nroCuerdas;
    public boolean[] cuerdas = new boolean[10];

    public Charango() {
    }

    public Charango(String material, int nroCuerdas, boolean[] estadoCuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        System.arraycopy(estadoCuerdas, 0, this.cuerdas, 0, 10);
    }

    public void mostrar() {
        System.out.printf("Material: %s | Cuerdas: %d | Estado: ", material, nroCuerdas);
        for (boolean b : cuerdas) System.out.print(b ? "1" : "0");
        System.out.println();
    }
}
