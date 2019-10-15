/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service;

import java.util.List;
import org.apache.commons.mail.ImageHtmlEmail;

/**
 *
 * @author 120000499
 */

public interface EmailService {

    public void enviarEmail(List<String> destinatarios, List<String> copias, String textoEmail, String tituloEmail) throws Exception;

    public void enviarEmail(List<String> destinatarios, List<String> copias, ImageHtmlEmail email, String tituloEmail) throws Exception;
}
