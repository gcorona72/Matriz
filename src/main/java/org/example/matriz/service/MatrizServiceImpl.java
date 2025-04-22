package org.example.matriz.service;

import org.example.matriz.domain.Matriz;
import org.springframework.stereotype.Service;

@Service
public class MatrizServiceImpl implements MatrizService {

    @Override
    public Matriz transponer(Matriz origen) {
        int[][] orig = origen.getDatos();
        int filas = origen.getFilas();
        int cols  = origen.getColumnas();
        int[][] aux = new int[cols][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                aux[j][i] = orig[i][j];
            }
        }
        return new Matriz(aux);
    }

    @Override
    public String formatoParaImprimir(Matriz m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.getFilas(); i++) {
            for (int j = 0; j < m.getColumnas(); j++) {
                sb.append(m.getDatos()[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
