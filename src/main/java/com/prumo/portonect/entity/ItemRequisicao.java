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
@Table(name="TB_ITEM_REQUISICAO")
public class ItemRequisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_ITEM_REQUISICAO") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemRequisicao;
    @ManyToOne @JoinColumn(name="ID_REQUISICAO")
    private Requisicao requisicao;
    @ManyToOne @JoinColumn(name="ID_UNIDADE")
    private Unidade unidade;
    @Column(name="DS_ITEM") @Size(max=200)
    private String descricao;
    @Column(name="QT_ITEM")
    private int quantidade;
    @Column(name="VL_ITEM")
    private Double valor;
    @Column(name="FL_ATIVO")
    private boolean ativo = true;
    @OneToMany(mappedBy="itemRequisicao", fetch=FetchType.EAGER)
    private List<ItemVersao> itensVersao;
    
    public Long getIdItemRequisicao() {
        return idItemRequisicao;
    }

    public void setIdItemRequisicao(Long idItemRequisicao) {
        this.idItemRequisicao = idItemRequisicao;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ItemVersao> getItensVersao() {
        return itensVersao;
    }

    public void setItensVersao(List<ItemVersao> itensVersao) {
        this.itensVersao = itensVersao;
    }
}
