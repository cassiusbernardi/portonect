/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 *
 * @author 120000499
 */
@Embeddable
public class PerfilAcessoLoginPK implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name="ID_LOGIN")
    private Long idLogin;
    
    @Column(name="ID_PERFIL_ACESSO")
    private Integer idPerfilAcesso;

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    public void setIdPerfilAcesso(Integer idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }
    
}
