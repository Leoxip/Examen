/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Pedido;
import com.example.demo.service.PedidoService;
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
@RequestMapping("/pedi")
public class PedidoController {
   @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/all")
    public String listar(Model model){
        model.addAttribute("pedido", pedidoService.readAll());
        return "pedi/listar";
    }
    
    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("titulo", "Registrar Pedido");
        model.addAttribute("pedido", new Pedido());
        return "pedi/form";
    }
    
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Pedido cl, BindingResult result, Model model, RedirectAttributes attributes){
        pedidoService.create(cl);
        return "redirect:/pedi/all";
    }
    
    @GetMapping("/del/{id}")
    public String delete(Model model, @PathVariable("id") Integer idcl ){
        pedidoService.delete(idcl);
        return "redirect:/pedi/all";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer idcl ){
        Pedido pedido = pedidoService.read(idcl);
        model.addAttribute("titulo", "Modificar Pedido");
        model.addAttribute("pedido", pedido);
        return "pedi/form";
    }
    
    @PostMapping("/{id}")
    public String readCl(Model model, @PathVariable("id") Integer idcl ){
        model.addAttribute("pedi", pedidoService.read(idcl));
        return "redirect:/prod";
    }
    
}

