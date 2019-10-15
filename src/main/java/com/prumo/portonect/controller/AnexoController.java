/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.download.FileDownload;
import br.com.caelum.vraptor.observer.download.ZipDownload;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import com.prumo.portonect.bean.RetornoBean;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.service.AnexoService;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author 120000499
 */
@Controller
public class AnexoController {

    @Inject
    private Result result;
    @Inject
    private AnexoService anexoService;

//    @Path("/anexo/downloadMetaEvidencia")
    public File downloadDocumento(Anexo anexo) {

        try {

            anexo = anexoService.porId(anexo.getIdAnexo());
//            String extensao = m.getPath().substring(m.getPath().length() - 4, m.getPath().length());
            File file = new File(anexo.getPath());
            return file;
//            String contentType = FilenameUtils.getExtension(file.getName());
//            
//            if (".pdf".equals(contentType))
//                contentType = "application/pdf";
//            else 
//                contentType = "image/*";

//            File file = new File(anexo.getPath());
//            Path path = file.toPath();
//            return new ZipDownload("anexo.zip", path);
        } catch (Exception ex) {
//            Logger.getLogger(VisitanteController.class.getName()).log(Level.WARNING, null, ex);
            return null;
        }
    }
    
    @Post("/requisicao/uploadArquivo")
    public void uploadArquivo(Requisicao anexoRequisicao, List<UploadedFile> arquivos) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
//        List<UploadedFile> arquivos = new ArrayList();
        try {
//            arquivos.add(file);
            List<Anexo> anexos = anexoService.salvar(anexoRequisicao, arquivos);
            retornoBean.setStatus(1);
            result.include("success", "Registro realizado com sucesso.");

        } catch (Exception e) {

            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");

        }

        result.redirectTo(RequisicaoController.class).telaRequisicao(anexoRequisicao.getIdRequisicao());

//        result.use(Results.json()).serializeNulls().from(true).recursive().serialize();
    }

    public void removerAnexo(Anexo anexo) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
        Requisicao requisicao = new Requisicao();
        try {

            anexo = anexoService.porId(anexo.getIdAnexo());
            requisicao = anexo.getRequisicao();
            anexo = anexoService.remover(anexo);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(RequisicaoController.class).telaRequisicao(requisicao.getIdRequisicao());

    }

}
