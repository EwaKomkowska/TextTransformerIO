package com.company;

public class TextTransformation {

    /**
     * Function that converts text to UPPER text.
     * @param text
     * @return
     */
    public static String upper(String text) {
        return text.toUpperCase();
    }

    /**
     * Function that converts text to lower text.
     * @param text
     * @return
     */
    public static String lower(String text) {
        return text.toLowerCase();
    }

    /**
     * Subfunction that converts single string to Capital string.
     * @param text
     * @return
     */
    private static String subCapital(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }

    /**
     * Function that converts whole sentence to Capital words.
     * @param text
     * @return
     */
    public static String Capital(String text) {
        String[] temp = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String i: temp) {
            result.append(subCapital(i)).append(" ");
        }

        return result.toString();
    }
}
