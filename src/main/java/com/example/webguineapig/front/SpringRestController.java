package com.example.webguineapig.front;

import com.example.webguineapig.middle.MiddleDistributor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springrest")
public class SpringRestController {

    private final MiddleDistributor middleDistributor;

    public SpringRestController(MiddleDistributor middleDistributor) {
        this.middleDistributor = middleDistributor;
    }

    @GetMapping
    public void get(@RequestParam String payload) {
        middleDistributor.proceed(payload);
    }

}
