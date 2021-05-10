package co.com.edestinos.vuelos.models;

public class ReservationDetailsExcel extends Reservation{

    private String cantidadPasajerosAdultos;
    private String cantidadPasajerosJovenes;
    private String cantidadPasajerosNinos;
    private String cantidadPasajerosBebes;

    public ReservationDetailsExcel() {
        super();
        cantidadPasajerosAdultos = "";
        cantidadPasajerosBebes = "";
        cantidadPasajerosJovenes = "";
        cantidadPasajerosNinos = "";
    }

    public String getCantidadPasajerosAdultos() {
        return cantidadPasajerosAdultos;
    }

    public String getCantidadPasajerosJovenes() {
        return cantidadPasajerosJovenes;
    }

    public String getCantidadPasajerosNinos() {
        return cantidadPasajerosNinos;
    }

    public String getCantidadPasajerosBebes() {
        return cantidadPasajerosBebes;
    }
}
