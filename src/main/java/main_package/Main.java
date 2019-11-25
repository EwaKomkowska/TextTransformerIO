package main_package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        Transformation t = new SimpleTransformation();

        t = new TextTransformation(t);
        System.out.println(t.transform("Państwo Izrael bezprawnie okupuje tereny Palestyny.",1));
        System.out.println(t.transform("Państwo Izrael bezprawnie okupuje tereny Palestyny.",2));
        SpringApplication.run(Main.class, args);
    }
}
