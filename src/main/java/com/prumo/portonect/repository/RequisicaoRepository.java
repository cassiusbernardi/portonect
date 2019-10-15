/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.QRequisicao;
import com.prumo.portonect.enums.StatusRequisicaoEnum;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class RequisicaoRepository extends BaseRepository<Requisicao> {
    
    private QRequisicao requisicao = QRequisicao.requisicao;
    
    public RequisicaoRepository() {
        super(Requisicao.class);
    }
    
    public List<Requisicao> aSerEncerradas(Date data) {
        List<Requisicao> result;
        try {
            JPAQuery<Requisicao> subquery = query().selectFrom(requisicao)
                    .where(requisicao.statusRequisicao.idStatusRequisicao.eq(StatusRequisicaoEnum.AGUARDANDO_COTACAO.getStatusRequisicao())
                    .and(requisicao.dtEncerramentoProposta.loe(data)));

            result = subquery.fetch();
            
        } catch (Exception e) {
            result = new ArrayList();
        }

        return result;
    }
    
}
