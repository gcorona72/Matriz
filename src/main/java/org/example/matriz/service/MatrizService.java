package org.example.matriz.service;

import org.example.matriz.domain.Matriz;

/**
 * DIP: El controlador depende de esta abstracción, no de una implementación concreta.
 */
public interface MatrizService {
    /**
     * Devuelve la matriz transpuesta de la entrada.
     */
    Matriz transponer(Matriz origen);

    /**
     * Devuelve un String listo para imprimir en consola.
     * (O podríamos exponer datos y dejar el printing a la UI/Swing).
     */
    String formatoParaImprimir(Matriz m);
}
