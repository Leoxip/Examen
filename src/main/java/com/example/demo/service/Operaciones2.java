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
public interface Operaciones2<G> {
    G create(G g);
    G update(G g);
    void delete(int id);
    G read(int id);
    List<G> readAll();
    
}