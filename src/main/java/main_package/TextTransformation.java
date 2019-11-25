package main_package;

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

    /**
     * Subfunction used to indentify byte as upper letter.
     * @param x
     * @return
     */
    private static Boolean isUpper(byte x) {
        return x >= 65 && x <= 90;
    }

    /**
     * Subfunction used to indentify byte as lower letter.
     * @param x
     * @return
     */
    private static Boolean isLower(byte x) {
        return x >= 97 && x <= 122;
    }

    /**
     * Function that inverts a word having the same Capital letters.
     * @param text
     * @return
     */
    public static String Inverse(String text) {
        byte[] temp = text.getBytes();
        byte[] result = new byte[temp.length];
        /*
        AZ : 65 - 90
        az : 97 - 122
         */
        for (int i = 0; i < temp.length; i++) {
            if (isUpper(temp[temp.length-1-i]) && isLower(temp[i]))
                // (Upper letter) *but should be* (Lower letter)
                result[i] =  (byte)(temp[temp.length-1-i] + 32);
            else if (isUpper(temp[i]) && isLower(temp[temp.length-1-i]))
                // (Lower Letter) *but should be* (Upper Letter)
                result[i] = (byte)(temp[temp.length-1-i] - 32);
            else
                result[i] = temp[temp.length-1-i];
        }

        return new String(result);
    }
    
    /**
     * Function deleted repetitive word
     * @param text
     * @return
     */
    public static String deleteSample (String text) {
        String [] result;
        String finaly = "";
        result = text.split(" ");

        for (int i = 1; i < result.length; i++)         //usun spacje obok sb
            if (result[i].equals(""))
                result[i] = result[i - 1];

        for (int i = 0; i < result.length; i++)         //przejdz po wszystkich wyrazach i sprawdz, czy kolejny nie jest taki sam
            if (i != result.length - 1 && result[i].equals(result[i + 1]))
                finaly += "";                              //usun z tablicy - zamien na pusty string
            else
                finaly += result[i] + " ";

        return finaly;
    }
}
