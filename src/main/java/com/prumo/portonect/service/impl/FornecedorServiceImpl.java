/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.repository.FornecedorRepository;
import com.prumo.portonect.service.FornecedorService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> todos() throws Exception {
        return fornecedorRepository.todos();
    }
    
    @Override
    public Fornecedor porId(Long idFornecedor) throws Exception {
        return fornecedorRepository.porId(idFornecedor);
    }

    @Override
    public Fornecedor salvar(Fornecedor fornecedor) throws Exception {
        String cnpj = fornecedor.getCnpj().replace(".","").replace("-", "").replace("/", "");
        fornecedor.setCnpj(cnpj);
        fornecedor.setAtivo(true);
        return fornecedorRepository.adiciona(fornecedor);
    }

    @Override
    public Fornecedor atualizar(Fornecedor fornecedor) throws Exception {
        return fornecedorRepository.atualiza(fornecedor);
    }

    @Override
    public Fornecedor porCnpj(String cnpj) throws Exception {
        cnpj = cnpj.replace(".","").replace("-", "").replace("/", "");
        return fornecedorRepository.porCnpf(cnpj);
    }    

}
