/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.Requisicao;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface AnexoService {
    
    public List<Anexo> todos() throws Exception;
    public List<Anexo> ativos() throws Exception;
    public Anexo porId(Integer id) throws Exception;
    public List<Anexo> porRequisicao(Requisicao requisicao) throws Exception;
    public List<Anexo> salvar(Requisicao anexoRequisicao,List<UploadedFile> arquivos) throws Exception;
    public Anexo remover(Anexo anexoRequisicao) throws Exception;
    
}
