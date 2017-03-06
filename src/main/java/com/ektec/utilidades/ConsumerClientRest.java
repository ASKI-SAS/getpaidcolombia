package com.ektec.utilidades;


import com.ektec.od.GetPaidRequestOd;
import com.ektec.od.GetPaidResponseOd;
import com.ektec.utilidades.ws.IConsumerWS;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class ConsumerClientRest implements IConsumerWS {
    private static Logger LOGGER = Logger.getLogger(ConsumerClientRest.class.getName());

    // Consumir un Web Service REST
    @Override
    public Object consume(String url, Object request, Class cls) {
        long time = 0;
        ResponseEntity response;
        Object objectResponse;

        try {
            // Traza de inicio
            if (LOGGER.isDebugEnabled()) {
                time = System.currentTimeMillis();
                LOGGER.debug("Consumo WS: INICIADO");
            }

            // Establecer parámetros de seguridad para el consumo
            List<MediaType> acceptableMediaTypes = new ArrayList<>();
            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(acceptableMediaTypes);
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Establecer parámetros de Autorización de consumo
            String auth = Utilidades.getPropiedadConfig("servicio.userpass");
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName(Utilidades.getPropiedadConfig("servicio.charset"))));
            String authHeader = "Basic " + new String(encodedAuth);
            headers.set("Authorization", authHeader);

            // Establecer los parametros de la peticion
            String paramPeticion = new Gson().toJson(request);
            if (LOGGER.isDebugEnabled())
                LOGGER.info("WS URL: " + url + " - Parámetros:" + new Gson().toJson(request));

            // Consumir el WS
            HttpEntity<String> entity = new HttpEntity<>(paramPeticion, headers);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.postForEntity(url, entity, String.class);
            objectResponse = new Gson().fromJson((String) response.getBody(), GetPaidResponseOd.class);

            // Traza del tiempo total de ejecución
            if (LOGGER.isDebugEnabled()) {
                time = System.currentTimeMillis() - time;
                LOGGER.debug("Consumo WS: FINALIZADO. (" + time + " mils)");
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);

            // Establecer respuesta fallida: SERVICIO NO DISPONIBLE
            GetPaidRequestOd requestOrigen = (GetPaidRequestOd) request;
            GetPaidResponseOd servicioNoDisponible = new GetPaidResponseOd();
            servicioNoDisponible.setFolioTransaccion(requestOrigen.getPeticion().getFolioTransaccion());
            servicioNoDisponible.setFechaHoraSolicitud(requestOrigen.getSeguridad().getFechaHora());
            servicioNoDisponible.setIdRespuesta("999");
            servicioNoDisponible.setDescripcion("CSA No Disponible - EKTEC");

            // Encolar la respuesta fallida
            objectResponse = servicioNoDisponible;
        }

        return objectResponse;
    }

}