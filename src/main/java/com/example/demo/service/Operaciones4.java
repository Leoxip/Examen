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
public interface Operaciones4<L> {
    L create(L l);
    L update(L l);
    void delete(int id);
    L read(int id);
    List<L> readAll();
    
}