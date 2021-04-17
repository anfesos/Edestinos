package co.com.edestinos.vuelos.interactions;

public enum TypeOperation {

    MINUS("minus"),
    PLUS("plus");

    private final String typeOperator;

    TypeOperation(String typeOperator) {
        this.typeOperator = typeOperator;
    }

    public String getTypeOperator() {
        return typeOperator;
    }
}
