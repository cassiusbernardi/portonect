/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.QLogin;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author 120000499
 */
//public class LoginRepository extends BaseRepository<Login> {
public class LoginRepository {

    private final QLogin login = QLogin.login;

//    public LoginRepository() {
//        super(Login.class);
//    }
    private EntityManager em;
//	

    public LoginRepository() {
        this(null);
    }

    @Inject
    public LoginRepository(EntityManager em) {
        this.em = em;
    }

//    public Login porUsuario(String chave) {
//        Login result;
//        try {
//            JPAQuery<Login> subquery = query().selectFrom(login).where(login.chave.eq(chave));
//            result = subquery.fetchOne();
//        } catch (Exception ex) {
//            result = null;
//        }
//        return result;
//    }
    public Login porUsuario(String chave,Boolean tipoLogin) throws Exception {

        try {
            
            String hql = "FROM Login l "
				+ " WHERE l.chave = :chave ";
		
		if (tipoLogin != null)
			hql = hql.concat("AND l.externo = :tipoLogin");
		
		
		TypedQuery<Login> query = em.createQuery(hql, Login.class);
		
		query.setParameter("tipoLogin", tipoLogin);
                query.setParameter("chave", chave);
//            TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l WHERE l.chave = :chave", Login.class);
            
            return query.getSingleResult();

        } catch (Exception ex) {

            return null;

        }
    }

    public List<Login> todos() throws Exception {

        try {

            TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l", Login.class);
            return query.getResultList();

        } catch (Exception ex) {

            return null;

        }
    }

    public Login salvar(Login login) {
        try {

            if (!em.getTransaction().isActive()) {
                startTransaction();
            }
            em.persist(login);
            commitTransaction();

//        } catch (Exception ex) {
//            entity = null;
//        }
            

        } catch (Exception ex) {

            return null;

        }
        return login;
    }
    
    public void rollbackTransaction() {
        em.getTransaction().rollback();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }

    public void startTransaction() {
        em.getTransaction().begin();
        
    }

}
