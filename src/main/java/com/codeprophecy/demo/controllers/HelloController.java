package com.codeprophecy.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController
{





    @GetMapping("/hello")
    public String greetings(
            @RequestParam(defaultValue = "Universe!", required = false)
                    String name,
            Model myModel)
    {
        myModel.addAttribute("theUser", name);
        return "hello";
    }


    @GetMapping("/goodbye")
    public String sayBye(
            @RequestParam(defaultValue = "Little Piggy", required = false) String farewell,
            Model aModel
    )
    {
        aModel.addAttribute("whoIsThis", farewell);
        return "goodbye";

    }

}
