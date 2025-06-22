package com.example.recipe.common.handler.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class BaseAdvice {

    protected static final String REQUEST_ID_HEADER = "X-Request-Id";
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        headers.add("Access-Control-Allow-Headers", "*");
//        headers.add("Access-Control-Allow-Credentials", "true");
        return headers;
    }
}
