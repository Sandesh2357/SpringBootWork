package org.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APItest {
    @GetMapping("color")
    public Car getName(){
        Car c1 = new Car("golden");
        MailHandlerBase.senMail(c1.toString());
        return c1;
    }
}
