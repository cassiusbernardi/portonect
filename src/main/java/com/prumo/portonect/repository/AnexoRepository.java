/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.QAnexo;
import com.prumo.portonect.entity.Requisicao;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class AnexoRepository extends BaseRepository<Anexo> {
    
    private QAnexo anexo = QAnexo.anexo;
    
    public AnexoRepository() {
        super(Anexo.class);
    }
    
    public List<Anexo> ativos() {
        
        JPAQuery<Anexo> subquery = query().selectFrom(anexo)
                .where(anexo.ativo.isTrue());

        List<Anexo> result = subquery.fetch();
        
        return result;
        
    }
    
    public Integer getIdAtual() {
        
        Integer result;
        JPAQuery<Integer> subquery = query().select(anexo.idAnexo.max()).from(anexo);

        result = subquery.fetchOne();
        if (result == null)
            result = 0;
        
        return result;
        
    }
    
    public List<Anexo> porRequisicao(Requisicao requisicao) {
        
        JPAQuery<Anexo> subquery = query().selectFrom(anexo)
                .where(anexo.requisicao.idRequisicao.eq(requisicao.getIdRequisicao())
                .and(anexo.ativo.isTrue()));

        List<Anexo> result = subquery.fetch();

        return result;
        
    }
    
}
