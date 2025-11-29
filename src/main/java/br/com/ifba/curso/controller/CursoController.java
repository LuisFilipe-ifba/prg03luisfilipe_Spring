/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author PC
 */
@Controller
public class CursoController implements CursoIController {
    
    private final  CursoIService service;
    
    @Autowired
    public CursoController(CursoService service){
    this.service = service;
    }

    @Override
    public Curso save(Curso save) {
        return this.service.save(save);
    }

    @Override
    public Curso update(Curso upd) {
        return this.service.update(upd);
    }

    @Override
    public void delete(Curso del) {
        this.service.delete(del);
    }

    @Override
    public List<Curso> listAll() {
        return this.service.listAll();
    }

    @Override
    public Optional<Curso> findId(Long id) {
        return this.service.findById(id);
    }

    @Override
    public Optional<Curso> encontrarCodigo(String codigo) {
        return service.findByCodigo(codigo);
    }

    @Override
    public Optional<Curso> encontrarNome(String nome) {
        return service.findByNome(nome);
    }
    
}
