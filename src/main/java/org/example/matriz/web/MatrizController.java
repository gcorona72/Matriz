package org.example.matriz.web;

import org.example.matriz.domain.Matriz;
import org.example.matriz.service.MatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * SRP: Este controller solo traduce HTTP ⇄ servicio.
 */
@RestController
@RequestMapping("/api/matrices")
public class MatrizController {

    private final MatrizService service;

    @Autowired
    public MatrizController(MatrizService service) {
        this.service = service;
    }

    /**
     * Recibe JSON
     *   { "datos": [[1,2],[3,4]] }
     * Devuelve
     *   { "datos": [[1,3],[2,4]] }
     */
    @PostMapping(path = "/transponer", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MatrizDto transponer(@RequestBody MatrizDto dto) {
        Matriz origen = new Matriz(dto.getDatos());
        Matriz resultado = service.transponer(origen);
        return new MatrizDto(resultado.getDatos());
    }

    /**
     * Ejemplo de endpoint para obtener un String listo para imprimir.
     */
    @PostMapping(path = "/imprimir", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String imprimir(@RequestBody MatrizDto dto) {
        return service.formatoParaImprimir(new Matriz(dto.getDatos()));
    }
}
