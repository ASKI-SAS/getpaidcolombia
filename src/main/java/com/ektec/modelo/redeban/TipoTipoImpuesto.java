
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoImpuesto.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoImpuesto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IVA"/>
 *     &lt;enumeration value="Consumo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TipoTipoImpuesto")
@XmlEnum
public enum TipoTipoImpuesto {

    IVA("IVA"),
    @XmlEnumValue("Consumo")
    CONSUMO("Consumo");
    private final String value;

    TipoTipoImpuesto(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoImpuesto fromValue(String v) {
        for (TipoTipoImpuesto c : TipoTipoImpuesto.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
