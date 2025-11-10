/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso;

import br.com.ifba.curso.entity.Curso;
import javax.persistence.EntityManager; // Import needed
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class CursoSave {

    //abaixo Cria o EntityManeger
    private static final EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("gerenciamento_curso");

    public void cursoSalvar(Curso curso) {
        //declara o entityManeger
        EntityManager entityManager = null;

        try {
            
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(curso);
            
            entityManager.getTransaction().commit();
            
            System.out.println("Curso salvo com sucesso!");

        } catch (Exception e) {
            //Exeção caso ocora um erro
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.err.println("Erro ao salvar o curso: " + e.getMessage());

        } finally {
            //Termina fechando o curso
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
