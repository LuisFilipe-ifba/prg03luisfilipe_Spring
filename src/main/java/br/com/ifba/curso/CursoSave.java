/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso;

import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.view.CursoListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author PC
 */
@Component
public class CursoSave{
    
    @Autowired
    private CursoIController controller;
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
        new CursoListar().setVisible(true);
    });
    }
}
