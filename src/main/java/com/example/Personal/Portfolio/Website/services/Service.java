package com.example.Personal.Portfolio.Website.services;

import com.example.Personal.Portfolio.Website.Model.Blogs;
import com.example.Personal.Portfolio.Website.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final JavaMailSender mailSender;

    public Service(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("We received the feedback from you "+subject+"! Thank you for your feedback, we will work forward to work accordingly!");
        msg.setText(body);
        mailSender.send(msg);
    }

    @Autowired
    private repository repository;


    public void deleteBlog(int id){
        Blogs model = repository.findById(id).orElse(null);
        if (model != null) {
            repository.delete(model);
        }
    }


    public List<Blogs> getAllBlogs(){
        return repository.findAll();
    }



    public void save(Blogs model){
        repository.save(model);
    }

    public Blogs getById(int id){
        return repository.findById(id).orElse(null);
    }

}
