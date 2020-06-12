package com.bookstore.controller;

import com.bookstore.bean.BookDetails;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    /**
     * Calling Author Rest API to fetch author details
     * @author nvakiti
     * @return
     */
    @GetMapping("/getauthor")
    public String getAuthor() {
        String uri = "http://localhost:8083/getauthordetails";
        logger.info("API URI "+uri);
        String response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> result  = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            response = result.getBody();
            logger.info("Author Details Respose "+response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return response;
    }


}
