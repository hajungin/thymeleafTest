package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Member;
import com.example.thymeleafTest.vo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;


@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data","Hello <b>Spring!</b>");
        return "/basic/text-basic";
    }

    @GetMapping("/variable")
    public String variable(Model model){
        Users usersA = new Users("장원영" , 21);
        Users usersB = new Users("안유진", 22);
        List<Users> list =
                new ArrayList<>(Arrays.asList(usersA,usersB));
        Map<String, Users> map = new HashMap<>();
        map.put("jang",usersA);
        map.put("ahn",usersB);

        model.addAttribute("userJang", usersA);
        model.addAttribute("userList", list);
        model.addAttribute("userMap", map);
        return "/basic/variable";
    }

    @GetMapping("/date")
    public String date(Model model){
        model.addAttribute("localTime", LocalDateTime.now());
        return "/date";
    }

    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data","Spring !!!");
        return "literal";
    }

    @GetMapping("/each")
    public String each(Model model){
        addUsers(model);
        return "each";
    }

    private void addUsers(Model model) {
        List<Users> userslist = new ArrayList<>(
                Arrays.asList(
                        new Users("안유진", 22),
                        new Users("장원영", 21),
                        new Users("이서", 18),
                        new Users("가을", 23),
                        new Users("리즈", 21),
                        new Users("레이", 21)
                )
        );
        model.addAttribute("users",userslist);

        for(Users item : userslist){

        }
    }
    @GetMapping("/member")
    public String member(Model model){
        quiz2(model);
        model.addAttribute("localTime", LocalDateTime.now());
        return "member";
    }

    private void quiz2(Model model) {
        List<Member> memberlist = new ArrayList<>(
                Arrays.asList(
                        new Member(1,"Name_01","addr_01"),
                        new Member(2,"Name_02","addr_02"),
                        new Member(3,"Name_03","addr_03"),
                        new Member(4,"Name_04","addr_04"),
                        new Member(5,"Name_05","addr_05"),
                        new Member(6,"Name_06","addr_06"),
                        new Member(7,"Name_07","addr_07"),
                        new Member(8,"Name_08","addr_08"),
                        new Member(9,"Name_09","addr_09"),
                        new Member(10,"Name_10","addr_10"),
                        new Member(11,"Name_11","addr_11"),
                        new Member(12,"Name_12","addr_12"),
                        new Member(13,"Name_13","addr_13"),
                        new Member(14,"Name_14","addr_14"),
                        new Member(15,"Name_15","addr_15")
                )
        );
        model.addAttribute("member",memberlist);
        for(Member item : memberlist){

        }

    }
}
