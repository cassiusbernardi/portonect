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
public enum StatusRequisicaoEnum {

    ABERTA(1),
    ENCERRADA(2),
    AGUARDANDO_COTACAO(3);

    private final int statusRequisicao;

    StatusRequisicaoEnum(int status) {
        this.statusRequisicao = status;
    }

    public int getStatusRequisicao() {
        return this.statusRequisicao;
    }
}