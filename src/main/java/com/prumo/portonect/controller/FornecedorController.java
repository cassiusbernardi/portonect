/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import com.prumo.portonect.bean.RetornoBean;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.enums.StatusRequisicaoEnum;
import com.prumo.portonect.service.AnexoParticipanteService;
import com.prumo.portonect.service.AnexoService;
import com.prumo.portonect.service.EmailService;
import com.prumo.portonect.service.FornecedorService;
import com.prumo.portonect.service.ItemRequisicaoService;
import com.prumo.portonect.service.ItemVersaoService;
import com.prumo.portonect.service.ParticipanteRequisicaoService;
import com.prumo.portonect.service.RequisicaoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 *
 * @author 120000499
 */
@Controller
public class FornecedorController {

    @Inject
    private Result result;
    @Inject
    private FornecedorService fornecedorService;
    @Inject
    private RequisicaoService requisicaoService;
    @Inject
    private ParticipanteRequisicaoService participanteRequisicaoService;
    @Inject
    private ItemRequisicaoService itemRequisicaoService;
    @Inject
    private ItemVersaoService itemVersaoService;
    @Inject
    private AnexoService anexoService;
    @Inject
    private AnexoParticipanteService anexoParticipanteService;
    @Inject
    private EmailService emailService;

    private Login login;

    @Get("/fornecedor/porContrato/{idContrato}")
    public void fornecedor(Long idContrato) throws Exception {

        RetornoBean retornoBean = new RetornoBean();

        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            login = (Login) sessao.getAttribute("usuarioLogado");

            retornoBean.setStatus(1);

        } catch (Exception e) {

            retornoBean.setStatus(3);

        }

        result.use(Results.json()).serializeNulls().from(retornoBean).recursive().serialize();

    }

    @Get("/fornecedor/cnpj/{cnpj}")
    public void fornecedor(String cnpj) throws Exception {

        RetornoBean retornoBean = new RetornoBean();

        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            login = (Login) sessao.getAttribute("usuarioLogado");
            Fornecedor fornecedor = fornecedorService.porCnpj(cnpj);
            retornoBean.setObject(fornecedor);
            retornoBean.setStatus(1);

        } catch (Exception e) {

            retornoBean.setStatus(3);

        }

        result.use(Results.json()).serializeNulls().from(retornoBean).recursive().serialize();

    }

    public void inicio() {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {

            Fornecedor fornecedor = login.getFornecedor();
            List<ParticipanteRequisicao> prs = participanteRequisicaoService.porFornecedor(fornecedor);

            result.include("prs", prs);

        } catch (Exception e) {
            result.include("error", "Deu ruim");

        }

    }

    @Path("/fornecedor/exibir/{idParticipanteRequisicao}")
    public void respostaRequisicao(long idParticipanteRequisicao) throws Exception {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");
        try {

            ParticipanteRequisicao participanteRequisicao = participanteRequisicaoService.porId(idParticipanteRequisicao);
//            List<ItemRequisicao> itensRequisicao = itemRequisicaoService.porParticipanteRequisicao(participanteRequisicao.getRequisicao());
            List<ItemVersao> itens = itemVersaoService.porParticipanteRequisicao(participanteRequisicao);
            List<AnexoParticipante> anexosParticipante = anexoParticipanteService.porParticipanteRequisicao(participanteRequisicao);
            
            Requisicao requisicao = participanteRequisicao.getRequisicao();
            
            List<Anexo> anexos = anexoService.porRequisicao(requisicao);
            
            int editavel = 1;
            Date hoje = new Date();
            int compareInicio = hoje.compareTo(requisicao.getDtAberturaProposta());
            int compareFim = hoje.compareTo(requisicao.getDtEncerramentoProposta());
            if (compareInicio < 0 || compareFim > 0 || requisicao.getStatusRequisicao().getIdStatusRequisicao() == StatusRequisicaoEnum.ENCERRADA.getStatusRequisicao()) {
                editavel = 0;
            }
            
            result.include("anexos", anexos);
            result.include("anexosParticipante", anexosParticipante);
            result.include("itens", itens);
            result.include("editavel", editavel);
//            result.include("itensRequisicao", itensRequisicao);
            result.include("participanteRequisicao", participanteRequisicao);

        } catch (Exception e) {
            e.printStackTrace();
            result.include("error", "Erro ao completar a requisição.");
            result.redirectTo(this).inicio();
        }

        result.include("login", login);

    }

    public void registrarValor(List<ItemVersao> itens, ParticipanteRequisicao participanteRequisicao) throws Exception {

        RetornoBean retornoBean = new RetornoBean();

        try {

            for (ItemVersao item : itens) {
                itemVersaoService.atualizar(item);
            }

            result.include("success", "Registro realizado com sucesso.");

        } catch (Exception e) {

            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");

        }

        result.redirectTo(this).respostaRequisicao(participanteRequisicao.getIdParticipanteRequisicao());
    }

//    @Post("/fornecedor/uploadArquivo")
//    public void uploadArquivo(ParticipanteRequisicao participanteRequisicao,TipoAnexoParticipante tipo, List<UploadedFile> arquivos) throws Exception {
//
//        RetornoBean retornoBean = new RetornoBean();
////        List<UploadedFile> arquivos = new ArrayList();
//        try {
////            arquivos.add(file);
//            List<AnexoParticipante> anexos = anexoParticipanteService.salvar(participanteRequisicao,tipo, arquivos);
//            retornoBean.setStatus(1);
//            result.include("success", "Registro realizado com sucesso.");
//
//        } catch (Exception e) {
//
//            retornoBean.setStatus(3);
//            result.include("error", "Erro ao registrar.");
//
//        }
//
//        result.redirectTo(this).respostaRequisicao(participanteRequisicao.getIdParticipanteRequisicao());
//    }
}
