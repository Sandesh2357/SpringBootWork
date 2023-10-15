package com.sandesh.InstagramBasicDesign.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
    public static String encrypt(String unHashedPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(unHashedPassword.getBytes());
        byte[] digested = md5.digest();
        return bytesToHex(digested);
    }

        public static String bytesToHex(byte[] bytes){
            StringBuilder hexString = new StringBuilder(2 * bytes.length);
            for (byte b : bytes) {
                hexString.append(String.format("%02X", b));
            }
            return hexString.toString();
        }

}
