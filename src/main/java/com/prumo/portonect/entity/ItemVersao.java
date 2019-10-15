/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_ITEM_VERSAO")
public class ItemVersao implements Serializable {

    private static final long serialVersionUID = 1L;
    
//    @EmbeddedId
//    private ItemVersaoPK itemVersaoPK;
    @Id @Column(name="ID_ITEM_VERSAO ") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemVersao;
    @ManyToOne @JoinColumn(name="ID_ITEM_REQUISICAO",unique=true, nullable=false)
    private ItemRequisicao itemRequisicao;
    @ManyToOne @JoinColumn(name="ID_PARTICIPANTE_REQUISICAO",unique=true, nullable=false)
    private ParticipanteRequisicao participanteRequisicao;
    @Column(name="NR_VERSAO",unique=true, nullable=false)
    private int versao;
    @Column(name="VL_ITEM")
    private Double valor;    
    @Column(name="FL_ATIVO")
    private boolean ativo = true;
    @Transient
    private boolean vencedor;
    @Transient
    private String valorS;

    public Integer getIdItemVersao() {
        return idItemVersao;
    }

    public void setIdItemVersao(Integer idItemVersao) {
        this.idItemVersao = idItemVersao;
    }

    public ItemRequisicao getItemRequisicao() {
        return itemRequisicao;
    }

    public void setItemRequisicao(ItemRequisicao itemRequisicao) {
        this.itemRequisicao = itemRequisicao;
    }

    public ParticipanteRequisicao getParticipanteRequisicao() {
        return participanteRequisicao;
    }

    public void setParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) {
        this.participanteRequisicao = participanteRequisicao;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
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

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }

    public String getValorS() {
        return valorS;
    }

    public void setValorS(String valorS) {
        this.valorS = valorS;
    }
    
}
