package es.miyoda.refactoring;

import java.util.Map;

public enum TipoProducto {
    COMIDA(.06, Map.of()),
    DROGUERIA(.09, Map.of()),
    TRANSPORTE(.12, Map.of(GrupoEdad.JUBILADO, 0.2)),
    VIVIENDA(.18, Map.of(GrupoEdad.JOVEN, 0.2)),
    GENERAL(.21, Map.of());

    double iva;
    private Map<GrupoEdad, Double> descuentoPorGrupoEdad;

    TipoProducto(double iva, Map<GrupoEdad, Double> descuentoPorGrupoEdad) {
        this.iva = iva;
        this.descuentoPorGrupoEdad = descuentoPorGrupoEdad;
    }

    public double getIva() {
        return iva;
    }

    public double getDescuento(GrupoEdad grupoEdad) {
        return descuentoPorGrupoEdad.getOrDefault(grupoEdad, 0.0);
    }

}
