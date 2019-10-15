/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.TipoAnexo;
import com.prumo.portonect.enums.AtivoEnum;
import com.prumo.portonect.enums.TipoAnexoEnum;
import com.prumo.portonect.repository.AnexoRepository;
import com.prumo.portonect.service.AnexoService;
import com.prumo.portonect.util.ArquivoUtil;
import com.prumo.portonect.util.PropertiesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class AnexoServiceImpl implements AnexoService {
    
    @Inject
    private AnexoRepository anexoRepository;

    @Override
    public List<Anexo> todos() throws Exception {
        return anexoRepository.todos();
    }
    
    @Override
    public List<Anexo> ativos() throws Exception {
        return anexoRepository.ativos();
    }

    @Override
    public Anexo porId(Integer id) throws Exception {
        return anexoRepository.porId(id);
    }
    
    @Override
    public List<Anexo> porRequisicao(Requisicao requisicao) throws Exception {
        return anexoRepository.porRequisicao(requisicao);
    }

    @Override
    public List<Anexo> salvar(Requisicao anexoRequisicao,List<UploadedFile> arquivos) throws Exception {
        
        List<Anexo> anexos = new ArrayList();
        
        for (UploadedFile arquivo : arquivos) {
            int idReferencia = anexoRepository.getIdAtual() + 1;
            String nomeArquivo = idReferencia + "." + anexoRequisicao.getIdRequisicao().toString() + "-" + arquivo.getFileName();
            String path = ArquivoUtil.geraNomeArquivo(nomeArquivo,arquivo);
            Anexo anexo = new Anexo();
            anexo.setRequisicao(anexoRequisicao);            
            anexo.setNome(nomeArquivo);
            anexo.setPath(path);
            TipoAnexo tipoAnexo = new TipoAnexo();
            tipoAnexo.setIdTipoAnexo(TipoAnexoEnum.COMPRADOR.getTipoAnexo());
            anexo.setTipoAnexo(tipoAnexo);
            
            try {
                ArquivoUtil.salvarArquivo(anexo.getPath(), arquivo);
                anexo = anexoRepository.adiciona(anexo);
                anexos.add(anexo);
            } catch (Exception e) {
                e.printStackTrace();
                anexos = null;
            }
            
        }
        
        return anexos;
    }

    @Override
    public Anexo remover(Anexo anexoRequisicao) throws Exception {
        
        anexoRequisicao = porId(anexoRequisicao.getIdAnexo());
        anexoRequisicao.setAtivo(AtivoEnum.INATIVO.getStatus());
        anexoRepository.atualiza(anexoRequisicao);
        
        return anexoRequisicao;
        
    }
    
    
    
}
