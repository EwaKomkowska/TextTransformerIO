package main_package;

import java.util.HashMap;

public class ShortcutTransformation {

    private static HashMap<String, String> shortcuts = new HashMap<String, String>() {{
        put("np.", "na przykład");
        put("m.in", "między innymi");
        put("itd.", "i tym podobne");
        put("prof.", "profesor");
        put("dr", "doktor");
    }};

    private static String transform(String text) {
        //Pattern pattern = Pattern.compile("[REG-EXP]");
        // pattern.matcher("tekst").matches();
        // żeby nie zwracać uwagi na wielkość liter ?
        return shortcuts.get(text);
    };

    /**
     * Load from file predefined shortcuts.
     */
    private static void LoadFromFile() {

    }
}
