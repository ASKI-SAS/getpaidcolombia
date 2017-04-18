
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoMontoDetallado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoMontoDetallado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MontoAdicional"/>
 *     &lt;enumeration value="Descuento"/>
 *     &lt;enumeration value="BaseDevolucionIVA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoTipoMontoDetallado")
@XmlEnum
public enum TipoTipoMontoDetallado {

    @XmlEnumValue("MontoAdicional")
    MONTO_ADICIONAL("MontoAdicional"),
    @XmlEnumValue("Descuento")
    DESCUENTO("Descuento"),
    @XmlEnumValue("BaseDevolucionIVA")
    BASE_DEVOLUCION_IVA("BaseDevolucionIVA");
    private final String value;

    TipoTipoMontoDetallado(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoMontoDetallado fromValue(String v) {
        for (TipoTipoMontoDetallado c: TipoTipoMontoDetallado.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
