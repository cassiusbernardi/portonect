<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.prumo.portonect.util.PropertiesUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PortoNect - Login</title>
    <link href="${pageContext.request.contextPath}/template/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/template/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/template/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/template/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/manual_install_components/bootstrap-form-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
    <!-- Toastr Notice -->
    <link href="${pageContext.request.contextPath}/template/css/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="loginColumns animated fadeInDown">
        <div class="row">
            <div class="col-md-6">
                <div>
                    <img src="images/logo_porto_transparente.png" width="60%" class="img-responsive center-block " />
                </div>
                <h2 class="font-bold text-center"><fmt:message key="login.texto.titulo"/></h2>
                <p class="text-center">
                    <fmt:message key="login.texto.credencial"/>
                </p>

            </div>
            <div class="col-md-6">
                <div class="ibox-content">
                    <form id="logarForm" class="m-t" role="form" method="post" action="${linkTo[LoginController].logar}">
                        <div class="form-group">
                            <input type="text" class="form-control" id="emailUsuario" name="login" placeholder="E-Mail" required="">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="senha" placeholder="Senha" required="">
                        </div>
                        <button id="btnLogin" type="submit" class="btn btn-primary block full-width m-b">Login</button>
                        <!--a href="Javascript:recuperarSenha()">
                            <small><fmt:message key="login.texto.esqueci.senha"/></small>
                        </a-->
                        <p class="text-muted text-center">
                            <small>&nbsp;</small>
                        </p>
                        <a class="btn btn-sm btn-white btn-block" href="${linkTo[CadastroFornecedorController].cadastroFornecedor}"><fmt:message key="login.texto.novoUsuario"/></a>
                    </form>
                </div>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-6 text-right">
                <small>TI - Porto do Açu © 2019</small>
            </div>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/template/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/template/js/bootstrap.min.js"></script>
    <!-- Toastr Notice -->
    <script src="${pageContext.request.contextPath}/template/js/plugins/toastr/toastr.min.js"></script>

    <script src="${pageContext.request.contextPath}/manual_install_components/bootstrap-form-helpers/js/bootstrap-formhelpers.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/js/login/login.js"></script>

    <template:notificacoes />

</body>
</html>

