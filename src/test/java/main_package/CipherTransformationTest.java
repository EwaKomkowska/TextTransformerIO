package main_package;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CipherTransformationTest {
    private Transformation t;

    @BeforeEach
    public void setup() {
        t = new SimpleTransformation();
    }

    @Test
    public void caesarCodeTest() {
        t = new CipherTransformation(t);
        String[] predicted = new String[3];
        String[] result =  {"BUHEŁI", "nryhn", "Ćńć óć śwć-012"};

        predicted[0] = t.transform("ŹREBIĘ", 0);
        predicted[1] = t.transform("kotek", 0);
        predicted[2] = t.transform("Ala ma psa-012", 0);

        Assert.assertArrayEquals(result, predicted);
    }
}
