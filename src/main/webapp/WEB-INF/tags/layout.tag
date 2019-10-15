<%@tag description="Admin page template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="javascript" fragment="true" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="pragma" content="no-cache" />
        <!-- Meta, title, CSS, favicons, etc. -->
        <!--meta charset="utf-8"-->

        <jsp:invoke fragment="head"/>
        <title><fmt:message key="app.titulo"/></title>
        
        <link href="${pageContext.request.contextPath}/template/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/animate.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/style.css" rel="stylesheet">
        <!-- Dropzone -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/dropzone/basic.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/plugins/dropzone/dropzone.css" rel="stylesheet">
        
        <link href="${pageContext.request.contextPath}/template/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/plugins/ladda/ladda-themeless.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/images/favicon.ico" rel="shortcut icon">
        <link href="${pageContext.request.contextPath}/template/css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/manual_install_components/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
        <!--<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">-->
        <link href="${pageContext.request.contextPath}/template/css/plugins/select2/select2.min.css" rel="stylesheet">
        <!-- Chosen -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/chosen/chosen.css" rel="stylesheet">
        <!-- Sweet Alert -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
        <!-- codemirror -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/codemirror/codemirror.css" rel="stylesheet">
        <!-- Toastr Notice -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/toastr/toastr.min.css" rel="stylesheet">
        
        <link href="${pageContext.request.contextPath}/css/portonect.css" rel="stylesheet">

    </head>

    <body class="nav-md">



        <!-- page content -->
        <!--div class="right_col" role="main"-->
        <div id="wrapper">
            <nav class="navbar-default navbar-static-side" role="navigation">
                <template:menuLateral />  		
            </nav>
            <div id="page-wrapper" class="gray-bg">
                <template:topNav />
                <jsp:doBody/>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <!--<footer>
            <div class="pull-right">
                Porto do Açu 
            </div>
            <div class="clearfix"></div>
        </footer>-->
        <!-- /footer content -->
        <!--<div class="modal" id="aguardeModal" data-backdrop="static" data-keyboard="false" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Aguarde...</h4>
                    </div>
                    <div class="modal-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar"
                                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%; height: 40px">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>-->

        <!-- Mainly scripts -->
        <script src="${pageContext.request.contextPath}/template/js/jquery-2.1.1.js"></script>  
        <script src="${pageContext.request.contextPath}/template/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/template/js/plugins/iCheck/icheck.min.js"></script>
        <!-- Sweet alert -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/sweetalert/sweetalert.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/jquery-maskmoney/jquery.maskMoney.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/dataTables/datatables.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/accounting-js/accounting.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/dataTables/numeric-comma.js"></script>
        <!-- Custom and plugin javascript -->
        <script src="${pageContext.request.contextPath}/template/js/inspinia.js"></script>
        
        <script src="${pageContext.request.contextPath}/template/js/plugins/pace/pace.min.js"></script>

        <script src="${pageContext.request.contextPath}/manual_install_components/jquery-mask/jquery.mask.min.js"></script>

        <!-- VISITA WEBM -->
        <script src="${pageContext.request.contextPath}/js/globals.js"></script>
        <script src="${pageContext.request.contextPath}/js/portonect.js"></script>

        <!-- Select2 -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/select2/select2.full.min.js"></script>

        <!-- Chosen -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/chosen/chosen.jquery.js"></script>

        <!-- DropZone -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/dropzone/dropzone.js"></script>
        <!-- codemirror -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/codemirror/codemirror.js"></script>

        <script src="${pageContext.request.contextPath}/template/js/plugins/ladda/spin.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/ladda/ladda.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/ladda/ladda.jquery.min.js"></script>

        <script src="${pageContext.request.contextPath}/template/js/plugins/jquery-ui/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
        <!-- Toastr Notice -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/toastr/toastr.min.js"></script>

        <template:notificacoes />
        <script src="${pageContext.request.contextPath}/js/portonect.js"></script>
        
        <script src="${pageContext.request.contextPath}/js/prumo/util.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/buscaCep.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/datatable.js"></script>
        <jsp:invoke fragment="javascript"/>
    </body>
</html>