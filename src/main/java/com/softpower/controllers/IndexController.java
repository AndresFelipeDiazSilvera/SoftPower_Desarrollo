package com.softpower.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
    @GetMapping("/inicio")
    public String index(){
        return "/inicio/inicio";
    }

}
