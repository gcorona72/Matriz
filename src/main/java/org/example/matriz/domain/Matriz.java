package org.example.matriz.domain;

/**
 * SRP: Esta clase solo se preocupa de almacenar y validar una matriz.
 */
public class Matriz {
    private final int[][] datos;
    private final int filas;
    private final int columnas;

    public Matriz(int[][] datos) {
        if (datos == null || datos.length == 0 || datos[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula o vacía");
        }
        this.filas = datos.length;
        this.columnas = datos[0].length;
        this.datos = datos;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int[][] getDatos() {
        return datos;
    }
}
