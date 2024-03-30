package com.example.CryptoCezarWeb.controller.rest;

import com.example.CryptoCezarWeb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/base/{word}")
    public String baseCrypto(@PathVariable String word){
        return userService.cezar(word);
    }
}
