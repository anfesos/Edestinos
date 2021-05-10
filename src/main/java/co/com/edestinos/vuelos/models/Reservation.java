package co.com.edestinos.vuelos.models;

public class Reservation {

    private String origen;
    private String destino;
    private String salida;
    private String regreso;

    public Reservation() {
        origen = "";
        destino = "";
        salida = "";
        regreso = "";
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getSalida() {
        return salida;
    }

    public String getRegreso() {
        return regreso;
    }
}
