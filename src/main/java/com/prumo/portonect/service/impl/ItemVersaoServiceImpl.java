/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.repository.ItemVersaoRepository;
import com.prumo.portonect.service.ItemVersaoService;
import com.prumo.portonect.util.DadosFormatUtil;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class ItemVersaoServiceImpl implements ItemVersaoService {

    @Inject
    private ItemVersaoRepository itemVersaoRepository;

    @Override
    public List<ItemVersao> todos() throws Exception {
        return itemVersaoRepository.todos();
    }

    @Override
    public List<ItemVersao> ativos() throws Exception {
        return itemVersaoRepository.ativos();
    }

    @Override
    public ItemVersao porId(Integer id) throws Exception {
        return itemVersaoRepository.porId(id);
    }

    @Override
    public List<ItemVersao> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) throws Exception {
        return itemVersaoRepository.porParticipanteRequisicao(participanteRequisicao);
    }

    @Override
    public List<ItemVersao> porItemRequisicao(ItemRequisicao itemRequisicao) throws Exception {
        List<ItemVersao> itensVersao = itemVersaoRepository.porItemRequisicao(itemRequisicao);

        return melhorProposta(itensVersao);
    }

    @Override
    public ItemVersao salvar(ItemVersao itemVersao) throws Exception {
        return itemVersaoRepository.adiciona(itemVersao);
    }

    @Override
    public ItemVersao atualizar(ItemVersao itemVersao) throws Exception {
        ItemVersao iv = porId(itemVersao.getIdItemVersao());

        if (iv.getVersao() == 1 && iv.getValor() == null) {
            iv.setValor(itemVersao.getValor());
//            int versaoAtual = iv.getItemVersaoPK().getVersao() + 1;
//            iv.getItemVersaoPK().setVersao(versaoAtual);
            iv = itemVersaoRepository.atualiza(iv);
            itemVersao = iv;
        } else {

            int versaoAtual = iv.getVersao() + 1;
            iv.setAtivo(false);
            iv = itemVersaoRepository.atualiza(iv);

            ItemVersao novaVersao = new ItemVersao();
            novaVersao.setItemRequisicao(iv.getItemRequisicao());
            novaVersao.setParticipanteRequisicao(iv.getParticipanteRequisicao());
            novaVersao.setVersao(versaoAtual);
            novaVersao.setValor(itemVersao.getValor());

            itemVersao = itemVersaoRepository.adiciona(novaVersao);
        }

        return itemVersao;
    }

    @Override
    public ItemVersao remover(ItemVersao itemVersao) throws Exception {
        itemVersaoRepository.remove(itemVersao);
        return itemVersao;
    }

    private List<ItemVersao> melhorProposta(List<ItemVersao> itensVersao) {
        int posicaoMenorValor = 0;
        double menorValor = 10000000000000.0;
        for (int i = 0; i < itensVersao.size(); i++) {
            if (itensVersao.get(i).getValor() != null) {

                itensVersao.get(i).setValorS(DadosFormatUtil.getDecimalString(itensVersao.get(i).getValor()));
//            itensVersao.get(i).setVencedor(false);
                if (itensVersao.get(i).getValor() < menorValor) {
                    menorValor = itensVersao.get(i).getValor();
                    itensVersao.get(i).setVencedor(true);
                    if (i != 0) {
                        itensVersao.get(posicaoMenorValor).setVencedor(false);
                    }
                    posicaoMenorValor = i;
                }

            }
        }

        return itensVersao;
    }
}
