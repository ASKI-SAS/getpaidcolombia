package com.ektec.dao.jdbc;

import com.ektec.dao.IColaDao;
import com.ektec.exception.BDException;
import com.ektec.modelo.GetPaidResponseOd;
import com.ektec.modelo.redeban.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2013-09-26
 * @since 1.0
 */
@Repository("colaReversoDao")
public class ColaReversoDao extends OracleDao implements IColaDao {
    private static Logger LOGGER = Logger.getLogger(ColaReversoDao.class.getName());

    public ColaReversoDao() throws BDException {
        super();
    }

    @Override
    public Object encolar(Object obj) throws BDException {
        GetPaidResponseOd respuesta;
        try {
            if (!(obj instanceof TipoRespuesta))
                throw new BDException("No se pueden enconlar este tipo de objeto");
            TipoRespuesta respuestaReverso = (TipoRespuesta) obj;

            // Conectar con la BD
            connect();

            // Ejecutar la actualización
            this.callableStatement = connection.prepareCall("{CALL sp_ws_updentries(?,?,?,?,?,?,?,?,?)}");
            this.callableStatement.registerOutParameter(9, Types.NUMERIC);
            /*if (respuestaReverso.getFolioTransaccion() != null)
                this.callableStatement.setString(1, respuestaReverso.getFolioTransaccion());
            else
                this.callableStatement.setNull(1, Types.NULL);

            if (respuestaReverso.getIdRespuesta() != null)
                this.callableStatement.setString(2, respuestaReverso.getIdRespuesta());
            else
                this.callableStatement.setNull(2, Types.NULL);

            if (respuestaReverso.getDescripcion() != null)
                this.callableStatement.setString(3, respuestaReverso.getDescripcion());
            else
                this.callableStatement.setNull(3, Types.NULL);

            if (respuestaReverso.getAuditNumber() != null)
                this.callableStatement.setString(4, respuestaReverso.getAuditNumber());
            else
                this.callableStatement.setNull(4, Types.NULL);

            if (respuestaReverso.getAuthorizationId() != null)
                this.callableStatement.setString(5, respuestaReverso.getAuthorizationId());
            else
                this.callableStatement.setNull(5, Types.NULL);

            if (respuestaReverso.getResponseCode() != null)
                this.callableStatement.setString(6, respuestaReverso.getResponseCode());
            else
                this.callableStatement.setNull(6, Types.NULL);

            if (respuestaReverso.getFechaHora() != null)
                this.callableStatement.setString(7, respuestaReverso.getFechaHora());
            else
                this.callableStatement.setNull(7, Types.NULL);

            if (respuestaReverso.getFechaHoraSolicitud() != null)
                this.callableStatement.setString(8, respuestaReverso.getFechaHoraSolicitud());
            else
                this.callableStatement.setNull(8, Types.NULL);*/

            // Ejecutar la inserción
            this.callableStatement.executeUpdate();

            // Validar y devolver la respuesta
            respuesta = new GetPaidResponseOd();
            respuesta.setEstado(this.callableStatement.getString(9));
            if (!respuesta.getEstado().equalsIgnoreCase("0"))
                throw new BDException("Mensaje de la base de datos: " + respuesta.getEstado());

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
            this.callableStatement = connection.prepareCall("{CALL pkg_ws_quepay.sp_ws_dequeue(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            this.callableStatement.registerOutParameter(1, Types.VARCHAR);
            this.callableStatement.registerOutParameter(2, Types.VARCHAR);
            this.callableStatement.registerOutParameter(3, Types.DATE);
            this.callableStatement.registerOutParameter(4, Types.NUMERIC);
            this.callableStatement.registerOutParameter(5, Types.VARCHAR);
            this.callableStatement.registerOutParameter(6, Types.VARCHAR);
            this.callableStatement.registerOutParameter(7, Types.VARCHAR);
            this.callableStatement.registerOutParameter(8, Types.VARCHAR);
            this.callableStatement.registerOutParameter(9, Types.VARCHAR);
            this.callableStatement.registerOutParameter(10, Types.VARCHAR);
            this.callableStatement.registerOutParameter(11, Types.VARCHAR);
            this.callableStatement.registerOutParameter(12, Types.VARCHAR);
            this.callableStatement.registerOutParameter(13, Types.VARCHAR);
            this.callableStatement.registerOutParameter(14, Types.NUMERIC);
            this.callableStatement.registerOutParameter(15, Types.NUMERIC);
            this.callableStatement.registerOutParameter(16, Types.NUMERIC);
            resultSet = this.callableStatement.executeQuery();

            // Obtener el resultado
            GetPaidResponseOd res = new GetPaidResponseOd();
            res.setEstado(this.callableStatement.getString(16));

            // Validar si hay respuesta de la cola
            if (!res.getEstado().equalsIgnoreCase("0"))
                throw new BDException("Mensaje de la base de datos: " + res.getEstado());

            // Verificar si hay elementos en la cola
            String idServicio = this.callableStatement.getString(1);
            if ((idServicio == null) || (idServicio.equalsIgnoreCase("X"))) {
                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("No hay solicitudes en cola...");
                return null;
            }

            // Obtener los datos del Objeto desde la BD
            resultado = this.getPaidObject();

        } catch (Exception sqle) {
            throw new BDException(sqle.getMessage());

        } finally {
            // Desconectar de la BD
            close();
        }

        return resultado;
    }

    // Obtiene el objeto solicitud desde la BD
    private TipoSolicitudCompra getPaidObject() {
        TipoSolicitudCompra request = new TipoSolicitudCompra();

        // PARTES DE LA SOLICITUD
        TipoCabeceraSolicitud cabecera = new TipoCabeceraSolicitud();
        TipoIdPersona idPersona = new TipoIdPersona();
        TipoInfoMedioPago infoMedioPago = new TipoInfoMedioPago();
        TipoInfoCompra infoCompra = new TipoInfoCompra();

        try {

            // SE ARMA LA SOLICITUD
            //GetPaidRequestOd getPaidRequestOd = new GetPaidRequestOd();
            //getPaidRequestOd.getPeticion().setIdServicio(this.callableStatement.getString(1));

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
            XMLGregorianCalendar date2;
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

            request.setCabeceraSolicitud(cabecera);
            request.setIdPersona(idPersona);
            request.setInfoCompra(infoCompra);
            request.setInfoMedioPago(infoMedioPago);

        } catch (Exception e) {
            System.out.println("err" + e.getMessage());
            e.printStackTrace();
        }
        return request;
    }

}