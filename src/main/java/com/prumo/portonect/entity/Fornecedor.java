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
@Table(name="TB_FORNECEDOR")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_FORNECEDOR") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;
    @ManyToOne @JoinColumn(name="ID_NATUREZA_TRIBUTARIA")
    private NaturezaTributaria naturezaTributaria;
    @ManyToOne @JoinColumn(name="ID_RAMO_ATUACAO")
    private RamoAtuacao ramoAtuacao;
    @Column(name="NM_FORNECEDOR") @Size(max=200)
    private String nome;    
    @Column(name="NM_RAZAO_SOCIAL") @Size(max=200)
    private String razaoSocial;
    @Column(name="NR_CNPJ") @Size(max=14)
    private String cnpj;
    @Column(name="SG_ESTADO") @Size(max=2)
    private String uf;
    @Column(name="DS_REGIME_TRIBUTARIO") @Size(max=100)
    private String regimeTributario;
    @Column(name="DS_TEMPO_ATIVIDADE") @Size(max=50)
    private String tempoAtividade;
    @Column(name="FL_ATIVO")
    private boolean ativo = true;
    @OneToMany(mappedBy="fornecedor", fetch=FetchType.EAGER)
    private List<Login> logins;

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public NaturezaTributaria getNaturezaTributaria() {
        return naturezaTributaria;
    }

    public void setNaturezaTributaria(NaturezaTributaria naturezaTributaria) {
        this.naturezaTributaria = naturezaTributaria;
    }

    public RamoAtuacao getRamoAtuacao() {
        return ramoAtuacao;
    }

    public void setRamoAtuacao(RamoAtuacao ramoAtuacao) {
        this.ramoAtuacao = ramoAtuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(String regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getTempoAtividade() {
        return tempoAtividade;
    }

    public void setTempoAtividade(String tempoAtividade) {
        this.tempoAtividade = tempoAtividade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }
    
}
