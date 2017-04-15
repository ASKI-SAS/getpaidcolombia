package com.ektec.utilidades;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class PublicKeyReader {

    public static PublicKey get() throws Exception {

        File f = new File(Utilidades.getPropiedadConfig("certificado.ruta"));
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();

        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static String encrypt(String text, PublicKey key) {
        byte[] cipherText = null;
        StringBuilder sb = new StringBuilder();
        BASE64Encoder encoder = new BASE64Encoder();

        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encoder.encode(cipherText).replaceAll("\n", "");

    }
}