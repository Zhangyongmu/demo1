package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SpringBoot/JSP")
public class JspController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
