package main_package;

import java.util.HashMap;

public class CipherTransformation extends TransformationDecorator{


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

    /**
     * Constructor of abstract transformation decorator.
     *
     * @param t decorated transformation
     */
    public CipherTransformation(Transformation t) {
        super(t);
    }



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

        //delete end space
        if (finaly.length() >= 1)
            finaly = finaly.substring(0, finaly.length()-1);


        return finaly;
    }


    /**
     * Main function that depends on given index returns:
     * 0: CipherTransformation
     * 1: Permutation
     * @param text custom String given by user
     * @param index transformation index (doesn't matter in this subclass)
     * @return text after transformation
     */
    @Override
    public String transform(String text, int index) {
        switch (index) {
            case 0:
                return caesarCode(text);
            case 1:
                return "Tutaj musi byc funkcja do transformacji";
            default:
                return "Uratowałeś mnie! Ale Twoja funkcja jest w innym zamku!";
        }
    }
}
