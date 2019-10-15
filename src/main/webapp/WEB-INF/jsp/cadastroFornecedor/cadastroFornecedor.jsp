<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <c:if test="${not empty language}">
  <fmt:setLocale value="${language}" scope="session"/>
</c:if> --%> 

<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/template/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/animate.css" rel="stylesheet">
        <!-- Dropzone -->
        <link href="${pageContext.request.contextPath}/template/css/plugins/dropzone/basic.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/plugins/dropzone/dropzone.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/template/css/style.css" rel="stylesheet">
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
    </head>
    <body class="nav-md"> 

        <input type="hidden" id="dlgTitle" value="${alertTitle}"/>

        <div id="wrapper">
            <div id="" class="gray-bg">

                <!-- CONTEÚDO  -->
                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-lg-12">
                        <h2>
                            <fmt:message key="cadastroFornecedor.texto.titulo"/>
                        </h2>
                    </div>
                </div>
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <form id="cadastroFornecedorForm" class="form-horizontal" enctype="multipart/form-data" method="POST"	action="${linkTo[CadastroFornecedorController].salvar}" accept-charset="UTF-8">
                            <input type="hidden" id="URL" name="url" value=""/>
                            <input type="hidden" id="txtLanguage" name="language" value="${language}" />
                            <div class="col-md-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h3>
                                            <fmt:message key="cadastroFornecedor.texto.legenda"/>
                                        </h3>
                                    </div>
                                    <fieldset>
                                        <div class="ibox-content">
                                            <div class="form-group">
                                                <div class="col-md-4 col-sm-4 col-xs-12">
                                                    <label for="txtEmail" class="control-label"><fmt:message key="cadastroFornecedor.texto.email"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" onchange="validaEmail()" type="text" id="txtEmail" name="login.email" value="${login.email}" maxlength="200" class="form-control">
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtConfirmaEmail" class="control-label"><fmt:message key="cadastroFornecedor.texto.confirmaEmail"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" onchange="validaEmail()" type="text" id="txtConfirmaEmail" class="form-control"  maxlength="200"/>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="passSenha" class="control-label"><fmt:message key="cadastroFornecedor.texto.senha"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" onchange="validaSenha()" type="password" id="passSenha" class="form-control" name="login.senha" value="${login.senha}" maxlength="128"/>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtNome" class="control-label"><fmt:message key="cadastroFornecedor.texto.nome"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" type="text" id="txtNome" name="login.nome" value="${login.nome}" maxlength="200" class="form-control" required >
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtChave" class="control-label"><fmt:message key="cadastroFornecedor.texto.login"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" type="text" id="txtChave" class="form-control" name="login.chave" maxlength="200" value="" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="confirmaPassSenha" class="control-label"><fmt:message key="cadastroFornecedor.texto.confirmaSenha"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" onchange="validaSenha()" type="password" id="confirmaPassSenha" class="form-control"  maxlength="128"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="ibox-content">
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label for="txtNomeFornecedor" class="control-label"><fmt:message key="cadastroFornecedor.texto.nome"/><span style="color: #f8ac59;">*</span></label>
                                                    <input type="text" id="txtNomeFornecedor" class="form-control" name="fornecedor.nome" value="${fornecedor.nome}" required/>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtRazaoSocialFornecedor" class="control-label"><fmt:message key="cadastroFornecedor.texto.razaoSocial"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" type="text" id="txtRazaoSocialFornecedor" class="form-control" name="fornecedor.razaoSocial" value="${fornecedor.razaoSocial}" />
                                                </div> 
                                                <div class="col-sm-4">
                                                    <label for="txtNumeroDocumentoFornecedor" class="control-label"><fmt:message key="cadastroFornecedor.texto.numeroDocumento"/><span style="color: #f8ac59;">*</span></label>
                                                    <input required="required" onchange="verificaCnpj()" type="text" id="txtNumeroDocumentoFornecedor" class="form-control cnpj" name="fornecedor.cnpj" value="${fornecedor.cnpj}" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtUfFornecedor" class="control-label"><fmt:message key="cadastroFornecedor.texto.uf"/><span style="color: #f8ac59;">*</span></label>
                                                    <select required="required" data-placeholder="Escolha a unidade..." class="form-control" id="txtUfFornecedor" name="fornecedor.uf" value="${fornecedor.uf}"> 
                                                        <option value="" disabled="" selected="">Selecione...</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtNaturezaJuridica" class="control-label"><fmt:message key="cadastroFornecedor.texto.naturezaJuridica"/><span style="color: #f8ac59;">*</span></label>
                                                    <select required="required" data-placeholder="Escolha a unidade..." class="form-control" id="txtNaturezaJuridica" name="fornecedor.naturezaTributaria.idNaturezaTributaria" value="${fornecedor.naturezaTributaria.idNaturezaTributaria}"> 
                                                        <option value="" disabled="" selected="">Selecione...</option>
                                                        <c:forEach items="${naturezaTributaria}" var="nt">
                                                            <option value="${nt.idNaturezaTributaria}">${nt.descricao}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtRamoAtuacao" class="control-label"><fmt:message key="cadastroFornecedor.texto.ramoAtuacao"/><span style="color: #f8ac59;">*</span></label>
                                                    <select required="required" data-placeholder="Escolha a unidade..." class="form-control" id="txtRamoAtuacao" name="fornecedor.ramoAtuacao.idRamoAtuacao" value="${fornecedor.ramoAtuacao.idRamoAtuacao}"> 
                                                        <option value="" disabled="" selected="">Selecione...</option>
                                                        <c:forEach items="${ramoAtuacao}" var="ra">
                                                            <option value="${ra.idRamoAtuacao}">${ra.descricao}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtRegimeTributario" class="control-label"><fmt:message key="cadastroFornecedor.texto.regimeTributario"/><span style="color: #f8ac59;">*</span></label>
                                                    <select required="required" data-placeholder="Escolha a unidade..." class="form-control" id="txtRegimeTributario" name="fornecedor.regimeTributario" value="${fornecedor.regimeTributario}"> 
                                                        <option value="" disabled="" selected="">Selecione...</option>
                                                        <option value="Lucro Real">Lucro Real</option>
                                                        <option value="Lucro Presumido">Lucro Presumido</option>
                                                        <option value="Simples Nacional">Simples Nacional</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="txtTempoAtividade" class="control-label"><fmt:message key="cadastroFornecedor.texto.tempoAtividade"/><span style="color: #f8ac59;">*</span></label>
                                                    <select required="required" data-placeholder="Escolha a unidade..." class="form-control" id="txtTempoAtividade" name="fornecedor.tempoAtividade" value="${fornecedor.tempoAtividade}"> 
                                                        <option value="" disabled="" selected="">Selecione...</option>
                                                        <option value="Até 6 meses">Até 6 meses</option>
                                                        <option value="Entre 6 meses e 1 ano">Entre 6 meses e 1 ano</option>
                                                        <option value="Entre 1 e 3 anos">Entre 1 e 3 anos</option>
                                                        <option value="Entre 3 e 5 anos">Entre 3 e 5 anos</option>
                                                        <option value="Mais de 5 anos">Mais de 5 anos</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>	
                                </div>
                                <div class="form-group col-sm-12">
                                    <button type="submit" id="btnSalvar" class="btn btn-primary pull-right" style="margin-right: 15px"><i class="fa fa-save" ></i> <fmt:message key="cadastroFornecedor.texto.salvar"/></button>                                     
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- page wrapper -->
        <!-- Mainly scripts --> 
        <script type="text/javascript">
            var mensagem = "<c:out value='${mensagem}'/>";
            var mensagemErro = "<c:out value='${mensagemErro}'/>";
        </script>
        <!-- Mainly scripts -->
        <script src="${pageContext.request.contextPath}/template/js/jquery-2.1.1.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
        <script src="${pageContext.request.contextPath}/manual_install_components/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/template/js/plugins/iCheck/icheck.min.js"></script>

        <script src="${pageContext.request.contextPath}/manual_install_components/sweetalert/js/sweetalert2.min.js"></script>
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
        <!-- Sweet alert -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/sweetalert/sweetalert.min.js"></script>
        <!-- Validate -->
        <script src="${pageContext.request.contextPath}/template/js/plugins/validate/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/portonect.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/util.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/buscaCep.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/datatable.js"></script>
        <script src="${pageContext.request.contextPath}/js/prumo/validadores.js"></script>
        <script src="${pageContext.request.contextPath}/js/cadastroFornecedor/cadastroFornecedor.js"></script>
    </body>
</html>