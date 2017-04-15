package com.ektec.dao;

import com.ektec.od.*;
import com.ektec.utilidades.PublicKeyReader;
import com.ektec.utilidades.Utilidades;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import redeban.modelo.*;
import redeban.wsclient.ClientWs;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static redeban.wsclient.ClientWs.compraProcesar;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2013-09-26
 * @since 1.0
 */
@Repository("colaCobroDao")
public class ColaCobroDao extends OracleDao implements IColaDao {
    private static Logger LOGGER = Logger.getLogger(ColaCobroDao.class.getName());

    public ColaCobroDao() throws BDException {
        super();
    }

    @Override
    public Object encolar(Object obj) throws BDException {
        TipoRespuesta respuesta = null;
        try {
            if (!(obj instanceof TipoRespuesta))
                throw new BDException("No se pueden enconlar este tipo de objeto");
            TipoRespuesta respuestaCobro = (TipoRespuesta) obj;

            // Conectar con la BD
            connect();

            // Ejecutar la actualización
            callableStatement = connection.prepareCall("{CALL sp_ws_updentries(?,?,?,?,?,?,?,?,?)}");
            callableStatement.registerOutParameter(9, Types.NUMERIC);
            /*if (respuestaCobro.getFolioTransaccion() != null)
                callableStatement.setString(1, respuestaCobro.getFolioTransaccion());
            else
                callableStatement.setNull(1, Types.NULL);

            if (respuestaCobro.getIdRespuesta() != null)
                callableStatement.setString(2, respuestaCobro.getIdRespuesta());
            else
                callableStatement.setNull(2, Types.NULL);

            if (respuestaCobro.getDescripcion() != null)
                callableStatement.setString(3, respuestaCobro.getDescripcion());
            else
                callableStatement.setNull(3, Types.NULL);

            if (respuestaCobro.getAuditNumber() != null)
                callableStatement.setString(4, respuestaCobro.getAuditNumber());
            else
                callableStatement.setNull(4, Types.NULL);

            if (respuestaCobro.getAuthorizationId() != null)
                callableStatement.setString(5, respuestaCobro.getAuthorizationId());
            else
                callableStatement.setNull(5, Types.NULL);

            if (respuestaCobro.getResponseCode() != null)
                callableStatement.setString(6, respuestaCobro.getResponseCode());
            else
                callableStatement.setNull(6, Types.NULL);

            if (respuestaCobro.getFechaHora() != null)
                callableStatement.setString(7, respuestaCobro.getFechaHora());
            else
                callableStatement.setNull(7, Types.NULL);

            if (respuestaCobro.getFechaHoraSolicitud() != null)
                callableStatement.setString(8, respuestaCobro.getFechaHoraSolicitud());
            else
                callableStatement.setNull(8, Types.NULL);

            // Ejecutar la inserción
            callableStatement.executeUpdate();

            // Validar y devolver la respuesta
            respuesta = new GetPaidResponseOd();
            respuesta.setEstado(callableStatement.getString(9));
            if (!respuesta.getEstado().equalsIgnoreCase("0"))
                throw new BDException("Mensaje de la base de datos: " + respuesta.getEstado());
*/
        } catch (SQLException sqle) {
            throw new BDException(sqle.getMessage());

        } finally {
            // Desconectar de la BD
            close();
        }

        return respuesta;
    }

    @Override
    public Object desencolar() throws BDException {
        Object resultado;
        try {
            // Conectar con la BD
            connect();

            // Ejecutar la consulta
            callableStatement = connection.prepareCall("{CALL pkg_ws_quepay.sp_ws_dequeue(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.DATE);
            callableStatement.registerOutParameter(4, Types.NUMERIC);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.registerOutParameter(6, Types.VARCHAR);
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.NUMERIC);
            callableStatement.registerOutParameter(15, Types.NUMERIC);
            callableStatement.registerOutParameter(16, Types.NUMERIC);
            resultSet = callableStatement.executeQuery();

            // Obtener el resultado
            GetPaidResponseOd res = new GetPaidResponseOd();
            res.setEstado(callableStatement.getString(16));

            // Validar si hay respuesta de la cola
            if (!res.getEstado().equalsIgnoreCase("0"))
                throw new BDException("Mensaje de la base de datos: " + res.getEstado());

            // Verificar si hay elementos en la cola
            String idServicio = callableStatement.getString(1);
            if ((idServicio == null) || (idServicio.equalsIgnoreCase("X"))) {
                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("No hay solicitudes en cola...");
                return null;
            }

            // Obtener los datos del Objeto desde la BD
            //resultado = this.getPaidObject();
            resultado = this.getPaidRedeban();

        } catch (SQLException sqle) {
            throw new BDException(sqle.getMessage());

        } finally {
            // Desconectar de la BD
            close();
        }

        return resultado;
    }

    // Obtiene el objeto solicitud desde la BD
    private GetPaidRequestOd getPaidObject() {
        GetPaidRequestOd getPaidRequestOd = new GetPaidRequestOd();
        try {
            getPaidRequestOd.setSeguridad(new SeguridadOd());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DateFormat dfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            getPaidRequestOd.getSeguridad().setFechaHora(reportDate);
            getPaidRequestOd.getSeguridad().setUsuario(Utilidades.getPropiedadConfig("seguridad.usuario"));
            String textencrypt = PublicKeyReader.encrypt(getPaidRequestOd.getSeguridad().getUsuario() + "::" + Utilidades.getPropiedadConfig("seguridad.key") + "::" + getPaidRequestOd.getSeguridad().getFechaHora(), PublicKeyReader.get());
            getPaidRequestOd.getSeguridad().setKey(textencrypt);
            getPaidRequestOd.setPeticion(new PeticionOd());
            getPaidRequestOd.getPeticion().setIdServicio(callableStatement.getString(1));
            getPaidRequestOd.getPeticion().setFolioTransaccion(callableStatement.getString(2));
            Date datedb = dfd.parse(callableStatement.getString(3));
            String reportDate2 = df.format(datedb);
            getPaidRequestOd.getPeticion().setFechaHora(reportDate2);
            getPaidRequestOd.getPeticion().setImporteTransaccion(callableStatement.getDouble(4));
            getPaidRequestOd.getPeticion().setMerchantType(callableStatement.getString(5));
            getPaidRequestOd.getPeticion().setTlv(callableStatement.getString(6));
            getPaidRequestOd.getPeticion().setTrack(callableStatement.getString(7));
            getPaidRequestOd.getPeticion().setKsn(callableStatement.getString(8));
            getPaidRequestOd.getPeticion().setTerminalId(callableStatement.getString(9));
            getPaidRequestOd.getPeticion().setTerminalLocation(new TerminalLocationOd());
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalOwner(callableStatement.getString(10));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalCity(callableStatement.getString(11));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalState(callableStatement.getString(12));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalCountry(callableStatement.getString(13));
            getPaidRequestOd.getPeticion().setAdditionalData(new AdditionalDataOd());
            getPaidRequestOd.getPeticion().getAdditionalData().setRetailerId(callableStatement.getLong(14));

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return getPaidRequestOd;

    }

    // Obtiene el objeto solicitud desde la BD
    private TipoRespuesta getPaidRedeban() {
        TipoSolicitudCompra request = new TipoSolicitudCompra();
        TipoRespuesta respuesta = new TipoRespuesta();
// PARTE DE LA SOLICITUD
        TipoCabeceraSolicitud cabecera = new TipoCabeceraSolicitud();
        TipoIdPersona idPersona = new TipoIdPersona();
        TipoInfoMedioPago infoMedioPago = new TipoInfoMedioPago();
        TipoInfoCompra infoCompra = new TipoInfoCompra();

        try{

// SE ARMA LA SOLICITUD
            /* infoPuntoInteraccion */
            cabecera.setInfoPuntoInteraccion(new TipoInfoPuntoInteraccion());
            cabecera.getInfoPuntoInteraccion().setTipoTerminal(TipoTipoTerminal.WEB);
            cabecera.getInfoPuntoInteraccion().setIdTerminal("ESB10718");
            cabecera.getInfoPuntoInteraccion().setIdAdquiriente("1");
            cabecera.getInfoPuntoInteraccion().setIdTransaccionTerminal(new Long("1897"));
            cabecera.getInfoPuntoInteraccion().setModoCapturaPAN(TipoModoCapturaPAN.MANUAL);
            cabecera.getInfoPuntoInteraccion().setCapacidadPIN(TipoCapacidadPIN.VIRTUAL);

            /* idPersona */
            idPersona.setTipoDocumento(TipoTipoDocumento.CC);
            idPersona.setNumDocumento(new Long("72130284"));

            /* infoMedioPago */
            infoMedioPago.setIdTarjetaCredito(new TipoIdTarjetaCredito());
            infoMedioPago.getIdTarjetaCredito().setFranquicia(TipoFranquicia.MASTER_CARD);
            infoMedioPago.getIdTarjetaCredito().setNumTarjeta("5303710409428783");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar date2 = null;
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            infoMedioPago.getIdTarjetaCredito().setFechaExpiracion(date2);
            infoMedioPago.getIdTarjetaCredito().setCodVerificacion("115");

            /* infoCompra */
            infoCompra.setMontoTotal(new BigDecimal("250000"));
            infoCompra.setCantidadCuotas(1);
            infoCompra.setReferencia("Mensaje Adicional 123");
                /* infoImpuestos */
            TipoInfoImpuestos tipoImpuesto = new TipoInfoImpuestos();
            tipoImpuesto.setTipoImpuesto(TipoTipoImpuesto.IVA);
            tipoImpuesto.setMonto(new BigDecimal("3400.00"));
            infoCompra.getInfoImpuestos().add(tipoImpuesto);
                /* infoImpuestos */
            TipoMontoDetallado tipoMontoDetallado = new TipoMontoDetallado();
            tipoMontoDetallado.setMonto(new BigDecimal("17851.00"));
            tipoMontoDetallado.setTipoMontoDetallado(TipoTipoMontoDetallado.BASE_DEVOLUCION_IVA);
            infoCompra.getMontoDetallado().add(tipoMontoDetallado);
    // SOLICITUD
            request.setCabeceraSolicitud(cabecera);
            request.setIdPersona(idPersona);
            request.setInfoCompra(infoCompra);
            request.setInfoMedioPago(infoMedioPago);
    // CONSUMO DEL SERVICIO
            respuesta= ClientWs.compraProcesar(request);

            System.out.print(respuesta.getInfoRespuesta().getEstado());
        } catch(Exception e){
            System.out.println("err" + e.getMessage());
            e.printStackTrace();
        }
        return respuesta;
    }




}
