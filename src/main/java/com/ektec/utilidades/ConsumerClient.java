package com.ektec.utilidades;


import com.ektec.negocio.GetPaid;
import com.ektec.od.GetPaidRequestOd;
import com.ektec.od.GetPaidResponseOd;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ConsumerClient {
    private static Logger LOGGER = Logger.getLogger(ConsumerClient.class.getName());

    public static Object  consume (String url, Object request, Class cls){
        final String origen = "ConsumerClient.consume";
        long time = 0;
        ResponseEntity response = null;
        Object objectResponse = null;

        try {

            if(Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
            LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + ConsumerClient.class + " | " + origen);
            time = System.currentTimeMillis();

            List<MediaType> acceptableMediaTypes = new ArrayList<>();
            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(acceptableMediaTypes);
            headers.setContentType(MediaType.APPLICATION_JSON);
            String auth = Utilidades.getPropiedadConfig("servicio.userpass");
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName(Utilidades.getPropiedadConfig("servicio.charset"))));
            String authHeader = "Basic " + new String( encodedAuth );
            headers.set( "Authorization", authHeader );


            if(Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
            LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + ConsumerClient.class + " | " + "Petición: url= " +url +" - "+ new Gson().toJson(request));
            HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(request), headers);


            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.postForEntity(url, entity, String.class);

            Gson gson = new Gson();
            objectResponse = gson.fromJson((String) response.getBody(),GetPaidResponseOd.class);

            time = System.currentTimeMillis() - time;
            if(Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
            LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + ConsumerClient.class + " | " + origen + " | " + time);

        }catch (Exception ex){
            LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + ex.getMessage());
            GetPaidRequestOd getPaidRequestOd = (GetPaidRequestOd) request;
            GetPaidResponseOd GetPaidResponseOd = new GetPaidResponseOd();
            GetPaidResponseOd.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
            GetPaidResponseOd.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
            GetPaidResponseOd.setIdRespuesta("999");
            GetPaidResponseOd.setDescripcion("CSA No Disponible - EKTEC");
            GetPaid getPaid = new GetPaid();
            try {
                GetPaidResponseOd = getPaid.setResponse(GetPaidResponseOd);
            } catch (Exception ex2) {
                LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + ex2.getMessage());
            }
        }


        return objectResponse;
    }


}