/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 120000499
 * @param <T>
 */
public abstract class BaseRepository<T> {

    @Inject
    private EntityManager manager;
    private final Class<T> persistentClass;
    private JPAQueryFactory queryFactory;

    protected BaseRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public EntityManager getManager() {
        return manager;
    }

    public List<T> todos() {
        CriteriaQuery<T> criteria = manager.getCriteriaBuilder().createQuery(persistentClass);
        criteria.select(criteria.from(persistentClass));

        List<T> beneficiarios = manager.createQuery(criteria).getResultList();
        return beneficiarios;
    }

    public JPAQueryFactory query() {
        if (queryFactory == null)
            queryFactory = new JPAQueryFactory(manager);
        return queryFactory;
    }

    public T porId(Object id) {
        return manager.find(persistentClass, id);
    }

    public T adiciona(T entity) throws Exception {
//        try {
            
        if (!manager.getTransaction().isActive())
            startTransaction();
        manager.persist(entity);
        commitTransaction();
        
//        } catch (Exception ex) {
//            entity = null;
//        }
        return entity;
    }

    public T atualiza(T entity) {
//        try {
            
            if (!manager.getTransaction().isActive())
                startTransaction();
            manager.merge(entity);
            commitTransaction();
            
//        } catch (Exception ex) {
//            entity = null;
//        }
        
        return entity;
    }

    public void remove(Object id) {
        manager.remove(id);
    }

    public void rollbackTransaction() {
        manager.getTransaction().rollback();
    }

    public void commitTransaction() {
        manager.getTransaction().commit();
    }

    public void startTransaction() {
        manager.getTransaction().begin();
        
    }
}

