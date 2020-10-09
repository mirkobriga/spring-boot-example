package com.project.example.controllers;

import java.util.Optional;

import com.project.example.models.Book;
import com.project.example.models.User;
import com.project.example.repos.BookRepository;
import com.project.example.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> getAllUsers() {
        Optional<User> user = this.userRepository.findById(1);
        if (user.isPresent()) {
            return this.bookRepository.findByUser(user.get());
        } else {
            return null;
        }
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return this.userRepository.findById(id);
    }

}
