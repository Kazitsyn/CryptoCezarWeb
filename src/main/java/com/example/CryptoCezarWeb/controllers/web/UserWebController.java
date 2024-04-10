package com.example.CryptoCezarWeb.controllers.web;

import com.example.CryptoCezarWeb.models.FormData;
import com.example.CryptoCezarWeb.models.LayoutEntity;
import com.example.CryptoCezarWeb.services.LayoutService;
import com.example.CryptoCezarWeb.services.iServiceLayoutEntity;
import com.example.CryptoCezarWeb.services.iServiceWeb;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserWebController {
    private final iServiceLayoutEntity layoutService;
    private iServiceWeb serviceWeb;

    /**
     * Главная страница
     * @param formData класс заполнения формы
     * @param model модель
     * @return вызыв html страницы
     */
    @GetMapping("/main")
    public String webGetMain(FormData formData, Model model){
        List<LayoutEntity> entity = layoutService.findAll();
        List<String> items = new ArrayList<>();
        entity.forEach(entityLayout -> {
            items.add(entityLayout.getId().toString() +": "+entityLayout.getTitle());
        });
        model.addAttribute("items", items);
        model.addAttribute("layouts", entity);
        return "main";
    }

    /**
     * Обработка POST запроса главной страницы
     * @param formData класс заполнения формы
     * @return переадресация на страницу с результатами
     */
    @PostMapping("/main")
    public String webPostMain(FormData formData, LayoutEntity layout){
        serviceWeb.init(formData);
        return "redirect:/result";
    }

    /**
     * Страница с результатом решенной крипто задачи
     * @param model модель
     * @return вызыв html страницы
     */
    @GetMapping("/result")
    public String webHomeGet(Model model){
        String result = serviceWeb.cezar();
        model.addAttribute("message", result);
        return "result";
    }

    /**
     * Страница добавления последовательности
     * @param layout последовательность
     * @param model модель
     * @return вызыв html страницы
     */
    @GetMapping("/add-layout")
    public String webGetAddLayout(LayoutEntity layout, Model model){
        model.addAttribute("layouts", layoutService.findAll());
        return "add-layout";
    }

    /**
     * Обработка POST при вводе новой последовательности
     * @param layout последовательность
     * @param model модель
     * @param formData форма для заполнения данных
     * @return возврат на главную страницу
     */
    @PostMapping("/add-layout")
    public String webPostAddLayout(LayoutEntity layout, Model model, FormData formData){
        layoutService.addLayoutEntity(layout);
        return webGetMain(formData,model);
    }
}
