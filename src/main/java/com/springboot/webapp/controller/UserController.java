package com.springboot.webapp.controller;

import com.springboot.webapp.model.UserModel;
import com.springboot.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<UserModel> user(@PathVariable("id")  Long id) {
        return this.userRepository.findById(id);
    }

    @GetMapping("/list/usuarios")
    public List<UserModel> list() {
        return userRepository.findAll();
    }

    @GetMapping("/list/usuarios/mymethod/{id}")
    public List<UserModel> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findAllMoreThan(id);
    }

    @GetMapping("/list/usuarios/jpamethod/{id}")
    public List<UserModel> listMoreThanByJpa(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/usuarios/{nome}")
    public List<UserModel> listByName(@PathVariable("nome") String nome) {
        return this.userRepository.findByNomeIgnoreCase(nome);
    }

    @PostMapping("/add")
    public UserModel postUser(@RequestBody UserModel user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteID(@PathVariable("id") Long id) {
        this.userRepository.deleteById(id);
    }

}
