package com.example.Personal.Portfolio.Website.controller;


import com.example.Personal.Portfolio.Website.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("email", "prasuntripathi8@gmail.com");
        return "index";
    }

    @PostMapping("/contact/accept")
    public String accept(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("message") String message,
                         RedirectAttributes redirectAttributes) {

        service.sendSimpleEmail(email,name,message);

        return "redirect:/";
    }

    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", service.getAllBlogs());
        return "blogs";
    }

    @GetMapping("read-post/{id}")
    public String readPost(Model model, @PathVariable int id) {
        System.out.println(id);
        model.addAttribute("post", service.getById(id));
        return "BlogReading";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

}
