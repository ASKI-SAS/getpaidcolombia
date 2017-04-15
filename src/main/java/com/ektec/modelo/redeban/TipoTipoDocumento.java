
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoDocumento.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoDocumento">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="TI"/>
 *     &lt;enumeration value="CE"/>
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="PS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TipoTipoDocumento")
@XmlEnum
public enum TipoTipoDocumento {

    CC,
    TI,
    CE,
    NI,
    PS;

    public String value() {
        return name();
    }

    public static TipoTipoDocumento fromValue(String v) {
        return valueOf(v);
    }

}
