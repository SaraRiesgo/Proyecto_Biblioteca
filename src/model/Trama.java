package model;

public enum Trama {
    misterio("Este libro tiene una trama de MISTERIO"),
    intriga("Este libro tiene una trama de INTRIGA");
    private String descripcion;

    Trama(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
