package com.example.CryptoCezarWeb.controller.web;

import com.example.CryptoCezarWeb.domen.FormData;
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
    private FormData form;

    @GetMapping("/home-crypto")
    public String webHomeGet(Model model){
        String result = userService.cezar(form.getWord());
        model.addAttribute("message", result);
        return "base-crypto-result";
    }

    @GetMapping("/base-crypto")
    public String webBase(Pin pin){

        return "base-crypto";
    }
    @PostMapping("/base-crypto")
    public String webHome(FormData formData){
        userService.getCrypto().getPin().setPinNumber(formData.getPinCode());
        String word = formData.getWord();
        return "redirect:/home-crypto/{"+word+"}";
    }

    @GetMapping("/main")
    public String webBaseMain(FormData formData){

        return "main";
    }
    @PostMapping("/main")
    public String webHomeMain(FormData formData){
        userService.getCrypto().getPin().setPinNumber(formData.getPinCode());
        form = formData;
        return "redirect:/home-crypto";
    }
}
