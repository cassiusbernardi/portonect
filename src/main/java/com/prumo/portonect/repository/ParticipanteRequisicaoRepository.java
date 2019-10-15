/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.QParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class ParticipanteRequisicaoRepository extends BaseRepository<ParticipanteRequisicao> {

    private QParticipanteRequisicao participanteRequisicao = QParticipanteRequisicao.participanteRequisicao;

    public ParticipanteRequisicaoRepository() {
        super(ParticipanteRequisicao.class);
    }
    
    public List<ParticipanteRequisicao> ativos() {

        JPAQuery<ParticipanteRequisicao> subquery = query().selectFrom(participanteRequisicao)
                .where(participanteRequisicao.ativo.isTrue());

        List<ParticipanteRequisicao> result = subquery.fetch();

        return result;

    }

    public List<ParticipanteRequisicao> porRequisicao(Requisicao requisicao) {

        JPAQuery<ParticipanteRequisicao> subquery = query().selectFrom(participanteRequisicao)
                .where(participanteRequisicao.requisicao.idRequisicao.eq(requisicao.getIdRequisicao())
                .and(participanteRequisicao.ativo.isTrue()));

        List<ParticipanteRequisicao> result = subquery.fetch();

        return result;

    }
    
    public List<ParticipanteRequisicao> porFornecedor(Fornecedor fornecedor) {

        JPAQuery<ParticipanteRequisicao> subquery = query().selectFrom(participanteRequisicao)
                .where(participanteRequisicao.fornecedor.idFornecedor.eq(fornecedor.getIdFornecedor())
                .and(participanteRequisicao.ativo.isTrue()));

        List<ParticipanteRequisicao> result = subquery.fetch();

        return result;

    }

}
