/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtill;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
@RequiredArgsConstructor
public class CursoService implements CursoIService {
    
    private final CursoRepository cursoRepository;
    
    //Logger da classe
    private static final Logger log = LoggerFactory.getLogger(CursoService.class);
    
    @Override
    public Curso save(Curso save) {
    // Verifica nome ou código vazios
    if (StringUtill.stringIsEmpty(save.getNome()) ||
    StringUtill.stringIsEmpty(save.getCodigoCurso())) {
    throw new RuntimeException("Nome e código não podem estar vazios!");
    }

    // Verifica nome duplicado
    cursoRepository.findByNome(save.getNome()).ifPresent(existing -> {
    throw new RuntimeException("Já existe outro curso com esse nome!");
});

    // Verifica código duplicado
    cursoRepository.findByCodigoCurso(save.getCodigoCurso()).ifPresent(existing -> {
        if (!existing.getId().equals(save.getId())) {
            throw new RuntimeException("Já existe outro curso com esse código!");
        }
    });

    // Salva no logger as mudanças
    log.info("Foi Salvo o Objeto Curso");
    return cursoRepository.save(save);
}

    @Override
    public Curso update(Curso upd) {
        //Verifica se nome ou codigo estão vazios
        if (StringUtill.stringIsEmpty(upd.getNome()) ||
        StringUtill.stringIsEmpty(upd.getCodigoCurso())) {
        throw new RuntimeException("Nome e código não podem estar vazios!");
        }
        
        //verifica se Curso existe
       
        cursoRepository.findById(upd.getId())
            .orElseThrow(() -> new RuntimeException("Curso não encontrado para atualização"));
        
        // Verifica nome duplicado
        cursoRepository.findByNome(upd.getNome()).ifPresent(existing -> {
        if (!existing.getId().equals(upd.getId())) {
            throw new RuntimeException("Já existe outro curso com esse nome!");
        }
        });
        // Verifica código duplicado
        cursoRepository.findByCodigoCurso(upd.getCodigoCurso()).ifPresent(existing -> {
        if (!existing.getId().equals(upd.getId())) {
            throw new RuntimeException("Já existe outro curso com esse código!");
        }
        });
        
        // Salva no logger as mudanças
        log.info("Foi atualizado um objeto do curso");
        return cursoRepository.save(upd);
    }

    //operações mais basicas abaixo sem muitas adições
    @Override
    public void delete(Curso del) {
        if (!cursoRepository.findById(del.getId()).isPresent()) {
        throw new RuntimeException("Curso não encontrado para exclusão");
        }
        
        // Salva no logger as mudanças
        log.info("um objeto do curso foi deletado");
        cursoRepository.deleteById(del.getId());
    }

    /**
     *
     * @return
     */
    @Override
    public List<Curso> listAll() {
        return cursoRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Optional<Curso> findByCodigo(String codigo) {
        if(StringUtill.stringIsEmpty(codigo)){
            throw new RuntimeException("Codigo invalido");
        }
        return cursoRepository.findByCodigoCurso(codigo);
    }

    @Override
    public Optional<Curso> findByNome(String nome) {
        if(StringUtill.stringIsEmpty(nome)){
            throw new RuntimeException("Nome invalido");
        }
        return cursoRepository.findByNome(nome);
    }
}

