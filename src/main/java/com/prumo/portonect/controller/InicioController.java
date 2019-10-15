/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

//import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.Requisicao;
import java.util.List;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import com.prumo.portonect.service.RequisicaoService;

/**
 *
 * @author 120000499
 */
@Controller
public class InicioController {

    @Inject
    private Result result;
    @Inject
    private RequisicaoService requisicaoService;
    private Login login;

    //@Path("/")
    public void inicio() {

        Session sessao = SecurityUtils.getSubject().getSession();
        login = (Login) sessao.getAttribute("usuarioLogado");

        try {
            
            List<Requisicao> requisicoes = requisicaoService.todos();
            result.include("requisicoes", requisicoes);

        } catch (Exception e) {
            result.include("error", "Deu ruim");

        }
    }

}
