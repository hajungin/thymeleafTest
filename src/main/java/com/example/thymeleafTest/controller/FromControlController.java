package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Email;
import com.example.thymeleafTest.vo.UserDto;
import com.example.thymeleafTest.vo.gender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class FromControlController {
@ModelAttribute("sex")
private gender[] sexes(){
    return gender.values();
}

@ModelAttribute("email")
private Email[] emails(){
    return Email.values();
}
    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("dto",new UserDto());
        modelagrees(model);
        System.out.println();
        return "/form-test/formControlResultView";
    }

    private void modelagrees(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("전체 동의합니다.","전체 동의합니다.");
        map.put("이용약관 동의합니다","이용약관 동의");
        map.put("개인정보 수집및이용 동의(필수)합니다", "개인정보 수집및이용 동의(필수)");
        map.put("개인정보 수집및이용 동의(선택)", "개인정보 수집및이용 동의(선택)");
        model.addAttribute("agrees",map);

    }

    @PostMapping("/signup")
    public String signUpPost(@ModelAttribute("dto") UserDto dto,
                             Model model) {
    //가져온 데이터를 처리하는 곳
    log.info("Login.id = " + dto.getId());
    log.info("Login.password = " + dto.getPassword1());
    log.info("Login.name = " + dto.getName());
    log.info("Login.date = " + dto.getDate());
    log.info("Login.sex = " + dto.getSex());
    log.info("dto.agree = " + dto.isAgrees());
    log.info("Login.email = " + dto.getEmail());
    log.info("Login.phone = " + dto.getPhone());
    //모델에 담아서 전달
    return "/form-test/formControlResultView";
    }

    @ModelAttribute("agree")
    private Map<String, String> agree(){
    Map<String, String> map = new HashMap<>();
    map.put("1","전체 동의합니다.");
    map.put("2","이용약관 동의");
    map.put("3", "개인정보 수집및이용 동의(필수)");
    map.put("4", "개인정보 수집및이용 동의(선택)");
    return map;
    }
}
