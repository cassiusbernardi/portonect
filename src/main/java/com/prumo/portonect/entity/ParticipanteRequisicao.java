/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_PARTICIPANTE_REQUISICAO")
public class ParticipanteRequisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_PARTICIPANTE_REQUISICAO") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipanteRequisicao;
    @ManyToOne @JoinColumn(name="ID_REQUISICAO")
    private Requisicao requisicao;
    @ManyToOne @JoinColumn(name="ID_FORNECEDOR")
    private Fornecedor fornecedor;
    @Column(name="FL_ATIVO")
    private boolean ativo = true;    

    public Long getIdParticipanteRequisicao() {
        return idParticipanteRequisicao;
    }

    public void setIdParticipanteRequisicao(Long idParticipanteRequisicao) {
        this.idParticipanteRequisicao = idParticipanteRequisicao;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
