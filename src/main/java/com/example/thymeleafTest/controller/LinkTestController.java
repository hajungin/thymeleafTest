package com.example.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkTestController {
    @GetMapping("/main")
    public String main(){
        return "articles/main";
    }
    @GetMapping("/member")
    public String list_all(){
        return "articles/list_all";
    }
    @GetMapping("/articles/{id}")
    public String list_one(@PathVariable("id") int id,
                           @RequestParam("name") String name){
        String title = "/articles/member/{" + id + "}";
        return "articles/member-list";
    }

    @GetMapping("/articles/create")
    public String news(@RequestParam("name") String name,
                       @RequestParam("weight") int weight,
                       @RequestParam("height") int height,
                       Model model){
        model.addAttribute("name","톰");
        model.addAttribute("weight",80);
        model.addAttribute("height",180);
        return "/articles/new";
    }

    @GetMapping("/articles/update")
    public String update_ok(){
        return "articles/update_ok";
    }

    @GetMapping("/articles/{id}/update")
    public String update(@PathVariable("id") int id) {
        return "/articles/update";
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id") int id){
        return "/articles/delete_ok";
    }

    @GetMapping("/articles/{id}/articleComment")
    public String com(@PathVariable("id") int id) {
        return "/articles/comment_view";
    }

    @GetMapping("/articles/{id}/articleComments/{article}/delete")
    public String delete_ok(@PathVariable("id") int id,
                            @PathVariable("article") int article) {
        return "/articles/delete";
    }
}

