package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Email;
import com.example.thymeleafTest.vo.LogIn;
import com.example.thymeleafTest.vo.Sex;
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
public class FromControlController {
@ModelAttribute("sex")
private Sex[] sexes(){
    return Sex.values();
}

@ModelAttribute("email")
private Email[] emails(){
    return Email.values();
}
    @GetMapping("/formControl")
    public String signUp(Model model){
        model.addAttribute("dto",new LogIn());
        modelagrees(model);
        System.out.println();
        return "/form-test/formControlResultView";
    }

    private void modelagrees(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("agree","전체 동의합니다.");
        map.put("agree(2)","이용약관 동의");
        map.put("Privacy", "개인정보 수집및이용 동의(필수)");
        map.put("Privacy(2)", "개인정보 수집및이용 동의(선택)");
        model.addAttribute("agrees",map);

    }

    @PostMapping("/fromControl")
    public String signOut(@ModelAttribute("dto") LogIn dto) {
    log.info("Login.id = " + dto.getId());
    log.info("Login.password = " + dto.getPassword());
    log.info("Login.name = " + dto.getName());
    log.info("Login.date = " + dto.getDate());
    log.info("Login.sex = " + dto.getSex());
        List<String> agrees = dto.getAgrees();
        for(String agree : agrees) {
            log.info("dto.agree = " + agrees);
        }
    log.info("Login.email = " + dto.getEmail());
    log.info("Login.phone = " + dto.getPhone());
    return "/form-test/fromControlResultView";
    }

    @ModelAttribute("agree")
    private Map<String, String> agree(){
    Map<String, String> map = new HashMap<>();
    map.put("agree","전체 동의합니다.");
    map.put("agree(2)","이용약관 동의");
    map.put("Privacy", "개인정보 수집및이용 동의(필수)");
    map.put("Privacy(2)", "개인정보 수집및이용 동의(선택)");
    return map;
    }
}
