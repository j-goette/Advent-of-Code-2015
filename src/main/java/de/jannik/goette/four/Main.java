package de.jannik.goette.four;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Main {

    final static String SECRET = "ckczppom";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");

        for (int i = 0; i < 1_000_000_000; i++) {
            final String input    = SECRET + i;
            final byte[] digest   = md.digest(input.getBytes());
            final String hashText = HexFormat.of().formatHex(digest);

            if (hashText.startsWith("000000")) {
                System.out.println("Treffer: " + hashText + " Run: " + i);
                break;
            }
        }

    }
}
