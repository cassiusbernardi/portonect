/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.quartzjob.CronTask;
import com.prumo.portonect.service.EmailService;
import com.prumo.portonect.service.RequisicaoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author 120000499
 */
@Controller
public class RequisicaoJob implements CronTask {
    
    @Inject
    private RequisicaoService requisicaoService;
    @Inject
    private EmailService emailService;
    
    @Override
    @Get
    @Post
    public void execute() {
        
        try {
            
            requisicaoService.encerrarExpiradas();
            
        } catch (Exception e) {
            
            List<String> destinatarios = new ArrayList();
            destinatarios.add("cassius.janoario@portodoacu.com.br");
            String text = "Erro ao encerrar Requisições. Tentativa: " + new Date();
            try {
                emailService.enviarEmail(destinatarios, null, text, "Job PortoNect");
            } catch (Exception ex) {
                Logger.getLogger(RequisicaoJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    @Get
    @Post
    public String frequency() {
//        return "*/10 * * * * ?";
        return "0 0-10 0 * * ?";
    }
}
