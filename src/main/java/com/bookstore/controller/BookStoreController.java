package com.bookstore.controller;

import java.util.Arrays;

import com.bookstore.bean.ExceptionStatus;
import com.bookstore.service.BookFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookstore.bean.BookDetails;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * This class for add book details, get the book information and author details
 * @author nvakiti
 *
 */
@RestController
public class BookStoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookStoreController.class);

	@Autowired
	private BookFeignService bookFeignService;
	
	/**
	 * Calling Books Rest API to fetch books details
	 * @author nvakiti
	 * @return json
	 */
	@GetMapping("/getbooks")
	@HystrixCommand(fallbackMethod = "getBooksFallback")
	public String getBooks() {
		
		String uri = "http://localhost:8083/getbookdetails";
		logger.info("API URI "+uri);
		String response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			response = result.getBody();
			logger.info("Book Details Respose "+response);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}
	
	
	/**
	 * Fall back method, when /getbooks service is down then fall back method will call to show info
	 * @author nvakiti
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getBooksFallback() {
		logger.info("Started fallback getBooksFallback() for /getbooks");
	    return "Service is not available, please try again later";
	}

	@PostMapping("/addbooks")
	public String addBooks(@RequestBody BookDetails bookDetails) {
		String uri = "http://localhost:8083/addbookdetails";
		logger.info("API URI "+uri);
		String response = null;
		try {
			String request = new Gson().toJson(bookDetails);
			logger.info("Book Details Payload "+request);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(request, headers);
			ResponseEntity<String> result  = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
			response = result.getBody();
			logger.info("Add Books Respose "+response);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}


	@GetMapping("/getbookdetails")
	public String getBookDetails(){
		ResponseEntity<String> responseEntity = null;
		String response = null;
		try{
			responseEntity  = bookFeignService.getBookDetails();
			response = responseEntity.getBody();

		}catch(Exception e){
			logger.error("Exception while fetching book details :: "+e.getMessage());
			ExceptionStatus status = new ExceptionStatus("Unable to fetch book details",
					"Exception while fetching book details for your request",400,"/getbookdetails");
			response = new Gson().toJson(status);
		}
		return response;
	}

}
