/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Lector;
import com.example.demo.repository.LectorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author CRISTIAN
 */
@Service
public class LectorService implements Operaciones<Lector> {
   
    @Autowired
    private LectorRepository lectorRepository;
    
    @Override
    public Lector create(Lector h) {
        return lectorRepository.save(h);    
    }

    @Override
    public Lector update(Lector h) {
        return lectorRepository.save(h);
    }

    @Override
    public void delete(int id) {
        lectorRepository.deleteById(id);
    }

    @Override
    public Lector read(int id) {
        return lectorRepository.findById(id).get();
    }

    @Override
    public List<Lector> readAll() {
        return lectorRepository.findAll();
    }
    
}

