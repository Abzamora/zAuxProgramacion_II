package Ejer2;

public class TestBus {
    public static void main(String[] args) {
        Bus miBus = new Bus(30);
        miBus.mostrar();
        miBus.subirPasajeros(10);
        miBus.subirPasajeros(15);
        miBus.subirPasajeros(10); // No caben

        miBus.cobrarPasaje(10);
        miBus.cobrarPasaje(15);

        miBus.mostrarAsientosDisponibles();
    }
}