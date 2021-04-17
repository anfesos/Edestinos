package co.com.edestinos.vuelos.models;

public class ReservationDetails {

    private String origen;
    private String destino;
    private String salida;
    private String regreso;
    private int cantidadPasajerosAdultos;
    private int cantidadPasajerosJovenes;
    private int cantidadPasajerosNinos;
    private int cantidadPasajerosBebes;

    public ReservationDetails(String origen, String destino, String salida) {
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
    }

    public ReservationDetails(String origen, String destino, String salida, String regreso, int cantidadPasajerosAdultos) {
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.regreso = regreso;
        this.cantidadPasajerosAdultos = cantidadPasajerosAdultos;
    }

    public ReservationDetails(String origen, String destino, String salida, String regreso, int cantidadPasajerosAdultos, int cantidadPasajerosJovenes, int cantidadPasajerosNinos, int cantidadPasajerosBebes) {
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.regreso = regreso;
        this.cantidadPasajerosAdultos = cantidadPasajerosAdultos;
        this.cantidadPasajerosJovenes = cantidadPasajerosJovenes;
        this.cantidadPasajerosNinos = cantidadPasajerosNinos;
        this.cantidadPasajerosBebes = cantidadPasajerosBebes;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getRegreso() {
        return regreso;
    }

    public void setRegreso(String regreso) {
        this.regreso = regreso;
    }

    public int getCantidadPasajerosAdultos() {
        return cantidadPasajerosAdultos;
    }

    public void setCantidadPasajerosAdultos(int cantidadPasajerosAdultos) {
        this.cantidadPasajerosAdultos = cantidadPasajerosAdultos;
    }

    public int getCantidadPasajerosJovenes() {
        return cantidadPasajerosJovenes;
    }

    public void setCantidadPasajerosJovenes(int cantidadPasajerosJovenes) {
        this.cantidadPasajerosJovenes = cantidadPasajerosJovenes;
    }

    public int getCantidadPasajerosNinos() {
        return cantidadPasajerosNinos;
    }

    public void setCantidadPasajerosNinos(int cantidadPasajerosNinos) {
        this.cantidadPasajerosNinos = cantidadPasajerosNinos;
    }

    public int getCantidadPasajerosBebes() {
        return cantidadPasajerosBebes;
    }

    public void setCantidadPasajerosBebes(int cantidadPasajerosBebes) {
        this.cantidadPasajerosBebes = cantidadPasajerosBebes;
    }
}
