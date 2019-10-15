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
public enum TipoLoginEnum {
    
    EXTERNO(true),
    INTERNO(false);
    

    private final boolean tipo;

    TipoLoginEnum(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean getTipo() {
        return this.tipo;
    }
}
