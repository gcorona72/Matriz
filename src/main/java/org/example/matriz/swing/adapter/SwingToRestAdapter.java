package org.example.matriz.swing.adapter;

import org.example.matriz.web.MatrizDto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * DIP: depende de RestTemplate (abstracción HTTP) y del DTO, no de implementaciones concretas.
 */
public class SwingToRestAdapter {
    private final String baseUrl;
    private final RestTemplate rest;

    public SwingToRestAdapter(String baseUrl) {
        this.baseUrl = baseUrl;
        this.rest    = new RestTemplate();
    }

    public int[][] transpose(int[][] datos) {
        MatrizDto request = new MatrizDto(datos);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MatrizDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<MatrizDto> resp = rest.exchange(
                baseUrl + "/transponer",
                HttpMethod.POST,
                entity,
                MatrizDto.class
        );
        return resp.getBody().getDatos();
    }
}
