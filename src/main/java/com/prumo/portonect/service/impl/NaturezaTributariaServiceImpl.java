/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.NaturezaTributaria;
import com.prumo.portonect.repository.NaturezaTributariaRepository;
import com.prumo.portonect.service.NaturezaTributariaService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class NaturezaTributariaServiceImpl implements NaturezaTributariaService {

    @Inject
    private NaturezaTributariaRepository naturezaTributariaRepository;

    @Override
    public List<NaturezaTributaria> todos() throws Exception {
        return naturezaTributariaRepository.todos();
    }

    @Override
    public NaturezaTributaria porId(Integer id) throws Exception {
        
        return naturezaTributariaRepository.porId(id);
    }

    
}
