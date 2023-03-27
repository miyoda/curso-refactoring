package es.miyoda.refactoring;

import java.util.Arrays;
import java.util.List;

public class Tienda {

    public static void main(String args[]) {
        List<Producto> productos = Arrays.asList(
            new Producto("pan", 0.4, TipoProducto.COMIDA,1, false),
            new Producto("perfume", 9.99, TipoProducto.DROGUERIA,1, false),
            new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE,1, false),
            new Producto("casa", 500, TipoProducto.VIVIENDA,1, false)
        );

        Comprador comprador = new Comprador(20);

        Calculadora calculadora = new Calculadora();

        System.out.println("La compra cuesta " + calculadora.calcular(productos, comprador) + "€");
    }
}
