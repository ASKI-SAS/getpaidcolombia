
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoCapacidadPIN.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoCapacidadPIN">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Desconocido"/>
 *     &lt;enumeration value="Permitido"/>
 *     &lt;enumeration value="NoPermitido"/>
 *     &lt;enumeration value="FueraDeServicio"/>
 *     &lt;enumeration value="Verificado"/>
 *     &lt;enumeration value="NoPermitidoBatch"/>
 *     &lt;enumeration value="Virtual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 *
 */
@XmlType(name = "TipoCapacidadPIN", namespace = "http://www.rbm.com.co/esb/comercio/")
@XmlEnum
public enum TipoCapacidadPIN {

    @XmlEnumValue("Desconocido")
    DESCONOCIDO("Desconocido"),
    @XmlEnumValue("Permitido")
    PERMITIDO("Permitido"),
    @XmlEnumValue("NoPermitido")
    NO_PERMITIDO("NoPermitido"),
    @XmlEnumValue("FueraDeServicio")
    FUERA_DE_SERVICIO("FueraDeServicio"),
    @XmlEnumValue("Verificado")
    VERIFICADO("Verificado"),
    @XmlEnumValue("NoPermitidoBatch")
    NO_PERMITIDO_BATCH("NoPermitidoBatch"),
    @XmlEnumValue("Virtual")
    VIRTUAL("Virtual");
    private final String value;

    TipoCapacidadPIN(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoCapacidadPIN fromValue(String v) {
        for (TipoCapacidadPIN c: TipoCapacidadPIN.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
