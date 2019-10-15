/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.PerfilAcessoLogin;
import com.prumo.portonect.entity.QPerfilAcessoLogin;

/**
 *
 * @author 120000499
 */
public class PerfilAcessoLoginRepository extends BaseRepository<PerfilAcessoLogin> {
    
    private QPerfilAcessoLogin perfilAcessoLogin = QPerfilAcessoLogin.perfilAcessoLogin;
    
    public PerfilAcessoLoginRepository() {
        super(PerfilAcessoLogin.class);
    }
    
}
