package main_package;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class ShortcutTransformationTest {
    private Transformation t;

    @Before
    public void setup() {
        t = new SimpleTransformation();
    }

    @Test
    public void toShortcutTest(){
        String s[] = new String[3];
        String res[] = {
                "itp.",
                "m.in.",
                "np."
        };
        s[0] = ShortcutTransformation.wordToShortcut("i tym podobne");
        s[1] = ShortcutTransformation.wordToShortcut("między innymi");
        s[2] = ShortcutTransformation.wordToShortcut("na przykład");

        Assert.assertArrayEquals(s, res);
    }


    @Test
    public void toLatexTest() {
        t = new ShortcutTransformation(t, 2);
//        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"kot\\&pies", "Zapłać 100\\$", "MAm przy sobie 5\\$ \\& 30zł"};

        predicted[0] = t.transform("kot&pies");
        predicted[1] = t.transform("Zapłać 100$");
        predicted[2] = t.transform("MAm przy sobie 5$ & 30zł");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void wordToShortcutTest () {
        t = new ShortcutTransformation(t, 0);
//        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result = {"Zadania do wykonania itd.", "m.in. lubię też biegać itd.", "Pieczywo to np. chleb i bułki"};

        predicted[0] = t.transform("Zadania do wykonania I tym PodoBne");
        predicted[1] = t.transform("Między innymi lubię też biegać i tym podobne");
        predicted[2] = t.transform("Pieczywo to na przykład chleb i bułki");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void  shortcutToWordTest () {
        t = new ShortcutTransformation(t, 1);
//        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result = {"Pan Profesor spóźnił się na zajęcia", "Na spacer do sklepu I TYM PODOBNE", "Pan doktor ma dobre informacje"};

        predicted[0] = t.transform("Pan Prof. spóźnił się na zajęcia");
        predicted[1] = t.transform("Na spacer do sklepu ITD.");
        predicted[2] = t.transform("Pan dr ma dobre informacje");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

}
