package com.fatihk.examples.springboot.sessionredisexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public String greeting(HttpServletRequest request, @RequestParam("msg") String msg){
        List<String> msgs = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (msgs == null) {
            msgs = new ArrayList<>();
        }
        msgs.add(msg);
        System.out.println(msgs);
        //session is stored in redis
        request.getSession().setAttribute("MY_SESSION_MESSAGES", msgs);
        return "Welcome admin";
    }

}
