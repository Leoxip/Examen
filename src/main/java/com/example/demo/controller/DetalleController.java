/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Detalle;
import com.example.demo.service.DetalleService;
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
@RequestMapping("/detalle")
public class DetalleController {
   @Autowired
    private DetalleService detalleService;
    
    @GetMapping("/all4")
    public String listar(Model model){
        model.addAttribute("detalle", detalleService.readAll());
        return "detalle/listardetalle";
    }
    
    @GetMapping("/form4")
    public String create(Model model){
        model.addAttribute("titulo4", "Registrar Detalle");
        model.addAttribute("detalle", new Detalle());
        return "detalle/formdetalle";
    }
    
    @PostMapping("/add4")
    public String save(@Valid @ModelAttribute Detalle z, BindingResult result, Model model, RedirectAttributes attributes){
        detalleService.create(z);
        return "redirect:/detalle/all4";
    }
    
    @GetMapping("/del4/{id}")
    public String delete(Model model, @PathVariable("id") Integer idz ){
        detalleService.delete(idz);
        return "redirect:/detalle/all4";
    }
    
    @GetMapping("/edit4/{id}")
    public String edit(Model model, @PathVariable("id") Integer idz ){
        Detalle detalle = detalleService.read(idz);
        model.addAttribute("titulo4", "Modificar Detalle");
        model.addAttribute("detalle", detalle);
        return "detalle/formdetalle";
    }
    
    @PostMapping("/{id}")
    public String read(Model model, @PathVariable("id") Integer idz ){
        model.addAttribute("detalle", detalleService.read(idz));
        return "redirect:/detalle";
    }
    
}

