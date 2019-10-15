/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.enums;

/**
 *
 * @author 120000499
 */
public enum TipoAnexoParticipanteEnum {

    PROPOSTA_TECNICA(1),
    PROPOSTA_COMERCIAL(2);

    private final int tipoAnexo;

    TipoAnexoParticipanteEnum(int status) {
        this.tipoAnexo = status;
    }

    public int getTipoAnexo() {
        return this.tipoAnexo;
    }
}