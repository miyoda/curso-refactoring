package es.miyoda.refactoring;

public enum GrupoEdad {
    JOVEN(34),
    ADULTO(65),
    JUBILADO(Integer.MAX_VALUE);

    private final int maxEdad;

    GrupoEdad(int maxEdad) {
        this.maxEdad = maxEdad;
    }
    public static GrupoEdad getGrupoDeEdadPorEdad(int edad){
        for(GrupoEdad grupoDeEdad :GrupoEdad.values())
            if(grupoDeEdad.maxEdad > edad)
                return grupoDeEdad;
        return JUBILADO;
    }

    public int getMaxEdad() {
        return maxEdad;
    }

}
