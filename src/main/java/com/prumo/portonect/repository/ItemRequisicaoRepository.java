/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.QItemRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class ItemRequisicaoRepository extends BaseRepository<ItemRequisicao> {
    
    private QItemRequisicao itemRequisicao = QItemRequisicao.itemRequisicao;
    
    public ItemRequisicaoRepository() {
        super(ItemRequisicao.class);
    }
    
    public List<ItemRequisicao> ativos() {
        
        JPAQuery<ItemRequisicao> subquery = query().selectFrom(itemRequisicao)
                .where(itemRequisicao.ativo.isTrue());

        List<ItemRequisicao> result = subquery.fetch();

        return result;
        
    }
    
    public List<ItemRequisicao> porRequisicao(Requisicao requisicao) {
        
        JPAQuery<ItemRequisicao> subquery = query().selectFrom(itemRequisicao)
                .where(itemRequisicao.requisicao.idRequisicao.eq(requisicao.getIdRequisicao())
                .and(itemRequisicao.ativo.isTrue()));

        List<ItemRequisicao> result = subquery.fetch();

        return result;
        
    }
    
}
