package main_package;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TransformationDecoratorTest {
    private Transformation t;

    @BeforeEach
    void setUp() {
        t = new SimpleTransformation();
    }
     /* 0: upper text
     * 1: lower text
     * 2: inverse text
     * 3: capital letters
     * 4: without repetitions
     */
    @Test
    public void textUpperTest() {
        t = new TextTransformation(t);

        String[] predict = new String[3];
        String[] result = new String[3];

        predict[0] = t.transform("WIELKIE",0);
        result[0] = "WIELKIE";

        predict[1] = "małe";
        result[1] = "MAŁE";

        predict[2] = "źrEbiĘ";
        result[2] = "ŹREBIĘ";

        Assert.assertArrayEquals(predict, result);
    }

    @Test
    public void textLowerTest() {

    }

    @Test
    public void textCapitalTest() {

    }

    @Test
    public void textInverseTest() {

    }

    @Test
    public void textDeleteSampleTest() {

    }

}