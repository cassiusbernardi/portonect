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
import javax.validation.constraints.Size;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_ANEXO")
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_ANEXO") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnexo;
    @Column(name="NM_ANEXO") @Size(max=100)
    private String nome;
    @Column(name="DS_PATH_ANEXO") @Size(max=200)
    private String path;
    @ManyToOne @JoinColumn(name="ID_REQUISICAO")
    private Requisicao requisicao;
    @ManyToOne @JoinColumn(name="ID_TIPO_ANEXO")
    private TipoAnexo tipoAnexo;
    @Column(name="FL_ATIVO")
    private boolean ativo = true;

    public int getIdAnexo() {
        return idAnexo;
    }

    public void setIdAnexo(int idAnexo) {
        this.idAnexo = idAnexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public TipoAnexo getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(TipoAnexo tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
