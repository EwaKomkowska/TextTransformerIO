package main_package;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class ShortcutTransformationTest {
    private Transformation t;

    @BeforeEach
    public void setup() {
        t = new SimpleTransformation();
    }

    @Test
    public void toLatexTest() {
        //t = new ShortcutTransformation(t);
        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"kot\\&pies", "Zapłać 100\\$", "MAm przy sobie 5\\$ \\& 30zł"};

        predicted[0] = t.transform("kot&pies", 2);
        predicted[1] = t.transform("Zapłać 100$", 2);
        predicted[2] = t.transform("MAm przy sobie 5$ & 30zł", 2);

        //Assert.assertArrayEquals(result, predicted);
        for (int i = 0; i < 3; i++)
            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void wordToShortcutTest () {
        //t = new ShortcutTransformation(t);
        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result = {"Zadania do wykonania itd.", "m.in. lubię też biegać itd.", "Pieczywo to np. chleb i bułki"};

        predicted[0] = t.transform("Zadania do wykonania I tym PodoBne", 0);
        predicted[1] = t.transform("Między innymi lubię też biegać i tym podobne", 0);
        predicted[2] = t.transform("Pieczywo to na przykład chleb i bułki", 0);

        //Assert.assertArrayEquals(result, predicted);
        for (int i = 0; i < 3; i++)
            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void  shortcutToWordTest () {
        //t = new ShortcutTransformation(t);
        t = mock(ShortcutTransformation.class);

        String[] predicted = new String[3];
        String[] result = {"Pan Profesor spóźnił się na zajęcia", "Na spacer do sklepu I TYM PODOBNE", "Pan doktor ma dobre informacje"};

        predicted[0] = t.transform("Pan Prof. spóźnił się na zajęcia", 1);
        predicted[1] = t.transform("Na spacer do sklepu ITD.", 1);
        predicted[2] = t.transform("Pan dr ma dobre informacje", 1);

        //Assert.assertArrayEquals(result, predicted);
        for (int i = 0; i < 3; i++)
            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

}
