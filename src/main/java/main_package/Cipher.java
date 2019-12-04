package main_package;

import java.util.HashMap;

public class Cipher {

    private static final HashMap<String,String> alphabet = new HashMap<String, String>() {{
        put ("a", "ć");
        put ("ą", "d");
        put ("b", "e");
        put ("c", "ę");
        put ("ć", "f");
        put ("d", "g");
        put ("e", "h");
        put ("ę", "i");
        put ("f", "j");
        put ("g", "k");
        put ("h", "l");
        put ("i", "ł");
        put ("j", "m");
        put ("k", "n");
        put ("l", "ń");
        put ("ł", "o");
        put ("m", "ó");
        put ("n", "p");
        put ("ń", "q");
        put ("o", "r");
        put ("ó", "s");
        put ("p", "ś");
        put ("q", "t");
        put ("r", "u");
        put ("s", "w");
        put ("ś", "x");
        put ("t", "y");
        put ("u", "z");
        put ("w", "ź");
        put ("x", "ż");
        put ("y", "a");
        put ("z", "ą");
        put ("ź", "b");
        put ("ż", "c");
    }};


    public static String caesarCode (String text) {
        String [] result, pom;
        String finaly = "", letter;
        result = text.split(" ");

        for (int i = 0; i < result.length; i++) {
            pom = result[i].split("");
            for (int j = 0; j < pom.length; j++) {
                letter = alphabet.get(pom[j].toLowerCase());
                if (letter == null)
                    finaly += pom[j];
                else if (pom[j] == pom[j].toLowerCase())
                    finaly += letter;
                else
                    finaly += letter.toUpperCase();
            }
            finaly += " ";
        }

        return finaly;
    }


}
