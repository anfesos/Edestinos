package co.com.edestinos.vuelos.models;

public class ReservationDetails extends Reservation {

    private int cantidadPasajerosAdultos;
    private int cantidadPasajerosJovenes;
    private int cantidadPasajerosNinos;
    private int cantidadPasajerosBebes;

    public ReservationDetails() {
        super();
        cantidadPasajerosAdultos = 0;
        cantidadPasajerosJovenes = 0;
        cantidadPasajerosNinos = 0;
        cantidadPasajerosBebes = 0;
    }

    public int getCantidadPasajerosAdultos() {
        return cantidadPasajerosAdultos;
    }

    public int getCantidadPasajerosJovenes() {
        return cantidadPasajerosJovenes;
    }

    public int getCantidadPasajerosNinos() {
        return cantidadPasajerosNinos;
    }

    public int getCantidadPasajerosBebes() {
        return cantidadPasajerosBebes;
    }
}
