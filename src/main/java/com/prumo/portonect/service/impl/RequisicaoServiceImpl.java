/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.StatusRequisicao;
import com.prumo.portonect.enums.StatusRequisicaoEnum;
import com.prumo.portonect.repository.RequisicaoRepository;
import com.prumo.portonect.service.RequisicaoService;
import com.prumo.portonect.util.DataFormatUtil;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class RequisicaoServiceImpl implements RequisicaoService {

    @Inject
    private RequisicaoRepository requisicaoRepository;

    @Override
    public List todos() throws Exception {
        
        return requisicaoRepository.todos();
        
    }

    @Override
    public void encerrarExpiradas() throws Exception {
        
        Date agora = new Date();
        List<Requisicao> requisicoes = requisicaoRepository.aSerEncerradas(agora);
        
        for (Requisicao requisicao : requisicoes) {
            StatusRequisicao statusRequisicao = new StatusRequisicao();
            statusRequisicao.setIdStatusRequisicao(StatusRequisicaoEnum.ENCERRADA.getStatusRequisicao());
            requisicao.setStatusRequisicao(statusRequisicao);
            
            requisicaoRepository.atualiza(requisicao);
        }
    }
    
    
    
    @Override
    public Requisicao porId(Long id) throws Exception {

        Requisicao requisicao = requisicaoRepository.porId(id);
        requisicao.setDtAberturaPropostaS(DataFormatUtil.getDataString(requisicao.getDtAberturaProposta()));
        requisicao.setDtCriacaoRequisicaoS(DataFormatUtil.getDataString(requisicao.getDtCriacaoRequisicao()));
        requisicao.setDtEncerramentoPropostaS(DataFormatUtil.getDataString(requisicao.getDtEncerramentoProposta()));

        return requisicaoRepository.porId(id);
    }

    @Override
    public Requisicao salvar(Requisicao requisicao, Login login) throws Exception {
        
        StatusRequisicao statusRequisicao = new StatusRequisicao();
        statusRequisicao.setIdStatusRequisicao(StatusRequisicaoEnum.ABERTA.getStatusRequisicao());
        requisicao.setStatusRequisicao(statusRequisicao);
        requisicao.setLogin(login);
        requisicao.setDtCriacaoRequisicao(new Date());
//        requisicao = porId(requisicao.getIdRequisicao());

        requisicao.setDtAberturaProposta(DataFormatUtil.getData(requisicao.getDtAberturaPropostaS()));
        requisicao.setDtEncerramentoProposta(DataFormatUtil.getData(requisicao.getDtEncerramentoPropostaS()));

        return requisicaoRepository.adiciona(requisicao);
    }

    @Override
    public Requisicao atualizar(Requisicao requisicao) throws Exception {

        Requisicao req = porId(requisicao.getIdRequisicao());

        req.setDtAberturaProposta(DataFormatUtil.getData(requisicao.getDtAberturaPropostaS()));
        req.setDtEncerramentoProposta(DataFormatUtil.getData(requisicao.getDtEncerramentoPropostaS()));
        req.setDescricao(requisicao.getDescricao());
        
        return requisicaoRepository.atualiza(req);
    }
}
