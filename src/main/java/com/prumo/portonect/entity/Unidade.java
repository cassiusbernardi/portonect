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
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author 120000499
 */
@Entity
@Table(name="TB_UNIDADE")
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_UNIDADE") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidade;
    @Column(name="DS_UNIDADE") @Size(max=200)
    private String descricao;

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
