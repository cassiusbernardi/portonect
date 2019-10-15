/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.QAnexoParticipante;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.enums.StatusRequisicaoEnum;
import com.prumo.portonect.enums.TipoAnexoParticipanteEnum;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class AnexoParticipanteRepository extends BaseRepository<AnexoParticipante> {
    
    private QAnexoParticipante anexoParticipante = QAnexoParticipante.anexoParticipante;
    
    public AnexoParticipanteRepository() {
        super(AnexoParticipante.class);
    }
    
    public List<AnexoParticipante> ativos() {
        
        JPAQuery<AnexoParticipante> subquery = query().selectFrom(anexoParticipante)
                .where(anexoParticipante.ativo.isTrue());

        List<AnexoParticipante> result = subquery.fetch();
        
        return result;
        
    }
    
    public Integer getIdAtual() {
        
        Integer result;
        JPAQuery<Integer> subquery = query().select(anexoParticipante.idAnexo.max()).from(anexoParticipante);

        result = subquery.fetchOne();
        if (result == null)
            result = 0;
        
        return result;
        
    }
    
    public List<AnexoParticipante> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) {
        
        JPAQuery<AnexoParticipante> subquery = query().selectFrom(anexoParticipante)
                .where(anexoParticipante.participanteRequisicao.idParticipanteRequisicao.eq(participanteRequisicao.getIdParticipanteRequisicao())
                .and(anexoParticipante.ativo.isTrue()));

        List<AnexoParticipante> result = subquery.fetch();

        return result;
        
    }
    
    public List<AnexoParticipante> porResultadoRequisicao(Requisicao requisicao, ParticipanteRequisicao participanteRequisicao) {
        
        JPAQuery<AnexoParticipante> subquery = query().selectFrom(anexoParticipante)
                .where(anexoParticipante.participanteRequisicao.idParticipanteRequisicao.eq(participanteRequisicao.getIdParticipanteRequisicao())
                .and(anexoParticipante.ativo.isTrue()));
        
        if(requisicao.getStatusRequisicao().getIdStatusRequisicao() != StatusRequisicaoEnum.ENCERRADA.getStatusRequisicao()) {
            subquery = subquery.where(anexoParticipante.tipoAnexoParticipante.idTipoAnexo.eq(TipoAnexoParticipanteEnum.PROPOSTA_TECNICA.getTipoAnexo()));
        }
        

        List<AnexoParticipante> result = subquery.fetch();

        return result;
        
    }
    
}
