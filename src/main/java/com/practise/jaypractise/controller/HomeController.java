package com.practise.jaypractise.controller;


import com.practise.jaypractise.models.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {



    @GetMapping("/test")
    public Test<String> getObject() {
        Test<String> t = new Test<String>("Hello World");
        return t;
    }

    @GetMapping("/functionalWay")
    public String tryFunctional() {
        List<Integer> list = Arrays.asList(2,3,4,5,6,7,8);
        return list.stream().map( n -> n * 3 ).toString();
    }

}
