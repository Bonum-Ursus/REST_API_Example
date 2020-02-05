package com.example.restservice;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name,
            @RequestParam(value="id", required=false, defaultValue="0") String id
            ) {
        System.out.println("ID: " + id + "\n" + "Name: " + name);
        return new Greeting(Integer.parseInt(id),
                String.format(template, name));
    }
}
