<%-- 
    Document   : telaProjeto
    Created on : 13/03/2019, 10:47:01
    Author     : 120000499
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:layout>

    <jsp:attribute name="head">
        <title>Prumo | Home</title>
    </jsp:attribute>
    <jsp:attribute name="javascript">
        <script src="../../js/projeto/telaProjeto.js" type="text/javascript" charset="UTF-8"></script>
    </jsp:attribute>
    <jsp:body>

        <input type="hidden" id="msgErro" value="${mensagemErro}" />
        <input type="hidden" id="msgSucesso" value="${mensagemSucesso}" />
        <div class="wrapper wrapper-content">
            <br>
            <div class="row">            
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <h1>${projeto.nomeProjeto}</h1>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container" id="tabsContainer">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a class="nav-link" data-toggle="tab" href="#tab-1">Escopo</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-2">Alertas</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-3">Apontamentos</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-4">Custo</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-5">Recursos</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-6">Ordem de Serviço</a></li>
                            <li><a class="nav-link" data-toggle="tab" href="#tab-7">Documentação</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" id="tab-1" class="tab-pane fadeIn active">
                                <div class="panel-body">
                                    <form id="formEditarProjeto" method="post" action="<c:url value='/projeto/salvar'/>" >

                                        <input type="hidden" id="idProjeto" name="projeto.idProjeto" value="${projeto.idProjeto}" />

                                        <fieldset>
                                            <div class="form-group">
                                                <div class="col-lg-6 ">
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <label for="CodigoServiceNowProjeto" class="control-label"><fmt:message key="projeto.texto.codigoServiceNow"/></label>
                                                            <input type="text" id="CodigoServiceNowProjeto" class="form-control" name="projeto.codigoServiceNow" value="${projeto.codigoServiceNow}" disabled=""/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label for="statusProjeto" class="control-label"><fmt:message key="projeto.texto.status"/></label>
                                                            <select id="statusProjeto" class="form-control m-b" name="" >
                                                                <option value=""><fmt:message key="cadastro.selecione"/></option>
                                                                <!--<c:forEach items="${listaStatus}" var="status">
                                                                    <option value="${status.idStatus}" selected="selected">${status.descricao}</option>
                                                                </c:forEach>-->
                                                            </select>                                                        
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <label for="dtEstimadaProjeto" class="control-label"><fmt:message key="projeto.texto.dtEstimada"/></label>
                                                            <input type="text" id="dtEstimadaProjeto" class="form-control" name="projeto.dataEstimadaConclusao" value="${projeto.dataEstimadaConclusao}" disabled=""/>
                                                        </div>

                                                        <!--<div class="col-sm-6">
                                                            <label for="tipoProjeto" class="control-label"><fmt:message key="projeto.texto.tipoProjeto"/><span style="color: #f8ac59;">*</span></label>
                                                            <select required id="tipoProjeto" class="form-control m-b" name="projeto.tipoProjeto" >
                                                                <option value=""><fmt:message key="cadastro.selecione"/></option>
                                                            </select>
                                                        </div>-->
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <label for="qtDiaProjeto" class="control-label"><fmt:message key="projeto.texto.qtDia"/></label>
                                                            <input type="text" id="qtDiaProjeto" class="form-control" name="projeto.prazoDias" value="${projeto.prazoDias}" disabled=""/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label for="areaProjeto" class="control-label"><fmt:message key="projeto.texto.area"/><span style="color: #f8ac59;">*</span></label>
                                                            <select  id="areaProjeto" class="form-control m-b" name="projeto.area.idArea" >
                                                                <option value="" disabled=""><fmt:message key="cadastro.selecione"/></option>
                                                                <c:forEach items="${areas}" var="area">
                                                                    <option value="${area.idArea}" <c:if test="${projeto.area.idArea == area.idArea}"> selected="selected" </c:if>>${area.nomeArea}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <label for="custoPrevistoProjeto" class="control-label"><fmt:message key="projeto.texto.custoPrevisto"/></label>
                                                            <input type="text" id="custoPrevistoProjeto" class="form-control" name="projeto.custoPrevisto" value="${projeto.custoPrevisto}" disabled=""/>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label for="custoRealizadoProjeto" class="control-label"><fmt:message key="projeto.texto.vlCustoRealizado"/></label>
                                                            <input required="required" type="text" id="custoRealizadoProjeto" class="form-control" name="" value="" disabled=""/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <div class="row">
                                                        <div class="col-sm-12">
                                                            <label for="escopoProjeto" class="control-label"><fmt:message key="projeto.texto.escopo"/><span style="color: #f8ac59;">*</span></label>
                                                            <textarea required class="form-control" id="escopoProjeto" placeholder="<fmt:message key="projeto.place.escopo"/>"  name="projeto.escopo.descricao"  rows="5" >${projeto.escopo.descricao}</textarea>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-sm-12">
                                                            <label for="txtNumeroDocumento" class="control-label"><fmt:message key="projeto.texto.objetivo"/><span style="color: #f8ac59;">*</span></label>
                                                            <textarea required class="form-control" id="motivoAgendamento" placeholder="<fmt:message key="projeto.place.objetivo"/>"  name="projeto.escopo.objetivo"  rows="5" >${projeto.escopo.objetivo}</textarea>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col-sm-12">
                                                            <label for="txtNumeroDocumento" class="control-label"><fmt:message key="projeto.texto.risco"/><span style="color: #f8ac59;">*</span></label>
                                                            <textarea required class="form-control" id="motivoAgendamento" placeholder="<fmt:message key="projeto.place.risco"/>"  name="projeto.escopo.risco"  rows="5" >${projeto.escopo.risco}</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row text-left">
                                                <div class="col-sm-12">
                                                    <div class="form-group col-sm-4">
                                                        <button id="btnSalvar" type="submit" class="btn btn-primary"><fmt:message key="projeto.dados.salvar"/></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                            <div role="tabpanel" id="tab-2" class="tab-pane">
                                <div class="panel-body col-lg-9">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="ibox">
                                                <div class="ibox-content">
                                                    <h3>Para Fazer</h3>
                                                    <p class="small"><i class="fa fa-hand-o-up"></i> Drag task between list</p>

                                                    <div class="input-group">
                                                        <input type="text" placeholder="Add new task. " class="input form-control-sm form-control">
                                                        <span class="input-group-btn">
                                                            <button type="button" class="btn btn-sm btn-white"> <i class="fa fa-plus"></i> Add task</button>
                                                        </span>
                                                    </div>

                                                    <ul class="sortable-list connectList agile-list ui-sortable" id="todo">

                                                        <li class="warning-element ui-sortable-handle" id="task1" style="">
                                                            Simply dummy text of the printing and typesetting industry.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 12.10.2015
                                                            </div>
                                                        </li><li class="success-element ui-sortable-handle" id="task2">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="info-element ui-sortable-handle" id="task3">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="danger-element ui-sortable-handle" id="task4">
                                                            All the Lorem Ipsum generators
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-primary">Done</a>
                                                                <i class="fa fa-clock-o"></i> 06.10.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task5">
                                                            Which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task6">
                                                            Packages and web page editors now use Lorem Ipsum as
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-primary">Done</a>
                                                                <i class="fa fa-clock-o"></i> 08.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task7">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="info-element ui-sortable-handle" id="task8">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="ibox">
                                                <div class="ibox-content">
                                                    <h3>Em Andamento</h3>
                                                    <p class="small"><i class="fa fa-hand-o-up"></i> Drag task between list</p>
                                                    <ul class="sortable-list connectList agile-list ui-sortable" id="inprogress">
                                                        <li class="success-element ui-sortable-handle" id="task9">
                                                            Quisque venenatis ante in porta suscipit.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 12.10.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task10">
                                                            Phasellus sit amet tortor sed enim mollis accumsan in consequat orci.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task11">
                                                            Nunc sed arcu at ligula faucibus tempus ac id felis. Vestibulum et nulla quis turpis sagittis fringilla.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task12">
                                                            Ut porttitor augue non sapien mollis accumsan.
                                                            Nulla non elit eget lacus elementum viverra.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="info-element ui-sortable-handle" id="task13">
                                                            Packages and web page editors now use Lorem Ipsum as
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-primary">Done</a>
                                                                <i class="fa fa-clock-o"></i> 08.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task14">
                                                            Quisque lacinia tellus et odio ornare maximus.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="danger-element ui-sortable-handle" id="task15">
                                                            Enim mollis accumsan in consequat orci.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 11.04.2015
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="ibox">
                                                <div class="ibox-content">
                                                    <h3>Completo</h3>
                                                    <p class="small"><i class="fa fa-hand-o-up"></i> Drag task between list</p>
                                                    <div class="input-group">
                                                        <input type="text" placeholder="Add new task. " class="input form-control-sm form-control">
                                                        <span class="input-group-btn">
                                                            <button type="button" class="btn btn-sm btn-white"> <i class="fa fa-plus"></i> Add Alerta</button>
                                                        </span>
                                                    </div>
                                                    <ul class="sortable-list connectList agile-list ui-sortable" id="completed">
                                                        <li class="info-element ui-sortable-handle" id="task16">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task17">
                                                            Ut porttitor augue non sapien mollis accumsan.
                                                            Nulla non elit eget lacus elementum viverra.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task18">
                                                            Which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task19">
                                                            Packages and web page editors now use Lorem Ipsum as
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-primary">Done</a>
                                                                <i class="fa fa-clock-o"></i> 08.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task20">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="info-element ui-sortable-handle" id="task21">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task22">
                                                            Simply dummy text of the printing and typesetting industry.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 12.10.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task23">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body col-lg-3">
                                    <div class="row">
                                        <div class="">
                                            <div class="ibox" >
                                                <h3>Alertas</h3>
                                                <p class="small"><i class="fa fa-hand-o-up"></i> Drag task between list</p>
                                                <div class="input-group">
                                                    <input type="text" placeholder="Add new task. " class="input form-control-sm form-control">
                                                    <span class="input-group-btn">
                                                        <button type="button" class="btn btn-sm btn-white"> <i class="fa fa-plus"></i> Add task</button>
                                                    </span>
                                                </div>
                                                <div class="ibox-content" style="background-color: #e6ac00">

                                                    <ul class="sortable-list connectList agile-list ui-sortable" id="completed">
                                                        <li class="info-element ui-sortable-handle" id="task16">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task17">
                                                            Ut porttitor augue non sapien mollis accumsan.
                                                            Nulla non elit eget lacus elementum viverra.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task18">
                                                            Which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 09.12.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task19">
                                                            Packages and web page editors now use Lorem Ipsum as
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-primary">Done</a>
                                                                <i class="fa fa-clock-o"></i> 08.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task20">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                        <li class="info-element ui-sortable-handle" id="task21">
                                                            Sometimes by accident, sometimes on purpose (injected humour and the like).
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 16.11.2015
                                                            </div>
                                                        </li>
                                                        <li class="warning-element ui-sortable-handle" id="task22">
                                                            Simply dummy text of the printing and typesetting industry.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Tag</a>
                                                                <i class="fa fa-clock-o"></i> 12.10.2015
                                                            </div>
                                                        </li>
                                                        <li class="success-element ui-sortable-handle" id="task23">
                                                            Many desktop publishing packages and web page editors now use Lorem Ipsum as their default.
                                                            <div class="agile-detail">
                                                                <a href="#" class="float-right btn btn-xs btn-white">Mark</a>
                                                                <i class="fa fa-clock-o"></i> 05.04.2015
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>



                            </div>
                            <div role="tabpanel" id="tab-3" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">            
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <h2>Novo Apontamento</h2>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <form id="formApontamentoHora" method="post" action="<c:url value='/projeto/salvarApontamento'/>" >
                                            <input type="hidden" id="apontamentoProjetoId" name="apontamentoHora.projeto.idProjeto" value="${projeto.idProjeto}" />
                                            <input type="hidden" id="apontamentoRecursoId" name="apontamentoHora.recurso.idRecurso" value="${recurso.idRecurso}" />
                                            <input type="hidden" id="apontamentoVlHora" name="apontamentoHora.valorHora" value="${recurso.perfilRecurso.valorHora}" />
                                            <div class="col-lg-8">
                                                <div class="row">
                                                    <div class="col-lg-6 col-form-label">
                                                        <label>Recurso</label>
                                                        <input type="text" class="form-control" id="apontamentoRecursoNome" name="apontamentoHora.recurso.nomeRecurso" placeholder="" value="${recurso.nomeRecurso}"  readonly="">
                                                    </div>
                                                    <div class="col-lg-6 col-form-label alignright date cmpData">
                                                        <label>Apontamento</label>
                                                        <input  type="text" id="txtDataApontamento" class="form-control" name="apontamentoHora.dtApontamentoS" value="" >
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-lg-6 col-form-label">
                                                        <label>Perfil</label>                                                        
                                                        <input type="text" class="form-control" id="apontamentoRecursoPerfil" name="apontamentoHora.recurso.perfilRecurso.descricao" placeholder="" value="${recurso.perfilRecurso.descricao}"  readonly="">
                                                    </div>
                                                    <div class="col-lg-6 col-form-label alignright">
                                                        <label>Horas Apontadas</label>
                                                        <input type="number" min="1" max="24" id="apontamentoQtHora" class="form-control" name="apontamentoHora.qtHoraAlocada" value="" >
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4 col-md-4 col-sm-12">
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                                        <label>&nbsp;</label>
                                                        <textarea required class="form-control" id="motivoAgendamento" placeholder="<fmt:message key="projeto.place.escopo"/>"  name="agendamento.motivoVisita"  rows="5" ></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <br>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="form-group col-sm-4">
                                                        <button id="btnSalvarApontamento" type="submit" class="btn btn-primary"><fmt:message key="projeto.dados.salvar"/></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                    <br>    
                                    <div class="row">
                                        <div class="hr-line-dashed"></div>
                                        <table id="tbApontamentoProjeto" class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th><fmt:message key="projeto.texto.recurso"/></th>
                                                    <th><fmt:message key="projeto.texto.perfil"/></th>
                                                    <th><fmt:message key="projeto.texto.dtApontamento"/></th>
                                                    <th><fmt:message key="projeto.texto.horaApontada"/></th>
                                                    <th><fmt:message key="projeto.texto.valorHora"/></th>
                                                    <th><fmt:message key="projeto.texto.valorTotal"/></th>
                                                    <th><fmt:message key="projeto.texto.atividade"/></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${apontamentos}" var="apontamento">
                                                    <tr>
                                                        <td>${apontamento.recurso.nomeRecurso}</td>
                                                        <td>${apontamento.recurso.perfilRecurso.descricao}</td>
                                                        <td>${apontamento.dtApontamento}</td>
                                                        <td>${apontamento.qtHoraAlocada}</td>
                                                        <td>${apontamento.valorHora}</td>
                                                        <td>${apontamento.qtHoraAlocada * apontamento.valorHora}</td>
                                                        <td>-</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" id="tab-5" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">            
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <h2>Novo Recurso</h2>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <form id="formApontamentoHora" method="post" action="<c:url value='/projeto/salvarRecurso'/>" >
                                            <input type="hidden" id="alocacaoProjetoId" name="alocacao.projeto.idProjeto" value="${projeto.idProjeto}" />
                                            <div class="col-lg-12">
                                                <div class="row">
                                                    <div class="col-lg-4 col-form-label">
                                                        <label>Nome</label>
                                                        <input type="text" class="form-control" id="recursoNome" name="recurso.nomeRecurso" placeholder="" value="">
                                                    </div>
                                                    <div class="col-lg-4 col-form-label">
                                                        <label>Login</label>
                                                        <select class="form-control m-b select_2" id="recursoLoginId" name="recurso.login.idLogin">
                                                            <option value="" selected="" disabled=""><fmt:message key="cadastro.selecione"/></option>
                                                            <c:forEach items="${logins}" var="login">
                                                                <option value="${login.idLogin}">${login.email}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <!--<select required=""  id="recursoPerfilId" class="form-control m-b" name="recurso.perfilRecurso.idPerfilRecurso" >
                                                            <option value="" disabled=""><fmt:message key="cadastro.selecione"/></option>
                                                        <c:forEach items="${perfis}" var="perfil">
                                                            <option value="${perfil.idPerfilRecurso}">${perfil.descricao}</option>
                                                        </c:forEach>
                                                    </select>      -->                                                  
                                                    </div>
                                                    <div class="col-lg-4 col-form-label alignright">
                                                        <label>Inicio Alocação</label>
                                                        <input  type="text" id="alocacaoDtInicio" class="form-control date cmpData" name="alocacao.dtInicioAlocacaoS" value="" >
                                                    </div>

                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-lg-4 col-form-label">
                                                        <label>Perfil</label>
                                                        <select required=""  id="recursoPerfilId" class="form-control m-b" name="recurso.perfilRecurso.idPerfilRecurso" >
                                                            <option value="" selected="" disabled=""><fmt:message key="cadastro.selecione"/></option>
                                                            <c:forEach items="${perfisRecurso}" var="perfil">
                                                                <option value="${perfil.idPerfilRecurso}">${perfil.descricao}</option>
                                                            </c:forEach>
                                                        </select>                                                        
                                                    </div>
                                                    <div class="col-lg-4">                                                      
                                                    </div>
                                                    <div class="col-lg-4 col-form-label alignright">
                                                        <label>Fim Alocação</label>
                                                        <input  type="text" id="alocacaoDtFim" class="form-control date cmpData" name="alocacao.dtFimAlocacaoS" value="" >
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="form-group col-sm-4">
                                                        <button id="btnSalvarApontamento" type="submit" class="btn btn-primary"><fmt:message key="projeto.dados.salvar"/></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                    <br>    
                                    <div class="row">
                                        <div class="hr-line-dashed"></div>
                                        <table id="tbAlocacaoProjeto" class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th><fmt:message key="projeto.texto.recurso"/></th>
                                                    <th><fmt:message key="projeto.texto.perfil"/></th>
                                                    <th><fmt:message key="projeto.texto.valorHora"/></th>
                                                    <th><fmt:message key="recurso.texto.inicioAlocacao"/></th>
                                                    <th><fmt:message key="recurso.texto.fimAlocacao"/></th>
                                                    <th><fmt:message key="recurso.texto.fimAlocacao"/></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${alocados}" var="alocado">
                                                    <tr>
                                                        <td>${alocado.recurso.nomeRecurso}</td>
                                                        <td>${alocado.recurso.perfilRecurso.descricao}</td>
                                                        <td>${alocado.recurso.perfilRecurso.valorHora}</td>
                                                        <td>${alocado.dtInicioAlocacao}</td>
                                                        <td>${alocado.dtFimAlocacao}</td>
                                                        <td></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" id="tab-6" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">            
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <h2>Nova Order de Serviço</h2>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <form id="formOrdemServico" class="form-horizontal" enctype="multipart/form-data" method="POST" action="<c:url value='/projeto/salvarOrdemServico'/>" accept-charset="UTF-8">
                                            <div class="form-group">
                                            <input type="hidden" id="osProjetoId" name="ordemServico.projeto.idProjeto" value="${projeto.idProjeto}" />
                                            <input type="hidden" id="osContratoFornecedorId" name="ordemServico.contrato.fornecedor.idFornecedor" value="" />
                                            <div class="row">
                                                <div class="col-lg-4 col-form-label">
                                                    <label><fmt:message key="contrato.texto"/></label>
                                                    <select required=""  id="ordemServicoContrato" onchange="carregaFornecedor(this.value)" class="form-control m-b" name="ordemServico.contrato.idContrato" >
                                                        <option value="" selected="" disabled=""><fmt:message key="cadastro.selecione"/></option>
                                                        <c:forEach items="${contratos}" var="contrato">
                                                            <option value="${contrato.idContrato}">${contrato.numero}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-lg-4 col-form-label alignright">
                                                    <label><fmt:message key="os.texto.nome"/></label>
                                                    <input  type="text" id="txtOrdermServicoNome" class="form-control" name="ordemServico.nome" value="">
                                                </div>
                                                <div class="col-lg-4 col-form-label alignright">
                                                    <label><fmt:message key="os.texto.vlPlanejado"/></label>
                                                    <input  type="text" id="txtOrdermServicoVlPlanejado" class="form-control dinheiro mask" name="ordemServico.vlPlanejado" value="">
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-lg-4 col-form-label">     
                                                    <label><fmt:message key="contrato.texto.fornecedor"/></label>
                                                    <input type="text" class="form-control" id="ordemServicoContratoFornecedor" name="ordemServico.contrato.fornecedor.nome" placeholder="" value=""  readonly="">
                                                </div>
                                                <div class="col-lg-4">
                                                    <label><fmt:message key="os.texto.upload"/></label>
                                                    <input id="ordemServicoArquivo" type="file" name="ordemServicoArquivo" class="form-control" data-btnClass="btn-primary" data-buttonBefore="true" data-text="Escolher arquivo" data-placeholder="Nenhum arquivo" accept="image/*" required="">
                                                </div>
                                                <div class="col-lg-4 col-form-label alignright">
                                                    <label><fmt:message key="os.texto.vlRealizado"/></label>
                                                    <input type="text" id="txtOrdermServicoVlRealizado" class="form-control dinheiro mask" name="ordemServico.vlRealizado" value="" >
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-8 col-md-12 col-sm-12">
                                                    <label>&nbsp;</label>
                                                    <textarea class="form-control" id="ordemServicoDescricao" placeholder="<fmt:message key="os.texto.descricao"/>"  name="ordemServico.descricao"  rows="5"></textarea>
                                                </div>
                                                <div class="col-lg-4 col-md-12 col-sm-12">
                                                    <label>&nbsp;</label>
                                                    <div class="checkbox checkbox-success">
                                                        <input name="ordemServico.mudancaEscopo" id="cbPendenteAprovacao" type="checkbox"> 
                                                        <label for="cbPendenteAprovacao"><fmt:message key="os.texto.mudancaEscopo"/></label>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <br>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <button id="btnSalvarOrdemServico" type="submit" form="formOrdemServico" class="btn btn-primary"><fmt:message key="projeto.dados.salvar"/></button>                                                    
                                                </div>
                                            </div>
                                            </div>
                                        </form>
                                    </div>

                                    <br>    
                                    <div class="row">
                                        <div class="hr-line-dashed"></div>
                                        <table id="tbOrdemServico" class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th><fmt:message key="os.texto.detalhe"/></th>
                                                    <th><fmt:message key="contrato.texto.numero"/></th>
                                                    <th><fmt:message key="contrato.texto.fornecedor"/></th>
                                                    <th><fmt:message key="os.texto.nome"/></th>
                                                    <th><fmt:message key="os.texto.vlPlanejado"/></th>
                                                    <th><fmt:message key="os.texto.vlRealizado"/></th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${ordens}" var="os">
                                                    <tr>
                                                        <td style="text-align: center; margin: 20px 0; padding: 10px;"><button class="btn btn-success" onclick="editarOrdemServico(${os.idOrdemServico})"><i class="fa fa-plus"></i></button></td>
                                                        <td>${os.contrato.numero}</td>
                                                        <td>${os.contrato.fornecedor.nome}</td>
                                                        <td>${os.nome}</td>
                                                        <td>${os.vlPlanejado}</td>
                                                        <td>${os.vlRealizado}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
                                                    
            <%@include file="../modal/modalOrdemServico.jsp" %>
        </jsp:body>
            
    </template:layout>
