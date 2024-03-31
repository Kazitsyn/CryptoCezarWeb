package com.example.CryptoCezarWeb.controller.web;

import com.example.CryptoCezarWeb.domen.Pin;
import com.example.CryptoCezarWeb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserWebController {
    private final UserService userService;

    @GetMapping("/home-crypto/{word}")
    public String webHomeGet(Model model, @RequestParam String word){
        String result = userService.cezar(word);
        model.addAttribute("message", result);
        return "base-crypto-result";
    }

    @GetMapping("/base-crypto")
    public String webBase(Pin pin){

        return "base-crypto";
    }
    @PostMapping("/base-crypto")
    public String webHome(Pin pin, @RequestParam String word){
        userService.getCrypto().setPin(pin);
        return "redirect:/home-crypto/{"+word+"}";
    }
}
