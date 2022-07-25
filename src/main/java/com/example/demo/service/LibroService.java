/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Libro;
import com.example.demo.repository.LibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LibroService implements Operaciones<Libro> {
   
    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    public Libro create(Libro g) {
        return libroRepository.save(g);    
    }

    @Override
    public Libro update(Libro g) {
        return libroRepository.save(g);
    }

    @Override
    public void delete(int id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro read(int id) {
        return libroRepository.findById(id).get();
    }

    @Override
    public List<Libro> readAll() {
        return libroRepository.findAll();
    }
    
}

