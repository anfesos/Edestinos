package co.com.edestinos.vuelos.interactions;

public enum TypePassenger {

    ADULT("adult"),
    YOUNG("youth"),
    CHILD("child"),
    INFANT("infant");

    private final String typePassenger;

    TypePassenger(String typePassenger) {
        this.typePassenger = typePassenger;
    }

    public String getTypePassenger() {
        return typePassenger;
    }
}
