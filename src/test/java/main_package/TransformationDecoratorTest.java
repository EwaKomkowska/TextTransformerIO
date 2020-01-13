package main_package;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TransformationDecoratorTest {

    private SimpleTransformation st;
    private TextTransformation t1;
    private TransformController tc;

    @Before
    public void setup() {
        st = new SimpleTransformation();
        t1 = new TextTransformation(st, 4);
        tc = new TransformController();
    }
  
    @Test
    public void decorationTest()
    {
        st = mock(SimpleTransformation.class);
        when(st.transform("xDDDD")).thenReturn("xDDDDD");

        ShortcutTransformation t = new ShortcutTransformation(st, 1);

        t.transform("xD");
        verify(st).transform(anyString());
    }

    @Test
    public void multipleSameClassDecorationTest()
    {
        TextTransformation t2 = new TextTransformation(t1, 1);

        Assert.assertEquals(t2.transform("KrÓl KrÓl Król król KRÓL"), "król");
    }

    @Test
    public void multipleDecorationTest()
    {

        // transformations are performed from bottom to top                        // remove repetitions (t1 transform)
        CipherTransformation t2 = new CipherTransformation(t1, 0);          // Caesar shift +4 (a -> ć and so on)
        TextTransformation t3 = new TextTransformation(t2, 1);              // to lower case


        String res = t3.transform("TeKsT tekst TEKST tekst TEkSt");

        Assert.assertEquals("yhnwy", res);
    }

    @Test
    public void controllerTest(){
        Placeholder pl = tc.answer("{\n" +
                "\t\"text\": \"9 9 9 xD xD xD 12 12 12 12\",\n" +
                "\t\"classID\": 3,\n" +
                "\t\"functionID\": 4   \n" +
                "}");

        Assert.assertEquals("9 xD 12", pl.getText());
        Assert.assertEquals(3, pl.getClassID());
        Assert.assertEquals(4, pl.getFunctionID());
    }

    @Test(expected = NullPointerException.class)
    public void controllerEmptyJSONTest(){
        Placeholder pl = tc.answer("{}");
        String f = pl.getText().toLowerCase();
        System.out.println(f);
    }

    // expected behaviour is to print stack trace and obtain a placeholder
    // with "Error" message
    @Test
    public void controllerEmptyStringTest()
    {
        Placeholder pl1 = tc.answer("");
        Placeholder pl2 = tc.answer("{\n" +
                "\t\"text\": \"9 9 9 xD xD xD 12 12 12 12\",\n" +
                "\t\"classID\": \"tu wpisz tekst\",\n" +
                "\t\"functionID\": \"ciekawe co się stanie\"   \n" +
                "}");
        Assert.assertEquals(pl1.getText(), "Error");
        Assert.assertEquals(pl2.getText(), "Error");
    }
}