package com.Test.Demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {
    public ResponseEntity <String>sayHello(){
        return ResponseEntity.ok("Hello from tunisia");
    }
    @GetMapping("/Hello")
    public ResponseEntity<String>Hello(){
        return ResponseEntity.ok("by");
    }
}
