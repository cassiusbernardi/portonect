/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var msgSucesso = $("#msgSucesso").val();
    var msgErro = $("#msgErro").val();

    if (msgSucesso != "") {
        swal("Atenção", msgSucesso, "success");
    }

    if (msgErro != "") {
        swal({
            title: "Erro!",
            type: "warning",
            text: msgErro
        });
    }

//    $('#cmbStatusAgendamento').select2({
//       width: "resolve"
//      })   theme: "classic",
//        width: "resolve"
//      });

    $("#todo, #inprogress, #completed").sortable({
        connectWith: ".connectList",
        update: function (event, ui) {

            var todo = $("#todo").sortable("toArray");
            var inprogress = $("#inprogress").sortable("toArray");
            var completed = $("#completed").sortable("toArray");
            $('.output').html("ToDo: " + window.JSON.stringify(todo) + "<br/>" + "In Progress: " + window.JSON.stringify(inprogress) + "<br/>" + "Completed: " + window.JSON.stringify(completed));
        }
    }).disableSelection();


    $('#tbApontamentoProjeto').dataTable({
        responsive: true,
        "searching": true,
        "bFilter": false,
        "pageLength": 10,
        "scrollX": true,
        "lengthMenu": [5, 10, 20, 25, 50],
        "columnDefs": []
    });

    $('#tbAlocacaoProjeto').dataTable({
        responsive: true,
        "searching": true,
        "pageLength": 10,
        "scrollX": true,
        "lengthMenu": [5, 10, 20, 25, 50],
        "order": [[0, "desc"]]
    });
    
    $('#tbOrdemServico').dataTable({
        responsive: true,
        "searching": true,
        "pageLength": 10,
        "scrollX": true,
        "lengthMenu": [5, 10, 20, 25, 50],
        "order": [[0, "desc"]]
    });
    



    $('.cmpData').datetimepicker({
        locale: "pt-br",
        format: 'DD/MM/YYYY',
        allowInputToggle: true,
        showClear: true,
        defaultDate: new Date()
    });

    $("input:file").change(function () {
        if ($(this).get(0).files.length > 0) {

            var ext = $(this).get(0).files[0].name.split(".");
            ext = ext[ext.length - 1].toLowerCase();
            var arrayExtensions = ["jpg", "jpeg", "png",
                "bmp", "gif"];

            if (arrayExtensions.lastIndexOf(ext) == -1) {
                swal({
                    title: "Aviso!",
                    text: "Formato de arquivo incorreto. Os formatos aceitos são: ."
                            + arrayExtensions.join(', .'),
                    html: true
                });
                $("#documento").val('');
            } else if ($(this).get(0).files[0].size > 2097152) {
                swal({
                    title: "Aviso!",
                    text: "Imagem grande demais! tamanho maximo permitido é de 2mb.",
                    html: true
                });
                $("#documento").val('');
            }
        }
    });

});//$(document).ready(function()

function carregaFornecedor(idContrato) {

    $.ajax({
        url: appURL + 'fornecedor/porContrato/' + idContrato,
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {

        if (data.retornoBean.status == 1) {

            $("#osContratoFornecedorId").val(data.retornoBean.object.idFornecedor);
            $("#ordemServicoContratoFornecedor").val(data.retornoBean.object.nome);

        }
    }).fail(function (request, status, error) {
        swal('Atenção!', 'Não foi possível completar sua solicitação. Tente novamente.', 'error');
        return;
    });

}

function editarOrdemServico(idOrdemServico) {
    
    $.ajax({
        url: appURL + 'orderServico/porId/' + idOrdemServico,
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json'
    }).done(function (data) {

        if (data.retornoBean.status == 1) {

//            $("#osContratoFornecedorId").val(data.retornoBean.object.idFornecedor);
//            $("#ordemServicoContratoFornecedor").val(data.retornoBean.object.nome);
            $("#modalExibirAgendamento").modal("show");
        }
    });
}