<%-- 
    Document   : telaRequisicao
    Created on : 16/07/2019, 15:17:30
    Author     : 120000499
--%>

<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%
//JSP code
    long ts = (new Date()).getTime(); //Used to prevent JS/CSS caching
    request.setAttribute("ts", ts);
%>

<template:layout>

    <jsp:attribute name="head">
        <title>Prumo | Home</title>
    </jsp:attribute>
    <jsp:attribute name="javascript">
        <script src="../../js/requisicao/resultadoRequisicao.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <input type="hidden" id="statusRequisicao" value="${requisicao == null ? null : requisicao.statusRequisicao.idStatusRequisicao}" />
        <input type="hidden" id="msgErro" value="${mensagemErro}" />
        <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />

        <form id="downloadAnexoForm" action="${linkTo[AnexoController].downloadDocumento}" method="post" enctype="multipart/form-data" target="_blank">
            <input type="hidden" id="idAnexoDownload" name="anexo.idAnexo"/>
        </form>
        <form id="downloadAnexoParticipanteForm" action="${linkTo[AnexoParticipanteController].downloadDocumento}" method="post" enctype="multipart/form-data" target="_blank">
            <input type="hidden" id="idAnexoParticipanteResultadoDownload" name="anexoParticipante.idAnexo"/>
        </form>

        <div class="wrapper wrapper-content animated fadeInRight">
            <c:choose>
                <c:when test="${requisicao.idRequisicao == null}">
                    <h2><strong>Nova Requisição</strong></h2>
                </c:when>
                <c:otherwise>
                    <h2><strong>${requisicao.descricao}</strong> - <small>${requisicao.statusRequisicao.descricao}</small></h2>
                </c:otherwise>
            </c:choose>
            <div class="ibox ">
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-md-2 col-sm-2 col-xs-12">
                            <label for="idRequisicaoTxt"><fmt:message key="requisicao.dados.id"/></label>
                            <input type="text" placeholder=""  id="idRequisicaoTxt" value="${requisicao.idRequisicao}" name="requisicao.idRequisicao" class="form-control " readonly="">
                        </div>                            
                        <div class="form-group col-md-4 col-sm-4 col-xs-12">
                            <label for="analistaRequisicaoTxt"><fmt:message key="requisicao.dados.login"/></label>
                            <input type="text" id="analistaRequisicaoTxt" value="${login.nome}" name="requisicao.login.nome" class="form-control" disabled="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6 col-sm-6 col-xs-12">
                            <label for="descricaoRequisicaoTxt"><fmt:message key="requisicao.dados.descricao"/></label>
                            <input type="text" id="descricaoRequisicaoTxt" value="${requisicao.descricao}" name="requisicao.descricao" class="form-control" required="">

                        </div>
                        <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                            <label for="dataAberturaRequisicaoTxt"><fmt:message key="requisicao.dados.dtAbertura"/></label>
                            <input type="text" id="dataAberturaRequisicaoTxt" value="${requisicao.dtAberturaPropostaS}" name="requisicao.dtAberturaPropostaS" class="form-control">
                        </div>
                        <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                            <label for="dataEncerramentoRequisicaoTxt"><fmt:message key="requisicao.dados.dtEncerramento"/></label>
                            <input type="text" id="dataEncerramentoRequisicaoTxt" value="${requisicao.dtEncerramentoPropostaS}" name="requisicao.dtEncerramentoPropostaS" class="form-control">
                        </div>
                    </div>  
                </div>
            </div>
            <h3><strong>Anexos</strong></h3>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="tabs-container">                        
                        <ul class="nav nav-tabs" role="tablist">
                            <li><a class="nav-link active" data-toggle="tab" href="#suprimentos">Requisição</a></li>
                                <c:forEach items="${participantesRequisicaoMap}" var="participantes">
                                <li><a class="nav-link" data-toggle="tab" href="#${participantes.key.fornecedor.idFornecedor}">${participantes.key.fornecedor.nome}</a></li>
                                </c:forEach>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" id="suprimentos" class="tab-pane active">
                                <div class="panel-body">
                                    <fieldset>
                                        <table id="anexoSuprimentosTbl" class="prumo-table table table-striped bulk_action">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Nome</th>
                                                    <th >Ação</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${anexos}" var="a">
                                                    <tr>
                                                        <td>${a.idAnexo}</td>
                                                        <td>${a.nome}</td>
                                                        <td>
                                                            <a data-toggle="tooltip" data-placement="top" title="Download" style="margin-right: 0px;" onclick="downloadAnexo('${a.idAnexo}')">
                                                                <i class="fa fa-download fa-lg"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>                                            
                                            </tbody>
                                        </table>
                                    </fieldset>                                    
                                </div>
                            </div>
                            <c:forEach items="${participantesRequisicaoMap}" var="pts">
                                <div role="tabpanel" id="${pts.key.fornecedor.idFornecedor}" class="tab-pane">
                                    <div class="panel-body">
                                        <fieldset>
                                            <table id="table${pts.key.fornecedor.idFornecedor}" class="prumo-table table table-striped bulk_action">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Tipo</th>
                                                        <th>Nome</th>
                                                        <th >Ação</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${pts.value}" var="ap">
                                                        <tr>
                                                            <td>${ap.idAnexo}</td>
                                                            <td>${ap.tipoAnexoParticipante.descricao}</td>
                                                            <td>${ap.nome}</td>
                                                            <td>
                                                                <a data-toggle="tooltip" data-placement="top" title="Download" style="margin-right: 0px;" onclick="downloadParticipanteAnexo('${ap.idAnexo}')">
                                                                    <i class="fa fa-download fa-lg"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>                                            
                                                </tbody>
                                            </table>
                                        </fieldset>                                    
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <h3><strong>Itens</strong></h3>
            <div class="ibox ">
                <div class="ibox-content">   
                    <div class="row">                        
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">                                    
                                    <fieldset>
                                        <c:forEach items="${itensVersaoMap}" var="item">
                                            <div class="ibox collapsed" style="border-top-color: #00a65a;">
                                                <div class="ibox-title">
                                                    <h5>${item.key.descricao} - ${item.key.unidade.descricao} - ${item.key.quantidade}</h5>
                                                    <div class="ibox-tools">
                                                        <a class="collapse-link">
                                                            <i class="fa fa-chevron-up"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="ibox-content">   
                                                    <div class="row">
                                                        <div class="ibox-content">
                                                            <div class="row">
                                                                <c:forEach items="${item.value}" var="itemVersao">
                                                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                                                        <c:if test="${requisicao.statusRequisicao.idStatusRequisicao == 2}">
                                                                            <c:choose>
                                                                                <c:when test="${itemVersao.vencedor}">
                                                                                    <div class="widget style1 navy-bg">
                                                                                        <div class="row">
                                                                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                                                                <i class="fa fa-building fa-5x"></i>
                                                                                            </div>
                                                                                            <div class="col-md-10 col-sm-10 col-xs-12 text-right">
                                                                                                <span>${itemVersao.participanteRequisicao.fornecedor.nome}</span>
                                                                                                <h3 class="font-bold">
                                                                                                    <fmt:setLocale value = "pt-BR"/>
                                                                                                    <fmt:formatNumber value = "${itemVersao.valor}" type = "currency"/>
                                                                                                </h3>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div> 
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <div class="widget style1 red-bg">
                                                                                        <div class="row">
                                                                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                                                                <i class="fa fa-building fa-5x"></i>
                                                                                            </div>
                                                                                            <div class="col-md-10 col-sm-10 col-xs-12 text-right">
                                                                                                <span>${itemVersao.participanteRequisicao.fornecedor.nome}</span>
                                                                                                <h3 class="font-bold">
                                                                                                    <fmt:setLocale value = "pt-BR"/>
                                                                                                    <fmt:formatNumber value = "${itemVersao.valor}" type = "currency"/>
                                                                                                </h3>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:if>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </fieldset>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>

        <%@include file="../modal/modalProcessando.jsp" %>
    </jsp:body>
</template:layout>