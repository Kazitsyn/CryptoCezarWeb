package com.example.CryptoCezarWeb.controllers.rest;

import com.example.CryptoCezarWeb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/base/{word}")
    public String baseCryptoCezar(@PathVariable String word){
        return userService.cezar(word);
    }

    @GetMapping("/base")
    public String baseCrypto(@RequestParam String word, @RequestParam int pinCode){
        return userService.baseCrypto(word, pinCode);
    }
}
