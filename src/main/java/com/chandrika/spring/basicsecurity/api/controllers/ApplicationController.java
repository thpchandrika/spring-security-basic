package com.chandrika.spring.basicsecurity.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @GetMapping("/getMessage")
    public String getMessage(){
        return "Hello welcome. Spring security works";
    }
}
