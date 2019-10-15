/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Requisicao;

/**
 *
 * @author 120000499
 */
public interface EnviarRequisicaoService {
    
    public void enviar(Requisicao requisicao) throws Exception;
}
