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
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.util.CipherUtil;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author 120000499
 */
@Controller
public class LoginController {

    @Inject
    private Result result;

    @Path("/")
    public void login() throws Exception {

        Subject currentUser = SecurityUtils.getSubject();

//        if (currentUser.isAuthenticated()) {
//
//            result.redirectTo(InicioController.class).inicio();
//        }

        if (currentUser.isAuthenticated()) {

            // Redireciona para a página específica
            if (currentUser.hasRole("FORNECEDOR")) {
                result.include("tituloPortal", "Portal do Fornecedor");
                result.redirectTo(FornecedorController.class).inicio();
            } else {
                result.include("tituloPortal", "Portal do Suprimentos");
                result.redirectTo(InicioController.class).inicio();
            }

        }

    }

    @Post("/login")
    public void logar(String login, String senha, String language) throws Exception {
        try {
            String retConfirmCad = "Favor confirmar seu login inserindo o codigo enviado para a caixa de email: ";

            if (language != null && language.equals("en")) {
                retConfirmCad = "Please confirm your login by entering the code sent to the email box: ";
            } else {
                language = "pt";
            }

            result.include("language", language);

            Subject currentUser = SecurityUtils.getSubject();
//            senha = CipherUtil.encodeDES(CipherUtil.WEB_KEY,senha);

            Session sessao = SecurityUtils.getSubject().getSession();

            if (!currentUser.isAuthenticated()) {
                currentUser.login(new UsernamePasswordToken(login, senha));
                Login objLogin = (Login) sessao.getAttribute("usuarioLogado");
//                result.redirectTo(InicioController.class).inicio();
                // Redireciona para a página específica
                if (currentUser.hasRole("FORNECEDOR")) {
                    result.include("tituloPortal", "Portal do Fornecedor");
                    result.redirectTo(FornecedorController.class).inicio();
                } else {
                    result.include("tituloPortal", "Portal do Suprimentos");
                    result.redirectTo(InicioController.class).inicio();
                }
            } else {
                result.redirectTo(InicioController.class).inicio();
            }
        } catch (AuthenticationException | InvalidSessionException e) {
            result.include("error", "Usuário não autenticado");
            result.redirectTo(this).login();
        }

    }

    public void loginInvalido() {

    }

    @Path("/logout")
    public void logout() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        result.redirectTo(this).login();
    }
}
