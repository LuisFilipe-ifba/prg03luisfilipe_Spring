/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import jakarta.persistence.EntityManager;

/**
 *
 * @author PC
 * @param <Entity>
 */
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity>{
    
    // 1. Campo para o EntityManager
    protected static EntityManager entityManager;
//    protected static EntityManagerFactory entityManagerFactory;

    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamento_curso");
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public Entity save(Entity save) {
        entityManager.getTransaction().begin();
        entityManager.persist(save);
        entityManager.getTransaction().commit();
        
        return save;
    }

    @Override
    public Entity update(Entity upd) {
        entityManager.getTransaction().begin();
        entityManager.merge(upd);
        entityManager.getTransaction().commit();
        return upd;
    }

    @Override
    public void delete(Entity del) {
        del = findId(del.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(del);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Entity> listAll() {
        return entityManager.createQuery(("from " + getTypeClass().getName())).getResultList();

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Entity findId(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);

    }
    
    protected Class <?> getTypeClass(){
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
