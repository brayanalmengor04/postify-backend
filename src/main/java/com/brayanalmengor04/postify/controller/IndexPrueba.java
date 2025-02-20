package com.brayanalmengor04.postify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexPrueba {

    @GetMapping("/test")  // URL: http://localhost:8080/test
    @ResponseBody
    public String test() {
        return "¡Todo funciona correctamente!";
    }
}
