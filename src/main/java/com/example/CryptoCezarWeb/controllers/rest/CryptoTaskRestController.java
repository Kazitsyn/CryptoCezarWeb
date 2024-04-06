package com.example.CryptoCezarWeb.controllers.rest;

import com.example.CryptoCezarWeb.models.FormData;
import com.example.CryptoCezarWeb.services.iServiceTaskREST;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CryptoTaskRestController {
    private final iServiceTaskREST restService;


    @GetMapping("/order")
    public ResponseEntity<String> cryptoTaskParam(@RequestParam String siteName, @RequestParam int pinCode,
                             @RequestParam int passportSize, @RequestParam Long id){
        return new ResponseEntity<>(restService.cryptoTaskParam(siteName,pinCode,passportSize,id), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<String> cryptoTaskForm(@RequestBody FormData formData) {
        return new ResponseEntity<>(restService.cryptoTaskFormData(formData), HttpStatus.OK);
    }

}
