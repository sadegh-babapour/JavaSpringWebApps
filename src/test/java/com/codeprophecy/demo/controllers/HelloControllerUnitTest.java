package com.codeprophecy.demo.controllers;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HelloControllerUnitTest
{
    @Test
    public void sayHello()
    {
        HelloController theController = new HelloController();
        Model myModel = new BindingAwareModelMap();
        String javab = theController.greetings("Mahmoud", myModel);
        assertEquals("hello", javab);
        assertEquals("Mahmoud", myModel.asMap().get("theUser"));
    }
}
