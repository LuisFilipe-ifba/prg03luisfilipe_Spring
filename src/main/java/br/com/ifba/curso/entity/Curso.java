/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author PC
 */
@Entity
public class Curso{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nome;
    private String codigoCurso;
    private boolean ativo;
    
    //metodos

    public Curso(long id, String nome, String codigoCurso) {
        this.id = id;
        this.nome = nome;
        this.codigoCurso = codigoCurso;
        this.ativo = true;
    }

    
    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
