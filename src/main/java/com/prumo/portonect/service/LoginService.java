/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.Login;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface LoginService {
    
    public Login porChave(String chave,Boolean tipoLogin) throws Exception;
    public List<Login> todos() throws Exception;
    public Login salvar(Login login, Fornecedor fornecedor) throws Exception;
    
}
