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
@Table(name="TB_ANEXO_PARTICIPANTE")
public class AnexoParticipante implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id @Column(name="ID_ANEXO_PARTICIPANTE") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnexo;
    @Column(name="NM_ANEXO") @Size(max=100)
    private String nome;
    @Column(name="DS_PATH_ANEXO") @Size(max=200)
    private String path;
    @ManyToOne @JoinColumn(name="ID_PARTICIPANTE_REQUISICAO")
    private ParticipanteRequisicao participanteRequisicao;
    @ManyToOne @JoinColumn(name="ID_TIPO_ANEXO_PARTICIPANTE")
    private TipoAnexoParticipante tipoAnexoParticipante;
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

    public ParticipanteRequisicao getParticipanteRequisicao() {
        return participanteRequisicao;
    }

    public void setParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) {
        this.participanteRequisicao = participanteRequisicao;
    }

    public TipoAnexoParticipante getTipoAnexoParticipante() {
        return tipoAnexoParticipante;
    }

    public void setTipoAnexoParticipante(TipoAnexoParticipante tipoAnexoParticipante) {
        this.tipoAnexoParticipante = tipoAnexoParticipante;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
}
