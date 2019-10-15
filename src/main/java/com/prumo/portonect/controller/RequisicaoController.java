/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.serialization.gson.WithRoot;
import br.com.caelum.vraptor.view.Results;
import com.prumo.portonect.bean.RetornoBean;
import com.prumo.portonect.entity.Anexo;
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.Unidade;
import com.prumo.portonect.service.AnexoParticipanteService;
import com.prumo.portonect.service.AnexoService;
import com.prumo.portonect.service.EnviarRequisicaoService;
import com.prumo.portonect.service.FornecedorService;
import com.prumo.portonect.service.UnidadeService;
import java.util.List;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import com.prumo.portonect.service.ItemRequisicaoService;
import com.prumo.portonect.service.ItemVersaoService;
import com.prumo.portonect.service.ParticipanteRequisicaoService;
import com.prumo.portonect.service.RequisicaoService;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 120000499
 */
@Controller
public class RequisicaoController {

    @Inject
    private Result result;
    @Inject
    private RequisicaoService requisicaoService;
    @Inject
    private ItemRequisicaoService itemRequisicaoService;
    @Inject
    private UnidadeService unidadeService;
    @Inject
    private AnexoService anexoService;
    @Inject
    private AnexoParticipanteService anexoParticipanteService;
    @Inject
    private FornecedorService fornecedorService;
    @Inject
    private ParticipanteRequisicaoService participanteRequisicaoService;
    @Inject
    private EnviarRequisicaoService enviarRequisicaoService;
    @Inject
    private ItemVersaoService itemVersaoService;
    private Login login;

    @Path("/requisicao/exibir/{idRequisicao}")
    public void telaRequisicao(long idRequisicao) throws Exception {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {
            if (idRequisicao != 0) {

                Requisicao requisicao = requisicaoService.porId(idRequisicao);
                List<ItemRequisicao> itens = itemRequisicaoService.porRequisicao(requisicao);
                List<Anexo> anexos = anexoService.porRequisicao(requisicao);
                List<Fornecedor> fornecedores = fornecedorService.todos();
                List<ParticipanteRequisicao> participantes = participanteRequisicaoService.porRequisicao(requisicao);

                result.include("anexos", anexos);
                result.include("itemsRequisicao", itens);
                result.include("requisicao", requisicao);
                result.include("fornecedores", fornecedores);
                result.include("participantes", participantes);

            }

            List<Unidade> unidades = unidadeService.todos();

            result.include("unidades", unidades);

        } catch (Exception e) {
            e.printStackTrace();
            result.include("error", "Erro ao completar a requisição.");
        }

        result.include("login", login);

    }

    public void salvarParcial(Requisicao requisicao) throws Exception {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {
            if (requisicao.getIdRequisicao() == null) {
                requisicao = requisicaoService.salvar(requisicao, login);
            } else {
                requisicao = requisicaoService.atualizar(requisicao);
            }

            result.include("success", "Registro realizado com sucesso.");
            
        } catch (Exception e) {
            e.printStackTrace();
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(this).telaRequisicao(requisicao.getIdRequisicao());
    }

    public void salvarItem(Requisicao requisicao, ItemRequisicao itemRequisicao) throws Exception {

        RetornoBean retornoBean = new RetornoBean();

        try {

            itemRequisicao = itemRequisicaoService.salvar(itemRequisicao, requisicao);
            List<ItemRequisicao> itens = itemRequisicaoService.porRequisicao(requisicao);
            for (ItemRequisicao item : itens) {
                item.setRequisicao(null);
            }
            retornoBean.setLista(itens);
            retornoBean.setStatus(1);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");
        }

        result.use(Results.json()).serializeNulls().from(retornoBean).recursive().serialize();

    }

    public void removerItem(ItemRequisicao itemRequisicao) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
        Requisicao requisicao = new Requisicao();
        try {

            itemRequisicao = itemRequisicaoService.porId(itemRequisicao.getIdItemRequisicao());
            requisicao = itemRequisicao.getRequisicao();
            itemRequisicao = itemRequisicaoService.remover(itemRequisicao);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(this).telaRequisicao(requisicao.getIdRequisicao());

    }

    @Post
    public void adicionarParticipante(List<ParticipanteRequisicao> participantesRequisicao, Requisicao req) throws Exception {

        try {

            for (ParticipanteRequisicao participanteRequisicao : participantesRequisicao) {
                participanteRequisicao.setRequisicao(req);
                participanteRequisicaoService.salvar(participanteRequisicao);
            }
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(this).telaRequisicao(req.getIdRequisicao());
    }

    public void removerParticipante(ParticipanteRequisicao participanteRequisicao) throws Exception {

        RetornoBean retornoBean = new RetornoBean();
        Requisicao requisicao = new Requisicao();
        try {

            participanteRequisicao = participanteRequisicaoService.porId(participanteRequisicao.getIdParticipanteRequisicao());
            requisicao = participanteRequisicao.getRequisicao();
            participanteRequisicao = participanteRequisicaoService.remover(participanteRequisicao);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            retornoBean.setStatus(3);
            result.include("error", "Erro ao registrar.");
        }

        result.redirectTo(this).telaRequisicao(requisicao.getIdRequisicao());

    }

    public void enviarRequisicao(Requisicao requisicao) throws Exception {

        try {
            enviarRequisicaoService.enviar(requisicao);
            result.include("success", "Registro realizado com sucesso.");
        } catch (Exception e) {
            result.include("error", "Erro ao registrar.");
        }
        
        result.redirectTo(this).telaRequisicao(requisicao.getIdRequisicao());
    }
    
    @Path("/requisicao/resposta/{idRequisicao}")
    public void resultadoRequisicao(long idRequisicao) throws Exception {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {
            if (idRequisicao != 0) {

                Requisicao requisicao = requisicaoService.porId(idRequisicao);
                List<ItemRequisicao> itens = itemRequisicaoService.porRequisicao(requisicao);
                
                List<Anexo> anexos = anexoService.porRequisicao(requisicao);  
                
                HashMap<ItemRequisicao,List> itensVersaoMap = new HashMap();
                List<ItemVersao> itensVersao = new ArrayList();                
                for (ItemRequisicao item : itens) {
                    itensVersao = itemVersaoService.porItemRequisicao(item);
                    itensVersaoMap.put(item, itensVersao);
                    String s = itensVersao.get(0).getValorS();
                }
                
                HashMap<ParticipanteRequisicao,List> participantesRequisicaoMap = new HashMap();                
                List<ParticipanteRequisicao> participantesRequisicao = participanteRequisicaoService.porRequisicao(requisicao);                
                for (ParticipanteRequisicao participanteRequisicao : participantesRequisicao) {
                    List<AnexoParticipante> anexosParticipante = anexoParticipanteService.porResultadoRequisicao(requisicao,participanteRequisicao);
                    participantesRequisicaoMap.put(participanteRequisicao, anexosParticipante);
                }
                
                result.include("anexos", anexos);
                result.include("participantesRequisicaoMap", participantesRequisicaoMap);
                result.include("itensVersaoMap", itensVersaoMap);
                result.include("itemsRequisicao", itens);
                result.include("requisicao", requisicao);

            }

        } catch (Exception e) {
            e.printStackTrace();
            result.include("error", "Erro ao completar a requisição.");
        }

        result.include("login", login);

    }

}
