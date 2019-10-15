/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.PerfilAcesso;
import com.prumo.portonect.entity.QPerfilAcesso;

/**
 *
 * @author 120000499
 */
public class PerfilAcessoRepository extends BaseRepository<PerfilAcesso>{
    
    private QPerfilAcesso perfilAcesso = QPerfilAcesso.perfilAcesso;
    
    public PerfilAcessoRepository() {
        super(PerfilAcesso.class);
    }
    
}
