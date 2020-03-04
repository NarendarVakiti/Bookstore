package com.bookstore.controller;

import java.util.Arrays;

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

@RestController
public class BookStoreController {
	
	/**
	 * Calling Books Rest API to fetch books details
	 * @return json
	 */
	@GetMapping("/getbooks")
	@HystrixCommand(fallbackMethod = "getBooksFallback")
	public String getBooks() {
		String uri = "http://localhost:8083/getbookdetails";
		String response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			response = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return response;
	}
	
	
	/**
	 * Fall back method, when /getbooks service is down then fall back method will call to show info
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getBooksFallback() {
	      return "Service is not available, please try again later";
	}
	
	
	/**
	 * Calling Author Rest API to fetch author details
	 * @return
	 */
	@GetMapping("/getauthor")
	public String getAuthor() {
		String uri = "http://localhost:8083/getauthordetails";
		String response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> result  = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			response = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return response;
	}
	
	@PostMapping("/addbooks")
	public String addBooks(@RequestBody BookDetails bookDetails) {
		String uri = "http://localhost:8083/addbookdetails";
		String response = null;
		try {
			String request = new Gson().toJson(bookDetails);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(request, headers);
			ResponseEntity<String> result  = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
			response = result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	

}
