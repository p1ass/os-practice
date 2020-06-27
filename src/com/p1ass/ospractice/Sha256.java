package com.p1ass.ospractice;

import java.security.MessageDigest;

public class Sha256 {
    public static String getHash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());
            byte[] hash = md.digest();

            StringBuilder builder = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                builder.append(String.format("%02x", b & 0xff));
            }
            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
