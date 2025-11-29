/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author PC
 */
@Entity
public class Curso extends PersistenceEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String codigoCurso;
    private boolean ativo;
    
    //metodos

    public Curso(String nome, String codigoCurso) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
        this.ativo = true;
    }
    
    public Curso(){
        
    }

    @Override
    public Long getId() {
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

    @Override
    public void setId(Long id) {
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
