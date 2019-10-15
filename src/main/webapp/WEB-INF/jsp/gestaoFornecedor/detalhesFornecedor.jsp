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
        <script src="../js/gestaoFornecedor/gestaoFornecedor.js?${ts}" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>
        <shiro:hasRole name="SUPRIMENTO">
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">            
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <legend><h1>Fornecedores</h1></legend>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <label for="txtNome" class="control-label"><fmt:message key="cadastroFornecedor.texto.nome"/>
                                        <input type="text" id="txtNomeFornecedor" class="form-control" name="fornecedor.nome" value="${fornecedor.nome}" required/>
                                    </div>                            
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <label for="txtNumeroDocumento" class="control-label"><fmt:message key="cadastroFornecedor.texto.razaoSocial"/>
                                        <input required="required" type="text" id="txtRazaoSocialFornecedor" class="form-control" name="fornecedor.razaoSocial" value="${fornecedor.razaoSocial}" />
                                    </div>
                                    <div class="form-group col-md-4 col-sm-4 col-xs-12">
                                        <label for="txtNumeroDocumento" class="control-label"><fmt:message key="cadastroFornecedor.texto.numeroDocumento"/>
                                        <input required="required" onchange="verificaCnpj()" type="text" id="txtNumeroDocumentoFornecedor" class="form-control cnpj" name="fornecedor.cnpj" value="${fornecedor.cnpj}" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                    
            </div>
        </shiro:hasRole>
    </jsp:body>

</template:layout>