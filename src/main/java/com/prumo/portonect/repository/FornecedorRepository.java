/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.Fornecedor;
import com.prumo.portonect.entity.QFornecedor;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;

/**
 *
 * @author 120000499
 */
public class FornecedorRepository extends BaseRepository<Fornecedor> {

    private final QFornecedor fornecedor = QFornecedor.fornecedor;

    public FornecedorRepository() {
        super(Fornecedor.class);
    }

    public Fornecedor porCnpf(String cnpj) {
        Fornecedor result;
        try {
            JPAQuery<Fornecedor> subquery = query().selectFrom(fornecedor)
                    .where(fornecedor.cnpj.eq(cnpj));

            result = subquery.fetchOne();
            
        } catch (Exception e) {
            result = null;
        }

        return result;

    }

}
