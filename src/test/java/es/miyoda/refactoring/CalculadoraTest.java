package es.miyoda.refactoring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculadoraTest {

    private Calculadora sut = new Calculadora();

    @Test
    public void calcularConRebajaJoven() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, false)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(506.35));
    }

    @Test
    public void calcularConRebajaJovenYMitadDePrecio() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(751.35));
    }

    @Test
    public void calcularConRebajaJovenYDosAMitadDePrecio() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(751.35));
    }

    @Test
    public void calcularConRebajaJovenYDosAMitadDePrecioEnSegundaUnidad() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, true)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(1486.35));
    }

    @Test
    public void calcularConRebajaJubilado() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, false)
        );
        Comprador comprador = new Comprador(70);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(605.45));
    }

    @Test
    public void calcularSinRebaja() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 1, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 1, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 1, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 1, false)
        );
        Comprador comprador = new Comprador(50);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(606.35));
    }

    @Test
    public void calcularConRebajaEnCadaProducto() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 0.5, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 0.6, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 0.7, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 0.8, false)
        );
        Comprador comprador = new Comprador(50);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(482.27));
    }

    @Test
    public void calcularConRebajaEnCadaProductoYRebajaJoven() {
        List<Producto> productos = Arrays.asList(
                new Producto("pan", 0.4, TipoProducto.COMIDA, 0.5, false),
                new Producto("perfume", 9.99, TipoProducto.DROGUERIA, 0.6, false),
                new Producto("billete tren", 4.5, TipoProducto.TRANSPORTE, 0.7, false),
                new Producto("casa", 500, TipoProducto.VIVIENDA, 0.8, false)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(402.27));
    }

    @Test
    public void calcularProductoGeneral() {
        List<Producto> productos = Arrays.asList(
                new Producto("juegos", 50.6, TipoProducto.GENERAL, 1, false)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(61.23));
    }

    @Test
    public void calcularProductoConMitadDePrecio() {
        List<Producto> productos = Arrays.asList(
                new Producto("juegos", 50.6, TipoProducto.GENERAL, 1, true),
                new Producto("juegos", 50.6, TipoProducto.GENERAL, 1, true),
                new Producto("juegos", 50.6, TipoProducto.GENERAL, 1, true)
        );
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(153.06));
    }

    @Test
    public void calcularNingunProducto() {
        List<Producto> productos = new ArrayList();
        Comprador comprador = new Comprador(20);

        double precio = sut.calcular(productos, comprador);

        assertThat(precio, equalTo(.0));
    }

}
