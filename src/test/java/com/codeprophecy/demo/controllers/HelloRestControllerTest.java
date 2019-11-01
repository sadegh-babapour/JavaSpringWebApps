package com.codeprophecy.demo.controllers;

import com.codeprophecy.demo.entities.Salut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest
{
    @Autowired
    private TestRestTemplate template;

    @Test
    public void salutWithoutName()
    {
        ResponseEntity<Salut> entity = template.getForEntity("/rest", Salut.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Salut response = entity.getBody();
        assertEquals("Bon Journo, Haj Abbas", response.getMessage());
    }

    @Test
    public void salutWithName()
    {
        ResponseEntity<Salut> entity = template.getForEntity("/rest", Salut.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());

        Salut response = template.getForObject("/rest?nomre=Koskesh", Salut.class);
        assertEquals(String.format("Bon Journo, %s", "Koskesh"), response.getMessage());
    }

}
