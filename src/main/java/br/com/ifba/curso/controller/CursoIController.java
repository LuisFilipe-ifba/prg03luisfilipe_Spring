/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PC
 */
public interface CursoIController {

    public Curso save(Curso save);
    
    public abstract Curso update(Curso upd);

    public abstract void delete(Curso del);

    public abstract List<Curso> listAll();

    public abstract Optional<Curso> findId(Long id);
    
    public abstract Optional<Curso> encontrarCodigo(String codigo);
    
    public abstract Optional<Curso> encontrarNome(String nome);
    
}
