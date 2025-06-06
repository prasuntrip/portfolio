package com.example.Personal.Portfolio.Website.controller;

import com.example.Personal.Portfolio.Website.Model.Blogs;
import com.example.Personal.Portfolio.Website.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminController {
    @Autowired
    private Service services;


    @GetMapping("/admin")
    public String adminLoginForm(Model model) {
        model.addAttribute("allBlogs", services.getAllBlogs());
        return "admin"; // renders admin.html
    }

    @PostMapping("/admin-login")
    public String handleLogin(@RequestParam String adminId,
                              @RequestParam String password,
                              Model model) {
        model.addAttribute("allBlogs", services.getAllBlogs());
        String username = System.getenv("username");
        String passcode = System.getenv("passcode");
        if (adminId.equals(username) && password.equals(passcode)) {
            // redirect to dashboard or CMS if credentials are correct
            return "dashboard";
        } else {
            // send error message back to login page
            model.addAttribute("error", "Invalid credentials");
            return "admin";
        }
    }


    @PostMapping("/add-blog")
    public String addBlog(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String content,
            @RequestParam String author,
            @RequestParam String imageUrl,
            Model model) {

        Blogs blog = new Blogs();
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setImageURL(imageUrl);

        services.save(blog);

        model.addAttribute("message", "Blog added successfully!");

        return "redirect:/admin"; // or use "redirect:/admin" to go to blog listing page
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        services.deleteBlog(id);
        return "redirect:/admin"; // redirect back to admin page after deletion
    }

}
