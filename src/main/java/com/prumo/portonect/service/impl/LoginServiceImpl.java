/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.repository.LoginRepository;
import com.prumo.portonect.service.LoginService;
import com.prumo.portonect.util.CipherUtil;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginRepository loginRepository;

    public LoginServiceImpl() {
        this(null);
    }

    @Inject
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login porChave(String chave,Boolean tipoLogin) throws Exception {
        Login loginCadastrado = loginRepository.porUsuario(chave,tipoLogin);
//        if (loginCadastrado == null) {
//            throw new Exception("E-Mail não encontrado.");
//        }
        return loginCadastrado;
    }

    @Override
    public List<Login> todos() throws Exception {
        return loginRepository.todos();
    }

    @Override
    public Login salvar(Login login, Fornecedor fornecedor) throws Exception {

        String senha = login.getSenha();
        senha = CipherUtil.encodeSHA256(senha);
        login.setSenha(senha);
        login.setFornecedor(fornecedor);
        login.setAtivo(true);
        login = loginRepository.salvar(login);

        return login;
    }

}
