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
import com.prumo.portonect.entity.AnexoParticipante;
import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
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
public class GestaoFornecedorController {

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

    @Get("/suprimento/fornecedor")
    public void gestaoFornecedor() throws Exception {

        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            login = (Login) sessao.getAttribute("usuarioLogado");

            List<Fornecedor> fornecedores = fornecedorService.todos();
            result.include("fornecedores", fornecedores);

        } catch (Exception e) {

        }

    }

    @Get("/suprimento/fornecedor/{idFornecedor}")
    public void detalhesFornecedor(long idFornecedor) {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {
            Fornecedor fornecedor = fornecedorService.porId(idFornecedor);

            result.include("fornecedor", fornecedor);

        } catch (Exception e) {
            e.printStackTrace();
            result.include("error", "Erro ao completar a requisição.");
        }

        result.include("login", login);

    }

}
