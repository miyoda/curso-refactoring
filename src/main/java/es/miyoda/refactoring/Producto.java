package es.miyoda.refactoring;

public class Producto {
    private String nombre;
    private double precio;
    private String tipo;
    private double rebaja; // Entre 0 y 1 (en porcentaje)
    private boolean segundoAMitadDePrecio; // Todas los productos con el mismo nombre tendran este boolean igual

    public Producto(String nombre, double precio, String tipo, double rebaja, boolean segundoAMitadDePrecio) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.rebaja = rebaja;
        this.segundoAMitadDePrecio = segundoAMitadDePrecio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getRebaja() {
        return rebaja;
    }

    public void setRebaja(double rebaja) {
        this.rebaja = rebaja;
    }

    public boolean getSegundoAMitadDePrecio() {
        return segundoAMitadDePrecio;
    }

    public void setSegundoAMitadDePrecio(boolean segundoAMitadDePrecio) {
        this.segundoAMitadDePrecio = segundoAMitadDePrecio;
    }
}
