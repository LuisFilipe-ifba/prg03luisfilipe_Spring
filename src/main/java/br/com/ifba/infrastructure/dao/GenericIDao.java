/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author PC
 * @param <Entity>
 */
public interface GenericIDao<Entity extends PersistenceEntity>{
    
    /**
     *
     * @param save
     * @return
     */
    public Entity save(Entity save);
    
    public abstract Entity update(Entity upd);

    public abstract void delete(Entity del);

    public abstract List<Entity> listAll();

    public abstract Entity findId(Long id);
        
   
    
}
