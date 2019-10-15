/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_LOGIN")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_LOGIN") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;
    
    @ManyToOne @JoinColumn(name="ID_FORNECEDOR")
    private Fornecedor fornecedor;
    
    @Column(name="CD_LOGIN") @Size(max=200)
    private String chave;
    
    @Column(name="NM_LOGIN") @Size(max=200)
    private String nome;
    
    @Column(name="DS_MAIL_LOGIN") @Size(max=200)
    private String email;
    
    @Column(name="DS_SENHA_LOGIN") @Size(max=128)
    private String senha;
    
    @OneToMany(mappedBy="login", fetch=FetchType.EAGER)
    private List<PerfilAcessoLogin> perfilAcesso;
    
    @Column(name="FL_ATIVO")
    private boolean ativo = true;

    @Column(name="FL_EXTERNO")
    private boolean externo = true;
    
    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public List<PerfilAcessoLogin> getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(List<PerfilAcessoLogin> perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }   

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }
    
}
