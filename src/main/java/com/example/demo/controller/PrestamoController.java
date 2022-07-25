/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Prestamo;
import com.example.demo.service.PrestamoService;
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


@Controller
@RequestMapping("/prestamo")
public class PrestamoController {
   @Autowired
    private PrestamoService prestamoService;
    
    @GetMapping("/all")
    public String listar(Model model){
        model.addAttribute("prestamo", prestamoService.readAll());
        return "prestamo/listar";
    }
    
    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("titulo", "Registrar Prestamo");
        model.addAttribute("prestamo", new Prestamo());
        return "prestamo/form";
    }
    
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Prestamo cl, BindingResult result, Model model, RedirectAttributes attributes){
        prestamoService.create(cl);
        return "redirect:/prestamo/all";
    }
    
    @GetMapping("/del/{id}")
    public String delete(Model model, @PathVariable("id") Integer idcl ){
        prestamoService.delete(idcl);
        return "redirect:/prestamo/all";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer idcl ){
        Prestamo prestamo = prestamoService.read(idcl);
        model.addAttribute("titulo", "Modificar Prestamo");
        model.addAttribute("prestamo", prestamo);
        return "prestamo/form";
    }
    
    @PostMapping("/{id}")
    public String read(Model model, @PathVariable("id") Integer idcl ){
        model.addAttribute("prestamo", prestamoService.read(idcl));
        return "redirect:/prestamo";
    }
    
}

