/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.enums.AtivoEnum;
import com.prumo.portonect.repository.ParticipanteRequisicaoRepository;
import com.prumo.portonect.service.ParticipanteRequisicaoService;
import com.prumo.portonect.util.DataFormatUtil;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class ParticipanteRequisicaoServiceImpl implements ParticipanteRequisicaoService {

    @Inject
    private ParticipanteRequisicaoRepository participanteRequisicaoRepository;

    @Override
    public List todos() throws Exception {
        
        return participanteRequisicaoRepository.todos();
        
    }
    
    @Override
    public List ativos() throws Exception {
        
        return participanteRequisicaoRepository.ativos();
        
    }
    
    @Override
    public List<ParticipanteRequisicao> porFornecedor(Fornecedor fornecedor) throws Exception {
        return participanteRequisicaoRepository.porFornecedor(fornecedor);
    }
    
    @Override
    public List<ParticipanteRequisicao> porRequisicao(Requisicao requisicao) throws Exception {
        return participanteRequisicaoRepository.porRequisicao(requisicao);
    }
    
    @Override
    public ParticipanteRequisicao porId(Long id) throws Exception {

        ParticipanteRequisicao participanteRequisicao = participanteRequisicaoRepository.porId(id);
        participanteRequisicao.getRequisicao().setDtAberturaPropostaS(DataFormatUtil.getDataString(participanteRequisicao.getRequisicao().getDtAberturaProposta()));
        participanteRequisicao.getRequisicao().setDtCriacaoRequisicaoS(DataFormatUtil.getDataString(participanteRequisicao.getRequisicao().getDtCriacaoRequisicao()));
        participanteRequisicao.getRequisicao().setDtEncerramentoPropostaS(DataFormatUtil.getDataString(participanteRequisicao.getRequisicao().getDtEncerramentoProposta()));
        
        return participanteRequisicao;
    }

    @Override
    public ParticipanteRequisicao salvar(ParticipanteRequisicao participanteRequisicao) throws Exception {

        return participanteRequisicaoRepository.adiciona(participanteRequisicao);
    }

    @Override
    public ParticipanteRequisicao atualizar(ParticipanteRequisicao participanteRequisicao) throws Exception {
        
        return participanteRequisicaoRepository.atualiza(participanteRequisicao);
    }

    @Override
    public ParticipanteRequisicao remover(ParticipanteRequisicao participanteRequisicao) throws Exception {
        
        participanteRequisicao = porId(participanteRequisicao.getIdParticipanteRequisicao());
        participanteRequisicao.setAtivo(AtivoEnum.INATIVO.getStatus());
        participanteRequisicaoRepository.atualiza(participanteRequisicao);
        
        return participanteRequisicao;
    }

    
}
