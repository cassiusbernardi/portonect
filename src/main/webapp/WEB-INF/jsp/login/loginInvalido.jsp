<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>VisitaWeb - Módulo Agendador</title>
	    <link href="template/css/bootstrap.min.css" rel="stylesheet">
	    <link href="template/font-awesome/css/font-awesome.css" rel="stylesheet">
	    <link href="template/css/animate.css" rel="stylesheet">
	    <link href="template/css/style.css" rel="stylesheet">
	    <link href="css/login.css" rel="stylesheet"> 
	</head>
	<body class="gray-bg">
		<div class="middle-box text-center vertical-center-row">
			<div>
		    	<div class="row">
		   			 <div>
	                	<img src="images/logo_porto_160x124.jpg" class="img-responsive center-block " />
	            	</div>
		   		</div>
		   		<hr>
		       	<div class="row">
		           	<div class="col-md-12 text-center">
		               	<div class="panel panel-default">
		                   	<div class="panel-heading">
		                       	<h3> Dados de acesso incorretos. E-Mail ou senha inválidos.</h3>
		                   	</div>
		                   	<div class="panel-body">
		                       	<a href="JavaScript:toLogin();" style="font-size: 20px ">Clique aqui para tentar novamente.</A>
		                   	</div>
		               	</div>
		           	</div>
		       	</div>
		    </div>   	
	    </div>
	        	
		<!-- Mainly scripts -->
		<script src="${pageContext.request.contextPath}/template/js/jquery-2.1.1.js"></script>
	    <script src="${pageContext.request.contextPath}/template/js/bootstrap.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/scripts-paginas/login/login.js"></script>
	</body>

</html>
