package model;

public enum TipoHumor {
    absurdo("Este libro tiene un tipo de humor ABSURDO"),
    negro("Este libro tiene un tipo de humor NEGRO");
    private String descripcion;

    TipoHumor(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
