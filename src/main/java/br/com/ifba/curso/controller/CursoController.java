/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author PC
 */
@Controller
public class CursoController implements CursoIController {
    
    @Autowired
    private final CursoIService service;
    
    public CursoController(){
        this.service = new CursoService(new CursoDao());
    }
    
    public CursoController(CursoService service){
        this.service = service;
        
    }

    @Override
    public Curso save(Curso save) {
        return this.service.saveCurso(save);
    }

    @Override
    public Curso update(Curso upd) {
        return this.service.updateCurso(upd);
    }

    @Override
    public void delete(Curso del) {
        this.service.deleteCurso(del);
    }

    @Override
    public List<Curso> listAll() {
        return this.service.listAllCurso();
    }

    @Override
    public Curso findId(Long id) {
        return this.service.findIdCurso(id);
    }

    @Override
    public Curso encontrarCodigo(String codigo) {
        return service.encontrarCodigo(codigo);
    }

    @Override
    public Curso encontrarNome(String nome) {
        return service.encontrarNome(nome);
    }
    
}
