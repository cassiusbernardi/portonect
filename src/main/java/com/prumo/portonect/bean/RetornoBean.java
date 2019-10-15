package com.prumo.portonect.bean;

import java.util.List;

public class RetornoBean {

    private int status;
    private String mensagem;
    private Object object;
    private List lista;

    public RetornoBean() {

    }

    public RetornoBean(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public RetornoBean(int status, String mensagem, Object object) {
        this.status = status;
        this.mensagem = mensagem;
        this.object = object;
    }

    public RetornoBean(int status, String mensagem, List lista) {
        this.status = status;
        this.mensagem = mensagem;
        this.lista = lista;
    }

    public RetornoBean(int status, String mensagem, Object object, List lista) {
        this.status = status;
        this.mensagem = mensagem;
        this.object = object;
        this.lista = lista;
    }

    public RetornoBean(int status, Object object, List lista) {
        this.status = status;
        this.object = object;
        this.lista = lista;
    }

    public RetornoBean(int status, Object object) {
        this.status = status;
        this.object = object;
    }

    public RetornoBean(int status, List lista) {
        this.status = status;
        this.lista = lista;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
}
