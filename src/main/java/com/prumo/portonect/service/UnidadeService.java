/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Unidade;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface UnidadeService {
    
    public List<Unidade> todos() throws Exception;
    public Unidade porId(Integer id) throws Exception;
    
}
