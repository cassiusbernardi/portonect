/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.RamoAtuacao;
import com.prumo.portonect.repository.RamoAtuacaoRepository;
import com.prumo.portonect.service.RamoAtuacaoService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class RamoAtuacaoServiceImpl implements RamoAtuacaoService {

    @Inject
    private RamoAtuacaoRepository ramoAtuacaoRepository;

    @Override
    public List<RamoAtuacao> todos() throws Exception {
        return ramoAtuacaoRepository.todos();
    }

    @Override
    public RamoAtuacao porId(Integer id) throws Exception {
        
        return ramoAtuacaoRepository.porId(id);
    }

    
}
