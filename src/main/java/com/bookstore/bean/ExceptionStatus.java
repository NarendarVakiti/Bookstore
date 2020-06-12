package com.bookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class ExceptionStatus {
    private String message;
    private String details;
    private int statuscode;
    private String url;
}
