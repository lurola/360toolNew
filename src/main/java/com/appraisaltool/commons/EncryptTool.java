package com.appraisaltool.commons;

import com.appraisaltool.encrypting.EncrypterAES;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncryptTool {
    private static final String claveEncriptacion = "secreto!";
    private static EncrypterAES encrypt = new EncrypterAES();

    public static String encode(String text) {
        return text;
        // try {
        // return encrypt.encriptar(text, claveEncriptacion);
        // } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
        // log.error(EncrypterAES.class.getName() + ex.getMessage());
        // }
        // return null;
    }

    public static String decode(String text) {
        return text;
        // try {
        // return encrypt.desencriptar(text, claveEncriptacion);
        // } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
        // log.error(EncrypterAES.class.getName() + ex.getMessage());
        // }
        // return null;
    }
}
