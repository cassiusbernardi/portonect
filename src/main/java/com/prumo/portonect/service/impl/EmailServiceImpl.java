package com.prumo.portonect.service.impl;

import com.prumo.portonect.service.EmailService;
import com.prumo.portonect.util.PropertiesUtil;
import java.util.List;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import org.apache.commons.mail.ImageHtmlEmail;

public class EmailServiceImpl implements EmailService {

    @Override
    public void enviarEmail(List<String> destinatarios, List<String> copias, String textoEmail, String tituloEmail) throws Exception {

        try {
            Email email = new SimpleEmail();
            email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
            email.setHostName(PropertiesUtil.getEmailServer());
            email.setSmtpPort(PropertiesUtil.getEmailPort());
            email.setFrom(PropertiesUtil.getEmailSender());
            email.setMsg(textoEmail);
            email.setSubject(tituloEmail);

            if ("S".equals(PropertiesUtil.getEmailAutenticar())) {
                email.setSSLOnConnect(true);
                email.setAuthentication(PropertiesUtil.getEmailSenderUser(), PropertiesUtil.getEmailSenderPass());
            } else {
                email.setStartTLSEnabled(true);
            }

            for (String destinatario : destinatarios) {
                email.addBcc(destinatario);
            }

            email.send();

        } catch (EmailException e) {
            String error = e.getMessage();
        }

    }

    @Override
    public void enviarEmail(List<String> destinatarios, List<String> copias, ImageHtmlEmail email, String tituloEmail) throws Exception {

        try {
//			ImageHtmlEmail email = new ImageHtmlEmail();
            email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
            email.setHostName(PropertiesUtil.getEmailServer());
            email.setSmtpPort(PropertiesUtil.getEmailPort());
            email.setFrom(PropertiesUtil.getEmailSender());
//			email.setMsg(textoEmail);
            email.setSubject(tituloEmail);

            if ("S".equals(PropertiesUtil.getEmailAutenticar())) {
                email.setSSLOnConnect(true);
                email.setAuthentication(PropertiesUtil.getEmailSenderUser(), PropertiesUtil.getEmailSenderPass());
            } else {
                email.setStartTLSEnabled(true);
            }

            for (String destinatario : destinatarios) {
                email.addBcc(destinatario);
            }

//            for (String copia : copias) {
//                email.addCc(copia);
//            }

            email.send();

        } catch (EmailException e) {
            String error = e.getMessage();
        }

    }
}
