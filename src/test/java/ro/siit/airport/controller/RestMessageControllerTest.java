package ro.siit.airport.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestMessageControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllMessages() {
        try {
            ResponseEntity<List> responseEntity = restTemplate.getForEntity(
                    new URI("http://localhost:" + port + "/search/airports?countryId=1"), List.class);
            Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());

        } catch (URISyntaxException e) {
            System.err.println(e);
        }
    }

    @Test
    void testGetAllAirportByCountry() {
        try {
            ResponseEntity<List> responseEntity = restTemplate.getForEntity(
                    new URI("http://localhost:" + port + "/search/airports?countryId=1"), List.class);
            Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());

        } catch (URISyntaxException e) {
            System.err.println(e);
        }
    }

    @Test
    void getAllAirlineByCountry() {
        try {
            ResponseEntity<List> responseEntity = restTemplate.getForEntity(
                    new URI("http://localhost:" + port + "/airline/airlines?countryId=1"), List.class);
            Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());

        } catch (URISyntaxException e) {
            System.err.println(e);
        }
    }
}