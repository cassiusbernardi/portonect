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
public enum TipoAnexoEnum {

    COMPRADOR(1),
    FORNECEDOR(2);

    private final int tipoAnexo;

    TipoAnexoEnum(int status) {
        this.tipoAnexo = status;
    }

    public int getTipoAnexo() {
        return this.tipoAnexo;
    }
}