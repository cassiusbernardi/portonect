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
import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.NaturezaTributaria;
import com.prumo.portonect.entity.RamoAtuacao;
import com.prumo.portonect.exception.ErroNegocioException;
import com.prumo.portonect.service.CadastroLoginFornecedorService;
import com.prumo.portonect.service.FornecedorService;
import com.prumo.portonect.service.LoginService;
import com.prumo.portonect.service.NaturezaTributariaService;
import com.prumo.portonect.service.RamoAtuacaoService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
@Controller
public class CadastroFornecedorController {

    @Inject
    private Result result;
    @Inject
    private CadastroLoginFornecedorService cadastroLoginFornecedorService;
    @Inject
    private NaturezaTributariaService naturezaTributariaService;
    @Inject
    private RamoAtuacaoService ramoAtuacaoService;
    @Inject
    private LoginService loginService;
    private Login login;

    @Path("/cadastro/fornecedor")
    public void cadastroFornecedor() {
        
        try {
            
            List<RamoAtuacao> ramoAtuacao = ramoAtuacaoService.todos();
            List<NaturezaTributaria> naturezaTributaria = naturezaTributariaService.todos();
            
            result.include("ramoAtuacao", ramoAtuacao);
            result.include("naturezaTributaria", naturezaTributaria);
            result.include("login", login);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Post("/cadastro/fornecedor/salvar")
    public void salvar(Login login, Fornecedor fornecedor) {
        
        result.on(Exception.class).redirectTo(this).cadastroFornecedor();
        
        try {
//            Fornecedor fornecedorExistente = fornecedorService.porCnpj(fornecedor.getCnpf());
//            Login loginExistente = loginService.porChave(login.getChave());
//
//            if (fornecedorExistente != null || loginExistente != null) {
//                throw new ErroNegocioException("");
//            }
//            fornecedor = fornecedorService.salvar(fornecedor);
//            login = loginService.salvar(login, fornecedor);
            login = cadastroLoginFornecedorService.cadastrar(login, fornecedor);
            result.redirectTo(LoginController.class).login();
        } catch (ErroNegocioException en) {

            result.include("mensagemNegocio", en.getMessage());

        } catch (Exception e) {
            result.include("login", login);
            result.include("fornecedor", fornecedor);
            result.redirectTo(this).cadastroFornecedor();
        }

    }
}
