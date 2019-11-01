package com.codeprophecy.demo.controllers;



// static imports
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
// this is done to ignore the initilization error
//@Ignore
public class HelloControllerMVCMockTest
{
    @Autowired
    private MockMvc myMVC;

    @Test
    public void testHelloWithoutName() throws Exception
    {

            myMVC.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk())
                    .andExpect(view().name("hello"))
                    .andExpect(model().attribute("theUser", is("Universe!")));

    }


    @Test
    public void testHelloWithName() throws Exception
    {

            myMVC.perform(
                    get("/hello")
                            .param("name", "Abbas")
                            .accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk())
                    .andExpect(view().name("hello"))
                    .andExpect(model().attribute("theUser", is("Abbas")));

    }
}
