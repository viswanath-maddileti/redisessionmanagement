package com.viswa.redisessionmanagement.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/session")
public class SessionController { 

    @GetMapping("/set/{value}")
    public String setSessionValue(@PathVariable String value, HttpSession session) {
        session.setAttribute("userValue", value);
        return "Stored in session: " + value;
    }

    @GetMapping("/get")
    public String getSessionValue(HttpSession session) {
        Object value = session.getAttribute("userValue");
        return "Session value: " + value;
    }
}

