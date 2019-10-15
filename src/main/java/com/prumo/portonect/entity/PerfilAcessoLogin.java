/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_PERFIL_ACESSO_LOGIN")
public class PerfilAcessoLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PerfilAcessoLoginPK perfilAcessoLoginPK;
    
//    @ManyToOne @JoinColumn(name="ID_LOGIN")
//    private Login login;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_LOGIN", insertable=false, updatable=false)
    private Login login;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ID_PERFIL_ACESSO", insertable=false, updatable=false)
    private PerfilAcesso perfilAcesso;
    
    public PerfilAcessoLoginPK getPerfilAcessoLoginPK() {
        return perfilAcessoLoginPK;
    }

    public void setPerfilAcessoLoginPK(PerfilAcessoLoginPK perfilAcessoLoginPK) {
        this.perfilAcessoLoginPK = perfilAcessoLoginPK;
    }    

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
    
}
