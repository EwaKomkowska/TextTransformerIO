package com.company;

import org.w3c.dom.Text;

import javax.print.attribute.standard.MediaSize;
import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

public class Main {



    public static void main(String[] args) {
        System.out.println(TextTransformation.upper("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.lower("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.Capital("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.Inverse("Kajak"));
        System.out.println(TextTransformation.Inverse("Motohalucynka"));

    }
}
