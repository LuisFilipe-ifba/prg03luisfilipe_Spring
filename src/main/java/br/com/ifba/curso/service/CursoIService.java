/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PC
 */
public interface CursoIService {
    
    public Curso save(Curso save);
    
    public abstract Curso update(Curso upd);

    public abstract void delete(Curso del);

    public abstract List<Curso> listAll();

    public abstract Optional<Curso> findById(Long id);
    
    public Optional<Curso> findByNome(String nome);
    
    public Optional<Curso> findByCodigo(String codigo);
            
}
