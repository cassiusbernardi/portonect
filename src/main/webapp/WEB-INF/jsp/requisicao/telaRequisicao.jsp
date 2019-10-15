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
        <script src="../../js/requisicao/telaRequisicao.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <input type="hidden" id="statusRequisicao" value="${requisicao == null ? null : requisicao.statusRequisicao.idStatusRequisicao}" />
        <input type="hidden" id="msgErro" value="${mensagemErro}" />
        <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />
        <div class="wrapper wrapper-content animated fadeInRight">
            <c:choose>
                <c:when test="${requisicao.idRequisicao == null}">
                    <h2><strong>Nova Cotação</strong></h2>
                </c:when>
                <c:otherwise>
                    <h2 class="m-t-none m-b">
                        <strong>${requisicao.descricao}&nbsp; - &nbsp;</strong><small style="color:blue">${requisicao.statusRequisicao.descricao}</small>
                    </h2>
                </c:otherwise>
            </c:choose>

            <!--<div class="row">            
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <legend><h2>Nova Requisição</h2></legend>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content">


                        </div>
                    </div>
                </div>
            </div>-->
            <div class="ibox ">
                <div class="ibox-content">
                    <form id="formDadosRequisicao" role="form" method="post" action="${linkTo[RequisicaoController].salvarParcial}" >
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
                                <label for="descricaoRequisicaoTxt"><fmt:message key="requisicao.dados.descricao"/></label><span style="color: #f8ac59;">*</span>
                                <input type="text" id="descricaoRequisicaoTxt" value="${requisicao.descricao}" name="requisicao.descricao" class="form-control" required="">

                            </div>
                            <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                                <label for="dataAberturaRequisicaoTxt"><fmt:message key="requisicao.dados.dtAbertura"/></label><span style="color: #f8ac59;">*</span>
                                <input type="text" id="dataAberturaRequisicaoTxt" value="${requisicao.dtAberturaPropostaS}" name="requisicao.dtAberturaPropostaS" class="form-control">
                            </div>
                            <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                                <label for="dataEncerramentoRequisicaoTxt"><fmt:message key="requisicao.dados.dtEncerramento"/></label><span style="color: #f8ac59;">*</span>
                                <input type="text" id="dataEncerramentoRequisicaoTxt" value="${requisicao.dtEncerramentoPropostaS}" name="requisicao.dtEncerramentoPropostaS" class="form-control">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                <button id="salvarParcialBtn" data-toggle="tooltip" title="Hooray!" class="btn btn-primary" type="submit"><i class="fa fa-save"></i> Salvar</button>
                            </div>
                        </div>
                    </form>     
                </div>
            </div>
            <c:if test="${requisicao.idRequisicao != null}">                
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Upload de Arquivos</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form id="downloadAnexoForm" action="${linkTo[AnexoController].downloadDocumento}" method="post" enctype="multipart/form-data" target="_blank">
                            <input type="hidden" id="idAnexoDownload" name="anexo.idAnexo"/>
                        </form>
                        <form id="removerAnexoForm" role="form" method="post" action="${linkTo[AnexoController].removerAnexo}" >
                            <input type="hidden" id="idAnexoRequisicaoRemoverTxt" name="anexo.idAnexo">
                        </form>
                        <form id="dropzoneForm" action="${linkTo[AnexoController].uploadArquivo}" method="post" enctype="multipart/form-data">
                            <input type="hidden" id="idAnexoRequisicaoTxt" value="${requisicao.idRequisicao}" name="anexoRequisicao.idRequisicao">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <label id ="btnUpload" for="uploadArquivo" class="btn btn-outline btn-success">
                                        <i class="fa fa-upload"></i> Upload de documento
                                    </label>
                                    <input id="uploadArquivo" type="file" multiple="" name="arquivos[]" class="btn btn-primary" accept="application/msword, application/vnd.ms-excel,application/pdf" style="display: none;">
                                </div>
                            </div>   
                        </form>
                        <br>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <fieldset>
                                    <table id="anexoRequisicaoTbl" class="prumo-table table table-striped bulk_action">
                                        <thead>
                                            <tr role="row">
                                                <th>ID</th>
                                                <th>Descrição</th>
                                                <th>Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${anexos}" var="anexo">
                                                <tr>
                                                    <td>${anexo.idAnexo}</td>
                                                    <td>${anexo.nome}</td>
                                                    <td>
                                                        <a data-toggle="tooltip" data-placement="top" title="Download" style="margin-right: 0px;" onclick="downloadAnexo('${anexo.idAnexo}')">
                                                            <i class="fa fa-download fa-lg"></i>
                                                        </a>
                                                        <c:if test="${requisicao.statusRequisicao.idStatusRequisicao == 1}">
                                                            <a data-toggle="tooltip" data-placement="top" title="Excluir" style="margin-right: 0px;" onclick="removerAnexo('${anexo.idAnexo}')" href="JavaScript:removerAnexo('${anexo.idAnexo}')">
                                                                <i class="glyphicon glyphicon-trash fa-lg"></i>
                                                            </a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>                                            
                                        </tbody>
                                    </table>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Cadastro de Itens</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form id="removerItemForm" role="form" method="post" action="${linkTo[RequisicaoController].removerItem}" >
                            <input type="hidden" id="idItemRequisicaoRemoverTxt" name="itemRequisicao.idItemRequisicao">
                        </form>

                        <div id="adicionarItemDiv" class="row">
                            <div class="form-group col-md-6 col-sm-6 col-xs-12">
                                <label for="descricaoItemRequisicaoTxt"><fmt:message key="requisicao.dados.descricao"/></label><span style="color: #f8ac59;">*</span>
                                <input type="text" placeholder=""  id="descricaoItemRequisicaoTxt" value="${itemRequisicao.descricao}" name="itemRequisicao.descricao" class="form-control">
                            </div>                            
                            <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                <label for="quantidadeItemRequisicaoTxt"><fmt:message key="itemRequisicao.dados.quantidade"/></label><span style="color: #f8ac59;">*</span>
                                <input type="text" id="quantidadeItemRequisicaoTxt" value="${itemRequisicao.quantidade}" name="itemRequisicao.quantidade" class="form-control">
                            </div>                            
                            <div class="form-group col-md-3 col-sm-3 col-xs-12">
                                <label for="unidadeItemRequisicaoTxt"><fmt:message key="itemRequisicao.unidade.unidade"/></label><span style="color: #f8ac59;">*</span>
                                <select data-placeholder="Escolha a unidade..." class="form-control" id="unidadeItemRequisicaoTxt" name="itemRequisicao.unidade.idUnidade">
                                    <option value="" disabled="" selected="">Selecione...</option>
                                    <c:forEach items="${unidades}" var="unidade">
                                        <option value="${unidade.idUnidade}">${unidade.descricao}</option>
                                    </c:forEach>
                                </select>
                            </div>                            
                        </div>
                        <div class="row">    
                            <div class="form-group col-md-2 col-sm-2 col-xs-12">
                                <button id="salvarItemRequisicaoBtn" class="btn btn-success" type="button" onclick="salvarItemRequisicao()"><i class="fa fa-plus"></i> Adicionar</button>
                            </div>
                        </div>   
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-content">
                                        <fieldset>
                                            <table id="itemRequisicaoTbl" class="prumo-table table table-striped bulk_action">
                                                <thead>
                                                    <tr role="row">
                                                        <th style="width: 5%">ID</th>
                                                        <th style="width: 18%">Descrição</th>
                                                        <th style="width: 18%">Quantidade</th>
                                                        <th style="width: 18%">Unidade</th>
                                                        <th style="width: 5%">Ação</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${itemsRequisicao}" var="item">
                                                        <tr>
                                                            <td>${item.idItemRequisicao}</td>
                                                            <td>${item.descricao}</td>
                                                            <td>${item.quantidade}</td>
                                                            <td>${item.unidade.descricao}</td>
                                                            <td>
                                                                <c:if test="${requisicao.statusRequisicao.idStatusRequisicao == 1}">
                                                                    <a data-toggle="tooltip" data-placement="top" title="Excluir" style="margin-right: 0px;" onclick="removerItemRequisicao('${item.idItemRequisicao}')" href="JavaScript:removerItemRequisicao('${item.idItemRequisicao}')">
                                                                        <i class="glyphicon glyphicon-trash fa-lg"></i>
                                                                    </a>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>                                            
                                                </tbody>
                                            </table>
                                        </fieldset>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Seleção de Fornecedores</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form id="removerParticipanteForm" role="form" method="post" action="${linkTo[RequisicaoController].removerParticipante}" >
                            <input type="hidden" id="idParticipanteRequisicaoRemoverTxt" name="participanteRequisicao.idParticipanteRequisicao">
                        </form>
                        <form id="formAdicionarParticipante" role="form" method="post" action="${linkTo[RequisicaoController].adicionarParticipante}">
                            <input type="hidden" id="participanteRequisicaoReqTxt" name="req.idRequisicao" value="${requisicao.idRequisicao}" />
                            <div id="adicionarFornecedorDiv" class="row">
                                <div class="form-higroup col-md-12 col-sm-12 col-xs-12">
                                    <label for="participanteRequisicaoTxt"><fmt:message key="requisicao.dados.fornecedor"/></label><span style="color: #f8ac59;">*</span>
                                    <select id="participanteRequisicaoTxt" onchange="habilitaBtnFornecedor()" name="participantesRequisicao[].fornecedor.idFornecedor" class="select2_demo_2 form-control" multiple="multiple">
                                        <c:forEach items="${fornecedores}" var="fornecedor">
                                            <option value="${fornecedor.idFornecedor}">${fornecedor.nome}</option>
                                        </c:forEach>
                                    </select>
                                </div>                              
                            </div>
                            <br>
                            <div class="row">    
                                <div class="form-group col-md-2 col-sm-2 col-xs-12">
                                    <button id="salvarBtn" class="btn btn-success" type="submit" disabled=""><i class="fa fa-plus"></i> Adicionar</button>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-content">
                                        <fieldset>
                                            <table id="itemRequisicaoTbl" class="prumo-table table table-striped bulk_action">
                                                <thead>
                                                    <tr role="row">
                                                        <th style="width: 5%">ID</th>
                                                        <th style="width: 18%">CNPJ</th>
                                                        <th style="width: 18%">Nome</th>
                                                        <th style="width: 5%">Ação</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${participantes}" var="participante">
                                                        <tr>
                                                            <td>${participante.idParticipanteRequisicao}</td>
                                                            <td>${participante.fornecedor.cnpj}</td>
                                                            <td>${participante.fornecedor.nome}</td>
                                                            <td>
                                                                <c:if test="${requisicao.statusRequisicao.idStatusRequisicao == 1}">
                                                                    <a data-toggle="tooltip" data-placement="top" title="Excluir" style="margin-right: 0px;" onclick="removerParticipanteRequisicao('${participante.idParticipanteRequisicao}')" href="JavaScript:removerParticipanteRequisicao('${participante.idParticipanteRequisicao}')">
                                                                        <i class="glyphicon glyphicon-trash fa-lg"></i>
                                                                    </a>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>                                            
                                                </tbody>
                                            </table>
                                        </fieldset>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row text-right" style="padding-top: 20px">
                    <form id="enviarRequisicaoForm" role="form" method="post" action="${linkTo[RequisicaoController].enviarRequisicao}">
                        <input type="hidden" id="idRequisicaoEnviarRequisicaoTxt" name="requisicao.idRequisicao">
                        <div class="col-sm-12">
                            <button type="button" id="btnSolAgendamento" class="btn btn-primary pull-right" onclick="enviarRequisicao()" ><fmt:message key="requisicao.dados.enviar"/></button>
                        </div>
                    </form>
                </div>
            </c:if>
        </div>
        <%@include file="../modal/modalProcessando.jsp" %>
    </jsp:body>

</template:layout>
