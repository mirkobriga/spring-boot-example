package com.project.example.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = "/error")
    public String myerror(HttpServletRequest request) {
        return (String) request.getAttribute("javax.servlet.error.message");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
