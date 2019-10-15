/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Unidade;
import com.prumo.portonect.entity.QUnidade;

/**
 *
 * @author 120000499
 */
public class UnidadeRepository extends BaseRepository<Unidade> {
    
    private QUnidade unidade = QUnidade.unidade;
    
    public UnidadeRepository() {
        super(Unidade.class);
    }
    
}
