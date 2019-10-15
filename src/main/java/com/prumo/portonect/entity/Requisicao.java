/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_REQUISICAO")
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_REQUISICAO") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisicao;
    @ManyToOne @JoinColumn(name="ID_LOGIN")
    private Login login;
    @ManyToOne @JoinColumn(name="ID_STATUS_REQUISICAO")
    private StatusRequisicao statusRequisicao;
    @Column(name="DS_REQUISICAO") @Size(max=200)
    private String descricao;
    @Column(name="DT_ABERTURA_PROPOSTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtAberturaProposta;
    @Column(name="DT_CRIACAO_REQUISICAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCriacaoRequisicao;
    @Column(name="DT_ENCERRAMENTO_PROPOSTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtEncerramentoProposta;
//    @Column(name="DT_INPUT")
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date dtInput;
    @OneToMany(mappedBy="requisicao", fetch=FetchType.LAZY)
    private List<Anexo> anexos;
//    @OneToMany(mappedBy="requisicao", fetch=FetchType.LAZY)
//    private List<ItemRequisicao> itens;
    
    @Transient
    private String dtAberturaPropostaS;
    @Transient
    private String dtCriacaoRequisicaoS;
    @Transient
    private String dtEncerramentoPropostaS;

    public Long getIdRequisicao() {
        return idRequisicao;
    }

    public void setIdRequisicao(Long idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public StatusRequisicao getStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(StatusRequisicao statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtAberturaProposta() {
        return dtAberturaProposta;
    }

    public void setDtAberturaProposta(Date dtAberturaProposta) {
        this.dtAberturaProposta = dtAberturaProposta;
    }

    public Date getDtCriacaoRequisicao() {
        return dtCriacaoRequisicao;
    }

    public void setDtCriacaoRequisicao(Date dtCriacaoRequisicao) {
        this.dtCriacaoRequisicao = dtCriacaoRequisicao;
    }

    public Date getDtEncerramentoProposta() {
        return dtEncerramentoProposta;
    }

    public void setDtEncerramentoProposta(Date dtEncerramentoProposta) {
        this.dtEncerramentoProposta = dtEncerramentoProposta;
    }

//    public Date getDtInput() {
//        return dtInput;
//    }
//
//    public void setDtInput(Date dtInput) {
//        this.dtInput = dtInput;
//    }

    public String getDtAberturaPropostaS() {
        return dtAberturaPropostaS;
    }

    public void setDtAberturaPropostaS(String dtAberturaPropostaS) {
        this.dtAberturaPropostaS = dtAberturaPropostaS;
    }

    public String getDtCriacaoRequisicaoS() {
        return dtCriacaoRequisicaoS;
    }

    public void setDtCriacaoRequisicaoS(String dtCriacaoRequisicaoS) {
        this.dtCriacaoRequisicaoS = dtCriacaoRequisicaoS;
    }

    public String getDtEncerramentoPropostaS() {
        return dtEncerramentoPropostaS;
    }

    public void setDtEncerramentoPropostaS(String dtEncerramentoPropostaS) {
        this.dtEncerramentoPropostaS = dtEncerramentoPropostaS;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

//    public List<ItemRequisicao> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<ItemRequisicao> itens) {
//        this.itens = itens;
//    }
    
}
