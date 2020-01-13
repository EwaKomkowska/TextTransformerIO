package main_package;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TransformationDecoratorTest {

    private SimpleTransformation st;
    private TextTransformation t1;

    @Before
    public void setup() {
        st = new SimpleTransformation();
        t1 = new TextTransformation(st, 4);
    }
  
    @Test
    public void decorationTest()
    {
        st = mock(SimpleTransformation.class);
        when(st.transform("xDDDD")).thenReturn("xDDDDD");

        ShortcutTransformation t = new ShortcutTransformation(st, 1);

        t.transform("xD");
        verify(st, atLeastOnce()).transform(anyString());
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

        // transformations are performed from bottom to top             // remove repetitions
        CipherTransformation t2 = new CipherTransformation(t1, 0);          // Caesar shift +4 (a -> ć and so on)
        TextTransformation t3 = new TextTransformation(t2, 1);              // to lower case


        String res = t3.transform("TeKsT tekst TEKST tekst TEkSt");

        Assert.assertEquals("yhnwy", res);
    }

    @Test
    public void callCheckTest()
    {

    }
}