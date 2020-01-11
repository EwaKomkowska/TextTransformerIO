package main_package;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TransformationDecoratorTest {

    private SimpleTransformation st;

    @Before
    public void setup() {
        st = new SimpleTransformation();
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
    public void multipleDecorationTestOfSameClass()
    {
        TextTransformation t1 = new TextTransformation(st, 4);
        TextTransformation t2 = new TextTransformation(t1, 1);

        Assert.assertEquals(t2.transform("KrÓl KrÓl Król król KRÓL"), "król");
    }
}