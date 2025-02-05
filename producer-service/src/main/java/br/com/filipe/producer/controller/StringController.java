package br.com.filipe.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.filipe.producer.services.StringService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/produces")
public class StringController {
    
    private final StringService service;
    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message)
    {
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }

}

