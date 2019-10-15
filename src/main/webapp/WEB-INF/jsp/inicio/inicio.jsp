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
        <script src="../js/inicio/inicio.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <shiro:hasRole name="SUPRIMENTO">
            <input type="hidden" id="msgErro" value="${mensagemErro}" />
            <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">            
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <legend><h1>Cotação</h1></legend>
                    </div>
                </div>
                <div class="row">            
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <a href="${linkTo[RequisicaoController].telaRequisicao(0)}" class="btn btn-success btn-circle" type="button" data-toggle="tooltip" data-placement="top" title="" data-original-title="Criar Requisição"><i class="fa fa-plus"></i></a>
                        <label>Nova Cotação</label>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <fieldset>
                                    <table class="prumo-table-10 table">
                                        <thead>
                                            <tr role="row">
                                                <th style="width: 5%">ID</th>
                                                <th style="width: 18%">Descrição</th>
                                                <th style="width: 18%">Data Abertura</th>
                                                <th style="width: 18%">Data Encerramento</th>
                                                <th style="width: 18%">Status</th>
                                                <th style="width: 18%">Analista</th>
                                                <th style="width: 5%">Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requisicoes}" var="requisicao">
                                                <tr>
                                                    <td>${requisicao.idRequisicao}</td>
                                                    <td>${requisicao.descricao}</td>
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${requisicao.dtAberturaProposta}" /></td>
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${requisicao.dtEncerramentoProposta}" /></td>
                                                    <td>${requisicao.statusRequisicao.descricao}</td>
                                                    <td>${requisicao.login.nome}</td>
                                                    <td>
                                                        <a data-toggle="tooltip" data-placement="top" title="Editar" onclick="" href="${linkTo[RequisicaoController].telaRequisicao(requisicao.idRequisicao)}">
                                                            <i class="fa fa-edit fa-lg"></i>
                                                        </a>&nbsp;
                                                        <c:if test="${requisicao.statusRequisicao.idStatusRequisicao > 1}">
                                                            <a data-toggle="tooltip" data-placement="top" title="Avaliar" onclick="" href="${linkTo[RequisicaoController].resultadoRequisicao(requisicao.idRequisicao)}">
                                                                <i class="fa fa-tags fa-lg"></i>
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
        </shiro:hasRole>

        
    </jsp:body>

</template:layout>