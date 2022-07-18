/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author CRISTIAN
 */
@Service
public class ClienteService implements Operaciones<Cliente> {
   
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public Cliente create(Cliente t) {
        return clienteRepository.save(t);    
    }

    @Override
    public Cliente update(Cliente t) {
        return clienteRepository.save(t);
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente read(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cliente> readAll() {
        return clienteRepository.findAll();
    }
    
}

