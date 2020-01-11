package main_package;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TransformationTest {
    private Transformation t;

    @Before
    public void setup() {
        t = new SimpleTransformation();
    }

    @Test
    public void upperTest() {
        Transformation tx = new TextTransformation(t, 0);
//        t = mock(TextTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"ŹREBIĘ", "MŁODE ŹREBIĘ", "ŹREBIĘ-012"};

        predicted[0] = tx.transform("ŹREBIĘ");
        predicted[1] = tx.transform("młode źrebię");
        predicted[2] = tx.transform("ŹrEbIĘ-012");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }
    @Test
    public void lowerTest() {
        Transformation tx = new TextTransformation(t, 1);
//        t = mock(TextTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"źrebię", "młode źrebię", "źrebię-012"};

        predicted[0] = tx.transform("ŹREBIĘ");
        predicted[1] = tx.transform("młode źrebię");
        predicted[2] = tx.transform("ŹrEbIĘ-012");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }
    @Test
    public void inverseTest() {
        Transformation tx = new TextTransformation(t, 2);
//        t = mock(TextTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"Ęiberź", "Edołm Ęiberź", "210-ęiberź"};

        predicted[0] = tx.transform("Źrebię");
        predicted[1] = tx.transform("Młode Źrebię");
        predicted[2] = tx.transform("źrebię-012");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test // change to delete space after
    public void capitalTest() {
        Transformation tx = new TextTransformation(t, 3);
//        t = mock(TextTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"Źrebię ", "Młode Źrebię ", "Źrebię-012 "};

        predicted[0] = tx.transform("źrebię");
        predicted[1] = tx.transform("Młode źrebię");
        predicted[2] = tx.transform("źrebię-012");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void repetitionTest() {
        Transformation tx = new TextTransformation(t, 4);
//        t = mock(TextTransformation.class);

        String[] predicted = new String[3];
        String[] result =  {"Spacer do sklepu", "Spacer do sklepu po bułki", "Myślę że masz rację"};

        predicted[0] = tx.transform("Spacer do do do do sklepu");
        predicted[1] = tx.transform("Spacer do do sklepu po po po bułki   ");
        predicted[2] = tx.transform("Myślę że że masz masz rację rację");

        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }

    @Test
    public void transformNumberTest() {
//        t = mock(NumberTransformation.class);
        Transformation tx = new NumberTransformation(t, 0);

        String[] predicted = new String[4];
        String[] result =  {"sto dwadzieścia trzy", "dziewięćdziesiąt dziewięć setnych", "wpiszę jakiś tekst niebędący liczbą", "zero"};

        predicted[0] = tx.transform("123");
        predicted[1] = tx.transform("0.99");
        predicted[2] = tx.transform("wpiszę jakiś tekst niebędący liczbą");
        predicted[3] = tx.transform("0");



        Assert.assertArrayEquals(result, predicted);
//        for (int i = 0; i < 3; i++)
//            when(t.transform(predicted[i], 0)).thenReturn(result[i]);
    }
}
