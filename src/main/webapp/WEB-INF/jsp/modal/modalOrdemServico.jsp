<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .select2-dropdown {
        z-index: 9001;
    }
</style>

<div id="modalExibirOrdemServico" class="modal inmodal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-sm" style="width:70%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 id="myModalLabel" class="modal-title"><fmt:message key="os.texto"/></h4>
            </div>
            <div class="modal-body" style="overflow:hidden;">
                <div class="row">
                    <div class="col-sm-12">
                        <h3 class="m-t-none m-b">
                            <fmt:message key="os.texto.nome"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="text-right" style="font-size: 12px">: <span id="modalOrdemServicoNome" style="color:blue"></span>
                            </span>
                        </h3>
                        <div class="form-group col-sm-6" >
                            <label><fmt:message key="contrato.texto"/></label>
                            <input disabled type="text" value="" id="modalOrdemServicoContrato" name="" class="form-control m-b">
                       	</div>
                        <div class="form-group col-sm-6" >
                            <label><fmt:message key="fornecedor.texto"/></label>
                            <input disabled type="text" value="" id="areaVisitada" name="agendamento.areaVisitada.nomeArea" class="form-control m-b" required>
                       	</div>
                    </div>    
                </div>                    
                <div class="row">
                    <div class="col-sm-12">                        
                       	<div class="form-group col-sm-3 date cmpData">
                            <label>Data Hora Início Visita</label><span style="color: #f8ac59;">*</span>
                            <input disabled type="text" value="" id="dtIniAgendamento" name="agendamento.dataHoraInicioS" class="form-control dataHora" required>
                        </div>
                        <div class="form-group  col-sm-3  date cmpData">
                            <label>Data Hora Fim Visita</label><span style="color: #f8ac59;">*</span>
                            <input disabled type="text" value=""  id="dtFimAgendamento" name="agendamento.dataHoraFimS" class="form-control dataHora" required>
                        </div>
                        <div class="form-group col-sm-6">
                            <label>Tipo da Visita</label><span style="color: #f8ac59;">*</span>
                            <input disabled type="text" value="" id="tipoVisita" name="agendamento.tipoVisita.idTipoVisita" class="form-control m-b" required>
                       	</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group col-sm-3">
                            <label>Nome do Visitado</label><span style="color: #f8ac59;">*</span>
                            <input disabled type="text" placeholder=""  id="nomeVisitado" value=""  name="agendamento.nomeVisitado"  class="form-control" required>
                        </div>
                        <div class="form-group col-sm-3">
                            <label>Telefone do Visitado</label>
                            <input disabled type="text" placeholder=""  id="telVisitado" value="" name="agendamento.telefoneVisitado" class="form-control">
                        </div>
                        <div class="form-group col-sm-6">
                            <label>E-Mail do visitado</label><span style="color: #f8ac59;">*</span>
                            <input disabled type="text" placeholder=""  id="emailVisitado" value="" name="agendamento.emailVisitado" class="form-control" required>
                       	</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group col-sm-6">
                            <label>Motivo da Visita</label><span style="color: #f8ac59;">*</span>
                            <textarea disabled required class="form-control" id="motivoAgendamento" name="agendamento.motivoVisita"  rows="5" ><c:out value="${agendamento.motivoVisita}"/></textarea>
                        </div>
                        <div class="form-group col-sm-6">
                            <label>Observação</label>
                            <textarea disabled class="form-control" id="obsAgendamento" name="agendamento.observacaoVisita"  rows="5" ><c:out value="${agendamento.observacaoVisita}" /></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group col-sm-12">
                            <div class="checkbox checkbox-success" >
                                <input name="agendamento.veiculoAutorizado" id="cbVeiculoPrevisto" disabled="" type="checkbox" style="size: 20px"<c:if test="${agendamento.veiculoAutorizado == 'S'}" >checked=""</c:if>>
                                <label for="cbVeiculoPrevisto"><span class="text-right" style="font-size: 14px"><span style="color:blue"><fmt:message key="agendamento.dados.veiculoPrevisto"/></span></span></label>
                            </div>                                        
                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<form id="formAssociarVisitante" method="post" action="<c:url value='/agendamento/visitantes/associar'/>">
    <input type="hidden" name="idAgendamento" value="" id="idAgendamentoModal" />
    <input type="hidden" name="idsVisitantes" value="" id="ids" />
</form> 


<input type="hidden" id="telaOrigem" />