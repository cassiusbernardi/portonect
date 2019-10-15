/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.NaturezaTributaria;
import com.prumo.portonect.entity.QNaturezaTributaria;

/**
 *
 * @author 120000499
 */
public class NaturezaTributariaRepository extends BaseRepository<NaturezaTributaria> {
    
    private QNaturezaTributaria naturezaTributaria = QNaturezaTributaria.naturezaTributaria;
    
    public NaturezaTributariaRepository() {
        super(NaturezaTributaria.class);
    }
    
}
