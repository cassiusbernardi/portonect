/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.Unidade;
import com.prumo.portonect.enums.AtivoEnum;
import com.prumo.portonect.repository.ItemRequisicaoRepository;
import java.util.List;
import javax.inject.Inject;
import com.prumo.portonect.service.ItemRequisicaoService;
import com.prumo.portonect.service.UnidadeService;

/**
 *
 * @author 120000499
 */
public class ItemRequisicaoServiceImpl implements ItemRequisicaoService {

    @Inject
    private ItemRequisicaoRepository itemRequisicaoRepository;
    @Inject
    private UnidadeService unidadeService;

    @Override
    public List<ItemRequisicao> todos() throws Exception {
        return itemRequisicaoRepository.todos();
    }
    
    @Override
    public List<ItemRequisicao> ativos() throws Exception {
        return itemRequisicaoRepository.ativos();
    }

    @Override
    public ItemRequisicao porId(Long id) throws Exception {
        
        return itemRequisicaoRepository.porId(id);
    }

    @Override
    public List<ItemRequisicao> porRequisicao(Requisicao requisicao) throws Exception {
        return itemRequisicaoRepository.porRequisicao(requisicao);
    }

    @Override
    public ItemRequisicao salvar(ItemRequisicao itemRequisicao, Requisicao requisicao) throws Exception {
        Unidade unidade =  unidadeService.porId(itemRequisicao.getUnidade().getIdUnidade());
        itemRequisicao.setRequisicao(requisicao);
        itemRequisicao.setUnidade(unidade);
        itemRequisicao = itemRequisicaoRepository.adiciona(itemRequisicao);
        return itemRequisicao;       
    }

    @Override
    public ItemRequisicao remover(ItemRequisicao itemRequisicao) throws Exception {
        itemRequisicao = porId(itemRequisicao.getIdItemRequisicao());
        itemRequisicao.setAtivo(AtivoEnum.INATIVO.getStatus());
        itemRequisicaoRepository.atualiza(itemRequisicao);
        return itemRequisicao;
    }
    
    

}
