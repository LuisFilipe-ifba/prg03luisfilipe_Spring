/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtill;
import java.util.List;

/**
 *
 * @author PC
 */
public class CursoService implements CursoIService {
    
    private final CursoIDao cursoDao;
    
    public CursoService(CursoIDao cursoDao){// metodo construtor da classe
        this.cursoDao = cursoDao;
    };
    
    @Override
    public Curso saveCurso(Curso save) {
        //verifica se nomeou codigo esta vazio 
        if(!StringUtill.stringVazia(save.getNome()) && !StringUtill.stringVazia(save.getCodigoCurso())){
            
            //Verifica se ja existe um nome igual
            Curso cursoExistente = cursoDao.encontrarNome(save.getNome());
            if (cursoExistente != null && cursoExistente.getId() != save.getId()) {
                throw new RuntimeException("Já existe outro curso com esse nome!");
            }
            //Verifica se ja existe um codigo igual
            cursoExistente = cursoDao.encontrarCodigo(save.getCodigoCurso());
            if (cursoExistente != null && cursoExistente.getId() != save.getId()) {
                throw new RuntimeException("Já existe outro curso com esse codigo!");
            }
            
            return cursoDao.save(save);
        }else{
            throw new RuntimeException("Nome ou Codigo invalido");
        }
    }

    @Override
    public Curso updateCurso(Curso upd) {
        //Verifica se nome ou codigo estão vazios
        if (StringUtill.stringVazia(upd.getNome()) || StringUtill.stringVazia(upd.getCodigoCurso())) {
            throw new RuntimeException("Nome e código não podem estar vazios!");
        }
        
        //verifica se Curso existe
        Curso cursoExistente = cursoDao.findId(upd.getId());
        if(cursoExistente == null){
            throw new RuntimeException("Curso não encontrado para atualização");
        }
        
        //Verifica se ja existe um nome igual
        cursoExistente = cursoDao.encontrarNome(upd.getNome());
            if (cursoExistente != null && cursoExistente.getId() != upd.getId()) {
                throw new RuntimeException("Já existe outro curso com esse nome!");
            }
        //Verifica se ja existe um codigo igual
        cursoExistente = cursoDao.encontrarCodigo(upd.getCodigoCurso());
            if (cursoExistente != null && cursoExistente.getId() != upd.getId()) {
                throw new RuntimeException("Já existe outro curso com esse codigo!");
            }
        return cursoDao.update(upd);
    }

    //operações mais basicas abaixo sem muitas adições
    @Override
    public void deleteCurso(Curso del) {
        cursoDao.delete(del);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Curso> listAllCurso() {
        return cursoDao.listAll();
    }

    @Override
    public Curso findIdCurso(Long id) {
        return cursoDao.findId(id);
    }

    @Override
    public Curso encontrarCodigo(String codigo) {
        if(!StringUtill.stringVazia(codigo)){
            throw new RuntimeException("Codigo invalido");
        }
        return cursoDao.encontrarCodigo(codigo);
    }

    @Override
    public Curso encontrarNome(String nome) {
        if(!StringUtill.stringVazia(nome)){
            throw new RuntimeException("Nome invalido");
        }
        return cursoDao.encontrarNome(nome);    }
    
}
