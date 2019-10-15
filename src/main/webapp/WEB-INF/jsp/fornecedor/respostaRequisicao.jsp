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
        <script src="../../js/fornecedor/respostaRequisicao.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <input type="hidden" id="editavel" value="${editavel}" />
        <input type="hidden" id="msgErro" value="${mensagemErro}" />
        <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />
        <div class="wrapper wrapper-content animated fadeInRight">
            <h2 class="m-t-none m-b">
                <strong>${participanteRequisicao.requisicao.descricao}&nbsp; - &nbsp;</strong>
                <small style="color:blue">${participanteRequisicao.requisicao.statusRequisicao.descricao}</small>
            </h2>
            <div class="ibox ">
                <div class="ibox-content">
                    <div class="row">
                        <div class="form-group col-md-2 col-sm-2 col-xs-12">
                            <label for="idRequisicaoTxt"><fmt:message key="requisicao.dados.id"/></label>
                            <input type="text" placeholder=""  id="idRequisicaoTxt" value="${participanteRequisicao.requisicao.idRequisicao}" name="requisicao.idRequisicao" class="form-control " readonly="">
                        </div>                            
                        <div class="form-group col-md-4 col-sm-4 col-xs-12">
                            <label for="analistaRequisicaoTxt"><fmt:message key="requisicao.dados.login"/></label>
                            <input type="text" id="analistaRequisicaoTxt" value="${login.nome}" name="requisicao.login.nome" class="form-control" disabled="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6 col-sm-6 col-xs-12">
                            <label for="descricaoRequisicaoTxt"><fmt:message key="requisicao.dados.descricao"/></label><span style="color: #f8ac59;">*</span>
                            <input type="text" id="descricaoRequisicaoTxt" value="${participanteRequisicao.requisicao.descricao}" name="requisicao.descricao" class="form-control" readonly="">

                        </div>
                        <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                            <label for="dataAberturaRequisicaoTxt"><fmt:message key="requisicao.dados.dtAbertura"/></label><span style="color: #f8ac59;">*</span>
                            <input type="text" id="dataAberturaRequisicaoTxt" value="${participanteRequisicao.requisicao.dtAberturaPropostaS}" name="requisicao.dtAberturaPropostaS" class="form-control" readonly="">
                        </div>
                        <div class="form-group col-md-3 col-sm-3 col-xs-12 cmpData">
                            <label for="dataEncerramentoRequisicaoTxt"><fmt:message key="requisicao.dados.dtEncerramento"/></label><span style="color: #f8ac59;">*</span>
                            <input type="text" id="dataEncerramentoRequisicaoTxt" value="${participanteRequisicao.requisicao.dtEncerramentoPropostaS}" name="requisicao.dtEncerramentoPropostaS" class="form-control" readonly="">
                        </div>
                    </div>
                </div>
            </div>            
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>Anexos Suprimentos</h5>
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
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <fieldset>
                                <table id="anexoSuprimentosRequisicaoTbl" class="prumo-table table table-striped bulk_action">
                                    <thead>
                                        <tr role="row">
                                            <th>ID</th>
                                            <th>Descrição</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${participanteRequisicao.requisicao.anexos}" var="anexo">
                                            <tr>
                                                <td>${anexo.idAnexo}</td>
                                                <td>${anexo.nome}</td>
                                                <td>
                                                    <a data-toggle="tooltip" data-placement="top" title="Download" style="margin-right: 0px;" onclick="downloadAnexo('${anexo.idAnexo}')">
                                                        <i class="fa fa-download"></i>
                                                    </a>
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
                    <h5>Itens</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">   
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <form id="itemVersaoForm" action="${linkTo[FornecedorController].registrarValor}" method="post">
                                        <fieldset>
                                            <table id="itemVersaoTbl" class="prumo-table table table-striped bulk_action">
                                                <thead>
                                                    <tr role="row">
                                                        <th style="width: 10%">ID</th>
                                                        <th style="width: 30%">Descrição</th>
                                                        <th style="width: 10%">Unidade</th>
                                                        <th style="width: 10%">Quantidade</th>
                                                        <th style="width: 20%">Valor Unitário</th>
                                                        <th style="width: 20%">Valor Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${itens}" var="item">
                                                        <tr>
                                                            <td>${item.itemRequisicao.idItemRequisicao}</td>
                                                            <td>${item.itemRequisicao.descricao}</td>
                                                            <td>${item.itemRequisicao.unidade.descricao}</td>
                                                            <td>${item.itemRequisicao.quantidade}</td>
                                                            <td>
                                                                <div class="input-group">
                                                                    <input type="hidden" id="participanteRequisicaoSelecionado" name="participanteRequisicao.idParticipanteRequisicao" value="${participanteRequisicao.idParticipanteRequisicao}">
                                                                    <input type="hidden" id="itemSelecionadoId" name="itens[].idItemVersao" value="${item.idItemVersao}">
                                                                    <input type="hidden" id="itemSelecionadoIdParticipanteRequisicao" name="itens[].participanteRequisicao.idParticipanteRequisicao" value="${item.participanteRequisicao.idParticipanteRequisicao}">
                                                                    <input type="hidden" id="itemSelecionadoIdItemRequisicao" name="itens[].itemRequisicao.idItemRequisicao" value="${item.itemRequisicao.idItemRequisicao}">
                                                                    <input type="hidden" id="itemSelecionadoVersao" name="itens[].versao" value="${item.versao}">
                                                                    <span class="input-group-addon"><i class="fa fa-dollar"></i></span>                                                                    
                                                                    <input type="text" class="form-control valorClass" id="itemSelecionadoValor" name="itens[].valor" data-mask="###,###,###.##" value="${item.valor}">
                                                                </div>                                                                
                                                            </td>
                                                            <td>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-dollar"></i></span>                                                                    
                                                                    <input type="text" class="form-control valorClass" id="itemSelecionadoValorTotal" value="<fmt:formatNumber type="number" maxFractionDigits="2" value="${item.valor * item.itemRequisicao.quantidade}" />" readonly="">
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>                                            
                                                </tbody>
                                            </table>
                                        </fieldset>
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <button id="salvarBtn" class="btn btn-primary pull-right"><i class="fa fa-save"></i> Salvar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                    <form id="downloadAnexoParticipanteForm" action="${linkTo[AnexoParticipanteController].downloadDocumento}" method="post" enctype="multipart/form-data" target="_blank">
                        <input type="hidden" id="idAnexoParticipanteDownload" name="anexoParticipante.idAnexo"/>
                    </form>
                    <form id="removerAnexoForm" role="form" method="post" action="${linkTo[AnexoParticipanteController].removerAnexo}" >
                        <input type="hidden" id="idAnexoParticipanteRemoverTxt" name="anexoParticipante.idAnexo">
                    </form>
                    <form id="dropzoneForm" action="${linkTo[AnexoParticipanteController].uploadArquivo}" method="post" enctype="multipart/form-data">                            
                        <input type="hidden" id="idAnexoParticipanteTxt" value="${participanteRequisicao.idParticipanteRequisicao}" name="participanteRequisicao.idParticipanteRequisicao">
                        <input type="hidden" id="tipoAnexoParticipanteRequisicaoTxt" value="" name="tipo.idTipoAnexo">   
                        <div class="row">
                            <!--<div class="form-group col-md-3 col-sm-3 col-xs-12">
                                <label for="unidadeItemRequisicaoTxt"><fmt:message key="itemRequisicao.unidade.unidade"/></label><span style="color: #f8ac59;">*</span>
                                <select data-placeholder="Escolha a unidade..." class="form-control" id="unidadeItemRequisicaoTxt" name="itemRequisicao.unidade.idUnidade" required="">
                                    <option value="" disabled="" selected="">Selecione...</option>
                                    <option value=""></option>
                                </select>
                            </div>
                            <div class="col-md-4 col-sm-4 col-xs-12">
                                <label for="btnUpload">&nbsp;</label>
                                <div class="form-group">
                                    <label id ="btnUpload" for="uploadArquivo" class="btn btn-success">
                                        <i class="fa fa-upload"></i>Upload de documento
                                    </label>
                                    <input id="uploadArquivo" type="file" multiple="" name="arquivos[]" class="btn btn-primary" accept="image/*,application/pdf" style="display: none;">
                                </div>
                            </div>-->
                            <div id="uploadDiv" class="col-md-12 col-sm-12 col-xs-12">

                                <label id ="btnUpload" for="uploadPropostaTecnica" class="btn btn-outline btn-success">
                                    <i class="fa fa-upload"></i> Upload Proposta Tecnica
                                </label>
                                <input id="uploadPropostaTecnica" type="file" multiple="" name="arquivos[]" class="btn btn-primary" onchange="uploadFile(1)" accept="application/msword, application/vnd.ms-excel,application/pdf" style="display: none;">

                                <label id ="btnUpload" for="uploadPropostaComercial" class="btn btn-outline btn-success">
                                    <i class="fa fa-upload"></i> Upload Proposta Comercial
                                </label>
                                <input id="uploadPropostaComercial" type="file" multiple="" name="arquivos[]" class="btn btn-primary" onchange="uploadFile(2)" accept="application/msword, application/vnd.ms-excel,application/pdf" style="display: none;">

                                <!--<label id ="btnUpload" for="uploadArquivo" class="btn btn-outline btn-success">
                                    <i class="fa fa-upload"></i> Upload de documento
                                </label>
                                <input id="uploadArquivo" type="file" multiple="" name="arquivos[]" class="btn btn-primary" accept="image/*,application/pdf" style="display: none;">-->
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
                                            <th>Tipo</th>
                                            <th>Descrição</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${anexosParticipante}" var="anexo">
                                            <tr>
                                                <td>${anexo.idAnexo}</td>
                                                <td>${anexo.tipoAnexoParticipante.descricao}</td>
                                                <td>${anexo.nome}</td>
                                                <td>
                                                    <a data-toggle="tooltip" data-placement="top" title="Download" style="margin-right: 0px;" onclick="downloadAnexoParticipante('${anexo.idAnexo}')">
                                                        <i class="fa fa-download"></i>
                                                    </a>
                                                    <c:if test="${editavel > 0}">
                                                        <a id="removerAnexoParticipanteBtn" data-toggle="tooltip" data-placement="top" title="Excluir" style="margin-right: 0px;" onclick="removerAnexoParticipante('${anexo.idAnexo}')">
                                                            <i class="glyphicon glyphicon-trash"></i>
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
        <%@include file="../modal/modalProcessando.jsp" %>
    </jsp:body>
</template:layout>
