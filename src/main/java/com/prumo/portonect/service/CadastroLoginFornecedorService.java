/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.Login;

/**
 *
 * @author 120000499
 */
public interface CadastroLoginFornecedorService {
    
    public Login cadastrar(Login login, Fornecedor fornecedor) throws Exception;
    
}
