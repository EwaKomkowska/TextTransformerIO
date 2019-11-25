package main_package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println(TextTransformation.upper("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.lower("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.Capital("Państwo Izrael bezprawnie okupuje tereny Palestyny."));
        System.out.println(TextTransformation.Inverse("Kajak"));
        System.out.println(TextTransformation.Inverse("Motohalucynka"));

        SpringApplication.run(Main.class, args);
    }
}
