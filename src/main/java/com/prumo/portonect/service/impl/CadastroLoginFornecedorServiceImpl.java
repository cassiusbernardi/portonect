/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.PerfilAcesso;
import com.prumo.portonect.entity.PerfilAcessoLogin;
import com.prumo.portonect.entity.PerfilAcessoLoginPK;
import com.prumo.portonect.enums.PerfilAcessoEnum;
import com.prumo.portonect.exception.ErroNegocioException;
import com.prumo.portonect.repository.PerfilAcessoLoginRepository;
import com.prumo.portonect.repository.PerfilAcessoRepository;
import com.prumo.portonect.service.CadastroLoginFornecedorService;
import com.prumo.portonect.service.FornecedorService;
import com.prumo.portonect.service.LoginService;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class CadastroLoginFornecedorServiceImpl implements CadastroLoginFornecedorService {

    @Inject
    LoginService loginService;
    @Inject
    FornecedorService fornecedorService;
    @Inject
    PerfilAcessoLoginRepository perfilAcessoLoginRepository;
    @Inject
    PerfilAcessoRepository perfilAcessoRepository;

    @Override
    public Login cadastrar(Login login, Fornecedor fornecedor) throws Exception {

        Fornecedor fornecedorExistente = fornecedorService.porCnpj(fornecedor.getCnpj());
        Login loginExistente = loginService.porChave(login.getChave(),null);

        if (fornecedorExistente != null || loginExistente != null) {
            throw new ErroNegocioException("Elementos existentes");
        }
        
        fornecedor = fornecedorService.salvar(fornecedor);  
        PerfilAcesso perfilAcesso = perfilAcessoRepository.porId(PerfilAcessoEnum.FORNECEDOR.getPerfilAcesso());
        login = loginService.salvar(login, fornecedor);
        
        PerfilAcessoLoginPK perfilAcessoLoginPK = new PerfilAcessoLoginPK();
        perfilAcessoLoginPK.setIdLogin(login.getIdLogin());
        perfilAcessoLoginPK.setIdPerfilAcesso(perfilAcesso.getIdPerfilAcesso());
        
        PerfilAcessoLogin perfilAcessoLogin = new PerfilAcessoLogin();
        perfilAcessoLogin.setPerfilAcessoLoginPK(perfilAcessoLoginPK);
        perfilAcessoLogin.setLogin(login);
        perfilAcessoLogin.setPerfilAcesso(perfilAcesso);
        
        perfilAcessoLogin = perfilAcessoLoginRepository.adiciona(perfilAcessoLogin);
        
        return login;

    }

}
