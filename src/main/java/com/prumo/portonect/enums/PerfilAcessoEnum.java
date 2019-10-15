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
public enum PerfilAcessoEnum {
    
    FORNECEDOR(1),
    SUPRIMENTO(2);
    

    private final int perfilAcesso;

    PerfilAcessoEnum(int status) {
        this.perfilAcesso = status;
    }

    public int getPerfilAcesso() {
        return this.perfilAcesso;
    }
}
