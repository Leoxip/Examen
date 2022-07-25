/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Detalle;
import com.example.demo.repository.DetalleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class DetalleService implements Operaciones<Detalle> {
   
    @Autowired
    private DetalleRepository detalleRepository;
    
    @Override
    public Detalle create(Detalle l) {
        return detalleRepository.save(l);    
    }

    @Override
    public Detalle update(Detalle l) {
        return detalleRepository.save(l);
    }

    @Override
    public void delete(int id) {
        detalleRepository.deleteById(id);
    }

    @Override
    public Detalle read(int id) {
        return detalleRepository.findById(id).get();
    }

    @Override
    public List<Detalle> readAll() {
        return detalleRepository.findAll();
    }
    
}

