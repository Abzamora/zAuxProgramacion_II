package Ejer2;

public class Bus {
    private int capacidadTotal;
    private int pasajerosActuales;
    private double totalpasaje;
    private double costoPasaje = 1.50;
    
    public Bus(int capacidadTotal) {
        this.capacidadTotal= capacidadTotal;
        this.pasajerosActuales= 0;
        this.totalpasaje =0.0;
    }
    public void mostrar(){
        System.out.println("Hay un total de "+capacidadTotal+" asientos");
    }
    
    public void subirPasajeros(int cantidad) {
        if (pasajerosActuales+cantidad<=capacidadTotal) {
            pasajerosActuales += cantidad;
            System.out.println("Subieron "+cantidad+" pasajeros. Total: " + pasajerosActuales);
        } else {
            System.out.println("No hay espacio para "+cantidad+" pasajeros");
        }
    }
    
    public void cobrarPasaje(int cantidad) {
        double total = cantidad*costoPasaje;
        totalpasaje += total;
        System.out.println("Se cobro Bs. "+total+" por "+cantidad+" pasajeros");
    }
    
    public void mostrarAsientosDisponibles() {
        int disponibles =capacidadTotal- pasajerosActuales;
        System.out.println("Asientos disponibles: "+ disponibles);
    }
}