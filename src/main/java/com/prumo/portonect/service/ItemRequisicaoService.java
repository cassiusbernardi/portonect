/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.Requisicao;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface ItemRequisicaoService {
    
    public List<ItemRequisicao> todos() throws Exception;
    public List<ItemRequisicao> ativos() throws Exception;
    public ItemRequisicao porId(Long id) throws Exception;
    public List<ItemRequisicao> porRequisicao(Requisicao requisicao) throws Exception;
    public ItemRequisicao salvar(ItemRequisicao itemRequisicao, Requisicao requisicao) throws Exception;
    public ItemRequisicao remover(ItemRequisicao itemRequisicao) throws Exception;
    
}
