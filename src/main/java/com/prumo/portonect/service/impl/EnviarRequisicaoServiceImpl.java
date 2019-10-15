/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.service.impl;

import com.prumo.portonect.entity.ItemRequisicao;
import com.prumo.portonect.entity.ItemVersao;
import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.ParticipanteRequisicao;
import com.prumo.portonect.entity.Requisicao;
import com.prumo.portonect.entity.StatusRequisicao;
import com.prumo.portonect.enums.StatusRequisicaoEnum;
import com.prumo.portonect.service.EmailService;
import com.prumo.portonect.service.EnviarRequisicaoService;
import com.prumo.portonect.service.ItemRequisicaoService;
import com.prumo.portonect.service.ItemVersaoService;
import com.prumo.portonect.service.ParticipanteRequisicaoService;
import com.prumo.portonect.service.RequisicaoService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.mail.ImageHtmlEmail;

/**
 *
 * @author 120000499
 */
public class EnviarRequisicaoServiceImpl implements EnviarRequisicaoService {

    @Inject
    private RequisicaoService requisicaoService;
    @Inject
    private ParticipanteRequisicaoService participanteRequisicaoService;
    @Inject
    private EmailService emailService;
    @Inject
    private ItemRequisicaoService itemRequisicaoService;
    @Inject
    private ItemVersaoService itemVersaoService;

    @Override
    public void enviar(Requisicao requisicao) throws Exception {

        requisicao = requisicaoService.porId(requisicao.getIdRequisicao());

        try {

            List<ParticipanteRequisicao> participantes = participanteRequisicaoService.porRequisicao(requisicao);

            List<String> destinatariosVisitante = new ArrayList();

            for (ParticipanteRequisicao participante : participantes) {

                List<ItemRequisicao> itensRequisicao = itemRequisicaoService.porRequisicao(requisicao);
                for (ItemRequisicao itemReq : itensRequisicao) {

                    ItemVersao itemVersao = new ItemVersao();
                    itemVersao.setParticipanteRequisicao(participante);
                    itemVersao.setItemRequisicao(itemReq);
                    itemVersao.setVersao(1);

                    itemVersaoService.salvar(itemVersao);

                }

                for (Login login : participante.getFornecedor().getLogins()) {
                    destinatariosVisitante.add(login.getEmail());
                }
//            String horaInicioVisitante = new SimpleDateFormat("HH:mm").format(agendamento.getDataInicioVisita());
//            String dataInicioVisitante = new SimpleDateFormat("dd-MM-yyyy").format(agendamento.getDataInicioVisita());
//
//            String horaFimVisitante = new SimpleDateFormat("HH:mm").format(agendamento.getDataFimVisita());
//            String dataFimVisitante = new SimpleDateFormat("dd-MM-yyyy").format(agendamento.getDataFimVisita());
//
                ImageHtmlEmail email = new ImageHtmlEmail();
//            String cidPrumo = email.embed(new File(context.getRealPath("/images") + "/logo_porto_160x124.jpg"));
//            String cidQrCode = email.embed(new File(PropertiesUtil.getQrCodePath() + "\\" + agendamentoVisitante.getQrCode() + "." + PropertiesUtil.getQrCodeExtensao()));

//            URL url = new URL(PropertiesUtil.getUrlPorto());
//            email.setDataSourceResolver(new DataSourceUrlResolver(url));
                String htmlEmailTemplate = "<html>"
                        + "<a>"
                        + "Prezado, <br>A PORTO DO AÇU convida vossa empresa a participar do processo de compra <b>" + requisicao.getDescricao() + "</b>,"
                        + "com previsão de término de envio das propostas em " + requisicao.getDtEncerramentoPropostaS() + "."
                        + "<br>"
                        + "Acesse wwww.portodoacu.com.br para responder este processo. Quando você clicar nesse link, acesse com seu nome de usuário e senha. Se você esqueceu seu nome de usuário ou senha e não consegue acessar,"
                        + " redefina em wwww.portodoacu.com.br<br><br>"
                        + "Em caso de duvidas, entre em contato com " + requisicao.getLogin().getNome() + " pelo número (22)2133-1100 ou pelo e-mail " + requisicao.getLogin().getEmail() + ".<br>"
                        + "Estamos ansiosos para trabalhar com você!<br><br>"
                        + "Obrigado,<br><br>"
                        + requisicao.getLogin().getNome()
                        + "</a>"
                        + "</html>";

                email.setHtmlMsg(htmlEmailTemplate);
                String tituloEmail = "Porto açu - Convite Licitação";
                emailService.enviarEmail(destinatariosVisitante, null, email, tituloEmail);
            }

            StatusRequisicao statusRequisicao = new StatusRequisicao();
            statusRequisicao.setIdStatusRequisicao(StatusRequisicaoEnum.AGUARDANDO_COTACAO.getStatusRequisicao());
            requisicao.setStatusRequisicao(statusRequisicao);
            requisicao = requisicaoService.atualizar(requisicao);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
