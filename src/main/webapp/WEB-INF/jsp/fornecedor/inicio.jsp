<%-- 
    Document   : inicio
    Created on : 06/02/2019, 11:37:43
    Author     : 120000499
--%>

<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
        <script src="../js/fornecedor/inicio.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <shiro:hasRole name="FORNECEDOR">
            <input type="hidden" id="msgErro" value="${mensagemErro}" />
            <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">            
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <legend><h1>Cotações</h1></legend>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <fieldset>
                                    <table class="prumo-table-10 table">
                                        <thead>
                                            <tr role="row">
                                                <th style="width: 5%">ID</th>
                                                <th style="width: 40%">Descrição</th>
                                                <th style="width: 20%">Status</th>
                                                <th style="width: 15%">Data Abertura</th>
                                                <th style="width: 15%">Data Encerramento</th>
                                                <th style="width: 5%">Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${prs}" var="pr">
                                                <tr>
                                                    <td>${pr.requisicao.idRequisicao}</td>
                                                    <td>${pr.requisicao.descricao}</td>
                                                    <td>${pr.requisicao.statusRequisicao.descricao}</td>                                                    
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${pr.requisicao.dtAberturaProposta}" /></td>
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${pr.requisicao.dtEncerramentoProposta}" /></td>
                                                    <td>
                                                        <a data-toggle="tooltip" data-placement="top" title="Avaliar" style="margin-right: 0px;" onclick="" href="${linkTo[FornecedorController].respostaRequisicao(pr.idParticipanteRequisicao)}">
                                                            <i class="fa fa-edit fa-lg"></i>
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
            </div>
        </shiro:hasRole>
    </jsp:body>

</template:layout>