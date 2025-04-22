package org.example.matriz.web;

/**
 * DTO ultraligero para recibir y devolver JSON de matrices.
 */
public class MatrizDto {
    private int[][] datos;

    public MatrizDto() { }               // Jackson necesita constructor vacío
    public MatrizDto(int[][] datos) {
        this.datos = datos;
    }

    public int[][] getDatos() {
        return datos;
    }

    public void setDatos(int[][] datos) {
        this.datos = datos;
    }
}
