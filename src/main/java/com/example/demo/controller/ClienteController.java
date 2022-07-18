/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;
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
@RequestMapping("/prod")
public class ClienteController {
     @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/all")
    public String listarCl(Model model){
        //String keyword = "Yogurt";
        model.addAttribute("cliente", clienteService.readAll());
        return "prod/listarCl";
    }
    
    @GetMapping("/form")
    public String createCl(Model model){
        model.addAttribute("titulo", "Registrar Cliente");
        model.addAttribute("cliente", new Cliente());
        return "prod/formCl";
    }
    
    @PostMapping("/add")
    public String saveCl(@Valid @ModelAttribute Cliente cl, BindingResult result, Model model, RedirectAttributes attributes){
        clienteService.create(cl);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/prod/all";
    }
    
    @GetMapping("/del/{id}")
    public String deleteCl(Model model, @PathVariable("id") Integer idcl ){
        clienteService.delete(idcl);
        return "redirect:/prod/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editCl(Model model, @PathVariable("id") Integer idcl ){
        Cliente cliente = clienteService.read(idcl);
        model.addAttribute("titulo", "Modificar Cliente");
        model.addAttribute("cliente", cliente);
        return "prod/formCl";
    }
    
    @PostMapping("/{id}")
    public String readCl(Model model, @PathVariable("id") Integer idcl ){
        model.addAttribute("prod", clienteService.read(idcl));
        return "redirect:/prod";
    }
    
}

