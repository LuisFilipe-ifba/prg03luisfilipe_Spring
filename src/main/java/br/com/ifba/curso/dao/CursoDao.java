/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao{
    
    /**
     *
     * @param codigo
     * @return
     */
    @Override
    public Curso encontrarCodigo(String codigo) {
         try {
        String jpql = "SELECT c FROM Curso c WHERE c.codigoCurso = :codigo";

            Curso curso = entityManager.createQuery(jpql, Curso.class)
                    .setParameter("codigo", codigo) // Define o valor do parâmetro :codigo
                    .getSingleResult(); // Espera UM resultado
            return curso;
    } catch (NoResultException e) {
        // Se o curso não for encontrado, retorna null.
        return null;
    }
    }
    
    /**
     *
     * @param nome
     * @return
     */
    @Override
    public Curso encontrarNome(String nome) {
         try {
        String jpql = "SELECT c FROM Curso c WHERE c.nome = :nome";

            Curso curso = entityManager.createQuery(jpql, Curso.class)
                    .setParameter("nome", nome) // Define o valor do parâmetro :codigo
                    .getSingleResult(); // Espera UM resultado
            return curso;
    } catch (NoResultException e) {
        // Se o curso não for encontrado, retorna null.
        return null;
    }
    }
}