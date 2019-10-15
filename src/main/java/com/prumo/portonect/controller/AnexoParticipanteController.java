/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.FileDownload;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.bean.RetornoBean;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.TipoAnexoParticipante;
import com.prumo.portonect.service.AnexoParticipanteService;
import com.prumo.portonect.service.AnexoService;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author 120000499
 */
@Controller
public class AnexoParticipanteController {
    
    @Inject private Result result;
    @Inject private AnexoParticipanteService anexoParticipanteService;
    
//    @Path("/anexo/downloadMetaEvidencia")
    public File downloadDocumento(AnexoParticipante anexoParticipante) {
                
        try {
            
            anexoParticipante = anexoParticipanteService.porId(anexoParticipante.getIdAnexo());
//            String extensao = m.getPath().substring(m.getPath().length() - 4, m.getPath().length());
            File file = new File(anexoParticipante.getPath());
            
//            String contentType = FilenameUtils.getExtension(file.getName());
            
//            if (".pdf".equals(extensao))
//                contentType = "application/pdf";
//            else 
//                contentType = "image/*";
//            return new FileDownload(file, contentType, file.getName());
            return file;
            
        } catch (Exception ex) {
//            Logger.getLogger(VisitanteController.class.getName()).log(Level.WARNING, null, ex);
            return null;
        }
    }
    
    
    
    public void removerAnexo(AnexoParticipante anexoParticipante) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
        ParticipanteRequisicao participantePequisicao = new ParticipanteRequisicao();
        try {

            anexoParticipante = anexoParticipanteService.porId(anexoParticipante.getIdAnexo());
            participantePequisicao = anexoParticipante.getParticipanteRequisicao();
            anexoParticipante = anexoParticipanteService.remover(anexoParticipante);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(FornecedorController.class).respostaRequisicao(participantePequisicao.getIdParticipanteRequisicao());

    }
    
    @Post("/fornecedor/uploadArquivo")
    public void uploadArquivo(ParticipanteRequisicao participanteRequisicao,TipoAnexoParticipante tipo, List<UploadedFile> arquivos) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
//        List<UploadedFile> arquivos = new ArrayList();
        try {
//            arquivos.add(file);
            List<AnexoParticipante> anexos = anexoParticipanteService.salvar(participanteRequisicao,tipo, arquivos);
            retornoBean.setStatus(1);
            result.include("success", "Registro realizado com sucesso.");

        } catch (Exception e) {

            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");

        }

        result.redirectTo(FornecedorController.class).respostaRequisicao(participanteRequisicao.getIdParticipanteRequisicao());
    }
    
}
