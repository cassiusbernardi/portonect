/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.QItemVersao;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class ItemVersaoRepository extends BaseRepository<ItemVersao> {

    private QItemVersao itemVersao = QItemVersao.itemVersao;

    public ItemVersaoRepository() {
        super(ItemVersao.class);
    }

    public int getVersaoAtual(ItemVersao iv) {
        Integer result;
        try {
            JPAQuery<Integer> subquery = query().select(itemVersao.versao.max()).from(itemVersao)
                    .where(itemVersao.itemRequisicao.idItemRequisicao.eq(iv.getItemRequisicao().getIdItemRequisicao())
                            .and(itemVersao.participanteRequisicao.idParticipanteRequisicao.eq(iv.getParticipanteRequisicao().getIdParticipanteRequisicao())));

            result = subquery.fetchOne();
        } catch (Exception ex) {
            result = 0;
        }
        return result;
    }

    public ItemVersao getItemVersaoAtual(ItemVersao iv) {
        ItemVersao result;
        try {
            JPAQuery<ItemVersao> subquery = query().selectFrom(itemVersao)
                    .where(itemVersao.itemRequisicao.idItemRequisicao.eq(iv.getItemRequisicao().getIdItemRequisicao())
                            .and(itemVersao.participanteRequisicao.idParticipanteRequisicao.eq(iv.getParticipanteRequisicao().getIdParticipanteRequisicao()))
                            .and(itemVersao.ativo.isTrue()));

            result = subquery.fetchOne();
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }

    public List<ItemVersao> ativos() {
        List<ItemVersao> result;
        try {
            JPAQuery<ItemVersao> subquery = query().selectFrom(itemVersao)
                    .where(itemVersao.ativo.isTrue());

            result = subquery.fetch();
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }

    public List<ItemVersao> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) {
        List<ItemVersao> result;
        try {
            JPAQuery<ItemVersao> subquery = query().selectFrom(itemVersao)
                    .where(itemVersao.ativo.isTrue()
                            .and(itemVersao.participanteRequisicao.idParticipanteRequisicao.eq(participanteRequisicao.getIdParticipanteRequisicao()))
                            .and(itemVersao.ativo.isTrue()));

            result = subquery.fetch();
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }
    
    public List<ItemVersao> porItemRequisicao(ItemRequisicao itemRequisicao) {
        List<ItemVersao> result;
        try {
            JPAQuery<ItemVersao> subquery = query().selectFrom(itemVersao)
                    .where(itemVersao.ativo.isTrue()
                            .and(itemVersao.itemRequisicao.idItemRequisicao.eq(itemRequisicao.getIdItemRequisicao()))
                            .and(itemVersao.ativo.isTrue()));

            result = subquery.fetch();
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }

}
