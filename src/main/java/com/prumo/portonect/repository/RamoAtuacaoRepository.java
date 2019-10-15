/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.repository;

import com.prumo.portonect.entity.RamoAtuacao;
import com.prumo.portonect.entity.QRamoAtuacao;

/**
 *
 * @author 120000499
 */
public class RamoAtuacaoRepository extends BaseRepository<RamoAtuacao> {
    
    private QRamoAtuacao ramoAtuacao = QRamoAtuacao.ramoAtuacao;
    
    public RamoAtuacaoRepository() {
        super(RamoAtuacao.class);
    }
    
}
