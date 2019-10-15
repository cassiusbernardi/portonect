<%-- 
    Document   : wrapper
    Created on : 06/02/2019, 08:52:22
    Author     : alan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="menu lateral template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"     prefix="fn" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <c:if
                    test="${pageContext.request.serverName.equals('localhost')}">
                    <span class="block m-t-xs" style="color: #f8ac59;position: absolute;top: 0;left: 2px;font-size: xx-small;"> <strong
                            class="font-bold">Desenvolvimento</strong>
                    </span>
                </c:if> 
                <c:if
                    test="${pageContext.request.serverName.equals('plutaodes')}">
                    <span class="block m-t-xs" style="color: #f8ac59;position: absolute;top: 0;left: 2px;font-size: xx-small;"> <strong
                            class="font-bold">Teste</strong>
                    </span>
                </c:if> 
                <c:if
                    test="${pageContext.request.serverName.equals('plutao')}">
                    <span class="block m-t-xs" style="color: #f8ac59;position: absolute;top: 0;left: 2px;font-size: xx-small;"> <strong
                            class="font-bold">Homologação</strong>
                    </span>
                </c:if> 
                <%-- <c:if
                        test="${pageContext.request.serverName.equals('crmmd')}">
                        <span class="block m-t-xs" style="color: #f8ac59;position: absolute;top: 0;left: 2px;font-size: xx-small;"> <strong
                                class="font-bold">Produção</strong>
                        </span>
                </c:if> --%>
                <div class="dropdown profile-element"> 

                    <span>
                        <img alt="image" src="${pageContext.request.contextPath}/images/user.jpg"  />
                    </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear"> 
                            <span class="block m-t-xs"> 
                                <strong class="font-bold">${usuarioMenu.email}</strong></b>
                            </span> 
                            <span class="text-muted text-xs block">
                                Menu<b class="caret"></b>
                            </span>
                        </span> 
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="${linkTo[UsuarioController].editaUsuarioLogado}">Alterar Senha</a></li>
                        <li class="divider"></li>
                        <li><a class="logout" href="${linkTo[LoginController].logout}">Sair</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    VSW
                </div>
            </li>
            <!--  Use class="active" para deixar um menu aberto -->
            <!-- <li class="active"> -->
            <%--  <li>
                     <a href="${pageContext.request.contextPath}/" title="Meus Agendamentos" ><i class="fa fa-book"></i> <span class="nav-label">Incio</span></a>
             </li> --%>
            <shiro:hasRole name="SUPRIMENTO">            
                <li>
                    <a href="${pageContext.request.contextPath}/inicio/inicio" title="Dashboard" ><i class="fa fa-home fa-lg"></i> <span class="nav-label">Cotações</span></a>
                </li>
                <!--<li>
                    <a href="${linkTo[GestaoFornecedorController].gestaoFornecedor}"><i class="fa fa-building-o fa-lg"></i> <span class="nav-label">Fornecedores</span></a>
                </li>-->
            </shiro:hasRole>
            <shiro:hasRole name="FORNECEDOR">
                <li>
                    <a href="${pageContext.request.contextPath}/fornecedor/inicio" title="Dashboard" ><i class="fa fa-home fa-lg"></i> <span class="nav-label">Cotações</span></a>
                </li>
            </shiro:hasRole>
            <!--<li>
                <a href="${pageContext.request.contextPath}/cadastro/administrador/cliente" title="Relatórios" ><i class="fa fa-bar-chart-o fa-lg"></i> <span class="nav-label">Relatórios</span></a>
            </li>-->

        </ul>
    </div>
</nav>