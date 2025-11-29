/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author PC
 */
public class StringUtill {
    
    //retorna "TRUE" se a string não estiver vazia

    /**
     *
     * @param linha
     * @return
     */
    
    public static boolean stringIsEmpty(String linha){
        return linha == null || linha.trim().isEmpty();
    }
    
}
