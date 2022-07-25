/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import java.util.List;

/**
 *
 * 
 * @param <T>
 */
public interface Operaciones3<H> {
    H create(H h);
    H update(H h);
    void delete(int id);
    H read(int id);
    List<H> readAll();
    
}