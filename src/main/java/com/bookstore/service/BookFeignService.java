package com.bookstore.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8083/", name = "BOOK-SERVICE")
public interface BookFeignService {

    @GetMapping("/getbookdetails")
    public ResponseEntity<String> getBookDetails();
}
