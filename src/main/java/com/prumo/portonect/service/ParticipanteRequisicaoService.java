/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface ParticipanteRequisicaoService {
    
    public List<ParticipanteRequisicao> todos() throws Exception;
    public List<ParticipanteRequisicao> ativos() throws Exception;
    public ParticipanteRequisicao porId(Long id) throws Exception;
    public List<ParticipanteRequisicao> porFornecedor(Fornecedor fornecedor) throws Exception;
    public List<ParticipanteRequisicao> porRequisicao(Requisicao requisicao) throws Exception;
    public ParticipanteRequisicao salvar(ParticipanteRequisicao participanteRequisicao) throws Exception;
    public ParticipanteRequisicao atualizar(ParticipanteRequisicao participanteRequisicao) throws Exception; 
    public ParticipanteRequisicao remover(ParticipanteRequisicao participanteRequisicao) throws Exception; 
}
