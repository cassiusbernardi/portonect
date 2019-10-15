<%-- 
    Document   : wrapper
    Created on : 06/02/2019, 08:52:22
    Author     : alan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="top navigation template" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row border-bottom ">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary-prumo " href="#"><i class="fa fa-bars" ></i> </a>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <!--<li>
                <span class="m-r-sm text-muted welcome-message"><fmt:message key="app.msg.boasvindas"/></span>
            </li>
            <li>
                <fmt:message key="body_head.idioma"/>
            </li>
            <li>

                <form id="formIdioma" action="${pageContext.request.contextPath}/idioma/mudar" method="post">
                    <select id="language" name="language">
                        <c:if test="${language eq 'en'}">
                            <option value="pt"  ><fmt:message key="body_head.idioma.portugues"/></option>
                            <option value="en" selected="selected"><fmt:message key="body_head.idioma.ingles"/></option>
                        </c:if>
                        <c:if test="${language eq 'pt'}">
                            <option value="pt" selected="selected" ><fmt:message key="body_head.idioma.portugues"/></option>
                            <option value="en" ><fmt:message key="body_head.idioma.ingles"/></option>
                        </c:if>	
                    </select>
                </form>
            </li>-->
            <li>
                <a id="btnSair" class="logout" href="${linkTo[LoginController].logout}">
                    <i class="fa fa-sign-out fa-lg" style="color: #610B0B;"></i>Sair <!--fmt:message key="body_head.sair"/-->
                </a>
            </li>
            <li></li>
        </ul>
    </nav>
</div>
<!-- /top navigation -->