package web.java.utils;

import java.util.Base64;

public class GeneralFunction {
    public static String getEncodedString(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}
