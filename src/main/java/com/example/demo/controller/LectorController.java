/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Lector;
import com.example.demo.service.LectorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author CRISTIAN
 */
@Controller
@RequestMapping("/lector")
public class LectorController {
   @Autowired
    private LectorService lectorService;
    
    @GetMapping("/all3")
    public String listar(Model model){
        model.addAttribute("lector", lectorService.readAll());
        return "lector/listarlector";
    }
    
    @GetMapping("/form3")
    public String create(Model model){
        model.addAttribute("titulo3", "Registrar Lector");
        model.addAttribute("lector", new Lector());
        return "lector/formlector";
    }
    
    @PostMapping("/add3")
    public String save(@Valid @ModelAttribute Lector z, BindingResult result, Model model, RedirectAttributes attributes){
        lectorService.create(z);
        return "redirect:/lector/all3";
    }
    
    @GetMapping("/del3/{id}")
    public String delete(Model model, @PathVariable("id") Integer idz ){
        lectorService.delete(idz);
        return "redirect:/lector/all3";
    }
    
    @GetMapping("/edit3/{id}")
    public String edit(Model model, @PathVariable("id") Integer idz ){
        Lector lector = lectorService.read(idz);
        model.addAttribute("titulo3", "Modificar Lector");
        model.addAttribute("lector", lector);
        return "lector/formlector";
    }
    
    @PostMapping("/{id}")
    public String read(Model model, @PathVariable("id") Integer idz ){
        model.addAttribute("lector", lectorService.read(idz));
        return "redirect:/lector";
    }
    
}

