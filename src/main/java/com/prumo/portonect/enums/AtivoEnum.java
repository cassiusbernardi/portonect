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
public enum AtivoEnum {
    
    ATIVO(true),
    INATIVO(false);
    

    private final boolean status;

    AtivoEnum(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
