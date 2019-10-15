/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.TipoAnexoParticipante;
import com.prumo.portonect.enums.AtivoEnum;
import com.prumo.portonect.enums.TipoAnexoParticipanteEnum;
import com.prumo.portonect.repository.AnexoParticipanteRepository;
import com.prumo.portonect.service.AnexoParticipanteService;
import com.prumo.portonect.util.ArquivoUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class AnexoParticipanteServiceImpl implements AnexoParticipanteService {
    
    @Inject
    private AnexoParticipanteRepository anexoParticipanteRepository;

    @Override
    public List<AnexoParticipante> todos() throws Exception {
        return anexoParticipanteRepository.todos();
    }
    
    @Override
    public List<AnexoParticipante> ativos() throws Exception {
        return anexoParticipanteRepository.ativos();
    }

    @Override
    public AnexoParticipante porId(Integer id) throws Exception {
        return anexoParticipanteRepository.porId(id);
    }
    
    @Override
    public List<AnexoParticipante> porParticipanteRequisicao(ParticipanteRequisicao participanteRequisicao) throws Exception {
        return anexoParticipanteRepository.porParticipanteRequisicao(participanteRequisicao);
    }
    
    @Override
    public List<AnexoParticipante> porResultadoRequisicao(Requisicao requisicao, ParticipanteRequisicao participanteRequisicao) throws Exception {
        return anexoParticipanteRepository.porResultadoRequisicao(requisicao, participanteRequisicao);
    }

    @Override
    public List<AnexoParticipante> salvar(ParticipanteRequisicao participanteRequisicao,TipoAnexoParticipante tipo, List<UploadedFile> arquivos) throws Exception {
        
        List<AnexoParticipante> anexos = new ArrayList();
        
        for (UploadedFile arquivo : arquivos) {
            int idReferencia = anexoParticipanteRepository.getIdAtual() + 1;
            String nomeArquivo = idReferencia + "." + participanteRequisicao.getIdParticipanteRequisicao().toString() + "-" + arquivo.getFileName();
            String path = ArquivoUtil.geraNomeArquivo(nomeArquivo,arquivo);
            AnexoParticipante anexo = new AnexoParticipante();
            anexo.setParticipanteRequisicao(participanteRequisicao);         
            anexo.setNome(nomeArquivo);
            anexo.setPath(path);
            
            TipoAnexoParticipante tipoAnexo = new TipoAnexoParticipante();
            tipoAnexo.setIdTipoAnexo(tipo.getIdTipoAnexo());
            anexo.setTipoAnexoParticipante(tipoAnexo);
            
            try {
                ArquivoUtil.salvarArquivo(anexo.getPath(), arquivo);
                anexo = anexoParticipanteRepository.adiciona(anexo);
                anexos.add(anexo);
            } catch (Exception e) {
                e.printStackTrace();
                anexos = null;
            }
            
        }
        
        return anexos;
    }

    @Override
    public AnexoParticipante remover(AnexoParticipante anexoParticipante) throws Exception {
        
        anexoParticipante = porId(anexoParticipante.getIdAnexo());
        anexoParticipante.setAtivo(AtivoEnum.INATIVO.getStatus());
        anexoParticipanteRepository.atualiza(anexoParticipante);
        
        return anexoParticipante;
        
    }
    
    
    
}
