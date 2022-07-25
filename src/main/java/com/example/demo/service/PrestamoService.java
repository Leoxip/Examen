/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Prestamo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PrestamoRepository;



@Service
public class PrestamoService implements Operaciones<Prestamo> {
   
    @Autowired
    private PrestamoRepository prestamoRepository;
    
    @Override
    public Prestamo create(Prestamo t) {
        return prestamoRepository.save(t);    
    }

    @Override
    public Prestamo update(Prestamo t) {
        return prestamoRepository.save(t);
    }

    @Override
    public void delete(int id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public Prestamo read(int id) {
        return prestamoRepository.findById(id).get();
    }

    @Override
    public List<Prestamo> readAll() {
        return prestamoRepository.findAll();
    }
    
}

