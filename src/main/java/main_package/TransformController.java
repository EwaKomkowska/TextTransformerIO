package main_package;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransformController
{
    @RequestMapping
    public Placeholder answer(@RequestBody String payload){
        return new Placeholder(payload, 1);
    }
}
