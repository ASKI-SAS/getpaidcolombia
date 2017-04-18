
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para TipoInfoCHIP complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoCHIP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSeguridadEMV" type="{http://www.rbm.com.co/esb/}TipoCodSeguridadEMV"/>
 *         &lt;element name="dataEMV" type="{http://www.rbm.com.co/esb/}TipoDataEMV"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoCHIP", propOrder = {
    "codSeguridadEMV",
    "dataEMV"
})
public class TipoInfoCHIP {

    @XmlElement(required = true)
    protected String codSeguridadEMV;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] dataEMV;

    /**
     * Obtiene el valor de la propiedad codSeguridadEMV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSeguridadEMV() {
        return codSeguridadEMV;
    }

    /**
     * Define el valor de la propiedad codSeguridadEMV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSeguridadEMV(String value) {
        this.codSeguridadEMV = value;
    }

    /**
     * Obtiene el valor de la propiedad dataEMV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDataEMV() {
        return dataEMV;
    }

    /**
     * Define el valor de la propiedad dataEMV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEMV(byte[] value) {
        this.dataEMV = value;
    }

}
