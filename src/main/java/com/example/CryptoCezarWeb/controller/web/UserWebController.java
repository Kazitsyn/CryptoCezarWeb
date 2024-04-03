package com.example.CryptoCezarWeb.controller.web;

import com.example.CryptoCezarWeb.domen.FormData;
import com.example.CryptoCezarWeb.domen.LayoutEntity;
import com.example.CryptoCezarWeb.domen.Pin;
import com.example.CryptoCezarWeb.service.CryptoService;
import com.example.CryptoCezarWeb.service.LayoutService;
import com.example.CryptoCezarWeb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserWebController {
//    private final UserService userService;
    private final LayoutService layoutService;
    private CryptoService cryptoService;
//    private FormData form;

    @GetMapping("/home-crypto")
    public String webHomeGet(Model model){
        String result = cryptoService.cezar();
        model.addAttribute("message", result);
        return "result";
    }

//    @GetMapping("/base-crypto")
//    public String webBase(Pin pin){
//
//        return "base-crypto";
//    }
//    @PostMapping("/base-crypto")
//    public String webHome(FormData formData){
////        userService.getCrypto().getPin().setPinNumber(formData.getPinCode());
//        String word = formData.getWord();
//        return "redirect:/home-crypto/{"+word+"}";
//    }

    @GetMapping("/add-layout")
    public String webGetAddLayout(LayoutEntity layout, Model model){
        model.addAttribute("layouts", layoutService.findAll());
        return "/add-layout";
    }

    @PostMapping("/add-layout")
    public String webPostAddLayout(LayoutEntity layout, Model model, FormData formData){
        layoutService.addLayoutEntity(layout);

        return webGetMain(formData,model);
    }
    @GetMapping("/main")
    public String webGetMain(FormData formData, Model model){
        List<LayoutEntity> entity = layoutService.findAll();
        List<String> items = new ArrayList<>();
        entity.forEach(entityLayout -> {
            items.add(entityLayout.getTitle());
        });
        model.addAttribute("items", items);
        model.addAttribute("layouts", entity);
        return "main";
    }
    @PostMapping("/main")
    public String webPostMain(FormData formData){
        cryptoService.init(formData);
        return "redirect:/home-crypto";
    }
}
