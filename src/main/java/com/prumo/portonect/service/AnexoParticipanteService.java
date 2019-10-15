/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.TipoAnexoParticipante;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface AnexoParticipanteService {
    
    public List<AnexoParticipante> todos() throws Exception;
    public List<AnexoParticipante> ativos() throws Exception;
    public AnexoParticipante porId(Integer id) throws Exception;
    public List<AnexoParticipante> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) throws Exception;
    public List<AnexoParticipante> porResultadoRequisicao(Requisicao requisicao, ParticipanteRequisicao participanteRequisicao) throws Exception;
    public List<AnexoParticipante> salvar(ParticipanteRequisicao participanteRequisicao,TipoAnexoParticipante tipo, List<UploadedFile> arquivos) throws Exception;
    public AnexoParticipante remover(AnexoParticipante anexoParticipante) throws Exception;
    
}
