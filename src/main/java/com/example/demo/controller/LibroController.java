/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Libro;
import com.example.demo.service.LibroService;
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
@RequestMapping("/libro")
public class LibroController {
   @Autowired
    private LibroService libroService;
    
    @GetMapping("/all2")
    public String listar(Model model){
        model.addAttribute("libro", libroService.readAll());
        return "libro/listarlibro";
    }
    
    @GetMapping("/form2")
    public String create(Model model){
        model.addAttribute("titulo2", "Registrar Libro");
        model.addAttribute("libro", new Libro());
        return "libro/formlibro";
    }
    
    @PostMapping("/add2")
    public String save(@Valid @ModelAttribute Libro z, BindingResult result, Model model, RedirectAttributes attributes){
        libroService.create(z);
        return "redirect:/libro/all2";
    }
    
    @GetMapping("/del2/{id}")
    public String delete(Model model, @PathVariable("id") Integer idz ){
        libroService.delete(idz);
        return "redirect:/libro/all2";
    }
    
    @GetMapping("/edit2/{id}")
    public String edit(Model model, @PathVariable("id") Integer idz ){
        Libro libro = libroService.read(idz);
        model.addAttribute("titulo2", "Modificar Libro");
        model.addAttribute("libro", libro);
        return "libro/formlibro";
    }
    
    @PostMapping("/{id}")
    public String read(Model model, @PathVariable("id") Integer idz ){
        model.addAttribute("libro", libroService.read(idz));
        return "redirect:/libro";
    }
    
}

