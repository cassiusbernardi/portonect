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
@Table(name="TB_RAMO_ATUACAO")
public class RamoAtuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_RAMO_ATUACAO") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRamoAtuacao;
    @Column(name="DS_RAMO_ATUACAO") @Size(max=200)
    private String descricao;

    public int getIdRamoAtuacao() {
        return idRamoAtuacao;
    }

    public void setIdRamoAtuacao(int idRamoAtuacao) {
        this.idRamoAtuacao = idRamoAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
