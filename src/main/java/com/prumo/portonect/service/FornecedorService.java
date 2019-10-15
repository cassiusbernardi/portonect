/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import com.prumo.portonect.entity.Fornecedor;
import java.util.List;

/**
 *
 * @author 120000499
 */
public interface FornecedorService {
    
    public List<Fornecedor> todos() throws Exception;
    public Fornecedor porId(Long idFornecedor) throws Exception;
    public Fornecedor salvar(Fornecedor fornecedor) throws Exception;
    public Fornecedor atualizar(Fornecedor fornecedor) throws Exception;
    public Fornecedor porCnpj(String cnpj) throws Exception;
}
