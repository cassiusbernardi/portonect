/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.Requisicao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface RequisicaoService {
    
    public List<Requisicao> todos() throws Exception;
    public void encerrarExpiradas() throws Exception;
    public Requisicao porId(Long id) throws Exception;
    public Requisicao salvar(Requisicao requisicao, Login login) throws Exception;
    public Requisicao atualizar(Requisicao requisicao) throws Exception; 
}
