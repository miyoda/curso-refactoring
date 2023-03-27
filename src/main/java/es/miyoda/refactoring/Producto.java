package es.miyoda.refactoring;

import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    private TipoProducto tipo;
    private double rebaja; // Entre 0 y 1 (en porcentaje)
    private boolean segundoAMitadDePrecio; // Todas los productos con el mismo nombre tendran este boolean igual

    public Producto(String nombre, double precio, TipoProducto tipo, double rebaja, boolean segundoAMitadDePrecio) {
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio, precio) == 0 && Double.compare(producto.rebaja, rebaja) == 0 && segundoAMitadDePrecio == producto.segundoAMitadDePrecio && Objects.equals(nombre, producto.nombre) && tipo == producto.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, tipo, rebaja, segundoAMitadDePrecio);
    }
}
