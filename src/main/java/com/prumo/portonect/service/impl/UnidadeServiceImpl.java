/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Unidade;
import com.prumo.portonect.repository.UnidadeRepository;
import com.prumo.portonect.service.UnidadeService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class UnidadeServiceImpl implements UnidadeService {

    @Inject
    private UnidadeRepository unidadeRepository;

    @Override
    public List todos() throws Exception {
        return unidadeRepository.todos();
    }

    @Override
    public Unidade porId(Integer id) throws Exception {
        
        return unidadeRepository.porId(id);
    }

    
}
