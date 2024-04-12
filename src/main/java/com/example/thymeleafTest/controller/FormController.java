package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Country;
import com.example.thymeleafTest.vo.FormDto;
import com.example.thymeleafTest.vo.Language;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class FormController {

    @ModelAttribute("language")
//    modelattribute에 자동으로 넣어주는 역할 @ModelAttribute
    private Language[] languages(){
        return Language.values();
    }

    @ModelAttribute("country")
    private Country[] countries(){
        return Country.values();
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("dto",new FormDto());
//        model.addAttribute("hobbies",map);
        modelHobbies(model);
        System.out.println();
        return "/form-test/form";
    }

    private void modelHobbies(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("game", "게임하기");
        map.put("running", "런닝하기");
        model.addAttribute("hobbies",map);
    }

    @PostMapping("/form")
    public String postForm(@ModelAttribute("dto") FormDto dto) {
        log.info("=============== FormDto.name = " + dto.getName());
        log.info("=============== FormDto.trueOrFalse = " + dto.isTrueOrFalse());
        List<String> hobbies = dto.getHobbies();
        for(String hobby : hobbies) {
            log.info("dto.hobby = " + hobby);
        }
        log.info("Language = " + dto.getLanguage());
        log.info("Country = " + dto.getCountry());
        return "/form-test/form";
    }

    @ModelAttribute("hobbies")
    private Map<String, String> favorite(){
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("game", "게임하기");
        map.put("running", "런닝하기");
//        model.addAttribute("hobbies",map);
        return map;
    }
}
