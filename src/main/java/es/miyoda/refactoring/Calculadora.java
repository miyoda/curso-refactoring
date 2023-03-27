package es.miyoda.refactoring;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Calculadora {

    public double calcular(List<Producto> productos, Comprador comprador){
        Map<Producto, Long> unidadesPorProducto = productos.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        double result = unidadesPorProducto.entrySet().stream()
                .mapToDouble(it -> getPrecioUnidadesProducto(it.getKey(), it.getValue(), comprador))
                .sum();
        return redondearDecimales(result, 2);
             
        }

    private Double getPrecioUnidadesProducto(Producto producto, Long unidades, Comprador comprador) {
        Double precioUnitario = getPrecioUnitario(producto, comprador);

        double precioTotal = precioUnitario * unidades;
        double descuentoSegundasUnidadesAMitadDePrecio = producto.getSegundoAMitadDePrecio() ?
                getDescuentoSegundasUnidadesAMitadDePrecio(precioUnitario, unidades) :
                0.0;
        return precioTotal - descuentoSegundasUnidadesAMitadDePrecio;
    }

    private double getDescuentoSegundasUnidadesAMitadDePrecio(double precioUnitario, long unidades) {
        return precioUnitario * Math.floor(unidades / 2.0) * 0.5;
    }

    private double getPrecioUnitario(Producto p, Comprador comprador) {
        double result = 0.0;
        result += p.getPrecio() * p.getRebaja();
        result += p.getPrecio() * p.getRebaja()*p.getTipo().getIva();
        result -= p.getPrecio() * p.getRebaja()*p.getTipo().getDescuento(GrupoEdad.getGrupoDeEdadPorEdad(comprador.getEdad())); // No se descuenta de la parte del IVA
        return result;
    }

    private double redondearDecimales(double result, int numDecimales) {
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(numDecimales, RoundingMode.HALF_UP); // Redondeamos a dos decimales
        return bd.doubleValue();
    }

}
