/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CursoIService {
    
    public Curso saveCurso(Curso save);
    
    public abstract Curso updateCurso(Curso upd);

    public abstract void deleteCurso(Curso del);

    public abstract List<Curso> listAllCurso();

    /**
     *
     * @param id
     * @return
     */
    public abstract Curso findIdCurso(Long id);
    
}
