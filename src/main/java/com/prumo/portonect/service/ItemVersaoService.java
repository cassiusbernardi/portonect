/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface ItemVersaoService {
    
    public List<ItemVersao> todos() throws Exception;
    public List<ItemVersao> ativos() throws Exception;
    public ItemVersao porId(Integer id)  throws Exception;
    public List<ItemVersao> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) throws Exception;
    public List<ItemVersao> porItemRequisicao(ItemRequisicao itemRequisicao) throws Exception;
    public ItemVersao salvar(ItemVersao itemVersao) throws Exception;
    public ItemVersao atualizar(ItemVersao requisicao) throws Exception; 
    public ItemVersao remover(ItemVersao itemVersao) throws Exception;
    
}
