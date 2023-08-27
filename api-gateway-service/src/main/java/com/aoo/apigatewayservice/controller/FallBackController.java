package com.aoo.apigatewayservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallBackController {
    @GetMapping("/fallback/productsServiceFallBack")
    public ResponseEntity<String> productsServiceFallBackMethod(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(" product service is not available now please try it later");
    }
    @GetMapping("/fallback/orderServiceFallBack")
    public ResponseEntity<String> orderServiceFallBackMethod(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(" order service is not available now please try it later");
    }
    @GetMapping("/logedout")
    public String ssologout(){
        return "you successfully logout!";
    }
}
