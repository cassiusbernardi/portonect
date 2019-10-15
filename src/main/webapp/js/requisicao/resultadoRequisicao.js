$(document).ready(function () {
    $('#quantidadeItemRequisicaoTxt').keypress(somenteNumeros);

    var statusRequisicao = $('#statusRequisicao').val();
    var vazio = !statusRequisicao;

    if (statusRequisicao != 1 && (!vazio)) {
        $('#descricaoRequisicaoTxt').attr("disabled",true);
        $('#dataAberturaRequisicaoTxt').attr("disabled",true);
        $('#dataEncerramentoRequisicaoTxt').attr("disabled",true);
        $(".btn").hide();
        $('#adicionarFornecedorDiv').hide();
        $('#adicionarItemDiv').hide();
    }

    toastr.options = {
        "closeButton": true,
        "debug": true,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "onclick": null,
        "timeOut": "7000",
        "showDuration": "400",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    Dropzone.options.dropzoneForm = {
        paramName: "file", // The name that will be used to transfer the file
        addRemoveLinks: true,
        init: function () {},
        maxFilesize: 2, // MB
        dictDefaultMessage: "<strong>Drop files here or click to upload. </strong></br> (This is just a demo dropzone. Selected files are not actually uploaded.)"
    };

    $(".dz-remove").on("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        var imageId = $(this).parent().find(".dz-filename > span").text();

//        $.ajax({
//            url: "Your url here",
//            data: {imageId: imageId},
//            type: 'POST',
//            success: function (data) {
//                if (data.NotificationType === "Error") {
//                    toastr.error(data.Message);
//                } else {
//                    toastr.success(data.Message);
//                }
//            },
//            error: function (data) {
//                toastr.error(data.Message);
//            }
//        })

    });

    $('.chosen-select').chosen({width: "100%"});
    $(".select2_demo_2").select2();

    $('#dataAberturaRequisicaoTxt').datetimepicker({
        format: 'DD/MM/YYYY',
        allowInputToggle: true,
        showClear: true
    });

    $('#dataEncerramentoRequisicaoTxt').datetimepicker({
        format: 'DD/MM/YYYY',
        allowInputToggle: true,
        showClear: true
    });

    $("#uploadArquivo").change(function () {
        var f = this.files; // SELECIONA OS ARQUIVOS
        var qtde = f.length; // CONTA QUANTOS TEM
        var totalSize = 0;
        var maxSize = 209715200; // LIMITE DE TAMANHO NO UPLOAD  
        var arrayExtensions = ["jpg", "jpeg", "png", "bmp", "pdf"]; //EXTENSOES PERMITIDAS
        var extCorreta = true;
        for (var i = 0; i <= f.length - 1; i++) {
            var ext = f.item(i).name.split(".");
            ext = ext[ext.length - 1].toLowerCase();
            totalSize = totalSize + f.item(i).size;
            if (arrayExtensions.lastIndexOf(ext) === -1) {
                extCorreta = false;
            }
        }
        if (!extCorreta) {
            toastr.error('Permitidas: ' + arrayExtensions.join(', .'), 'Extensões de arquivo Inválida !');

        } else if (qtde > 20 || totalSize > maxSize) { // VERIFICA SE É MAIOR DO QUE 20    
            toastr.error('Você está excedendo em tamanho ou quantidade de arquivos por vez!', 'Atenção !');

            $(this).val("");
            return false;
        } else { // SE NÃO FOR MAIS DO QUE 20 ELE CONTINUA.
            $("#dropzoneForm").submit();
        }
//            $("#confirmarRegistro").submit();     

    });

});

function downloadAnexo(id) {
    alert(id);
    $("#idAnexoDownload").val(id);
    $("#downloadAnexoForm").submit();
}

function downloadParticipanteAnexo(id) {
    alert(id);
    $("#idAnexoParticipanteResultadoDownload").val(id);
    $("#downloadAnexoParticipanteForm").submit();

}

function somenteNumeros(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}

function habilitaBtnFornecedor() {
    var fornecedor = $("#participanteRequisicaoTxt").val();
    if (fornecedor != null) {
        $("#salvarBtn").attr("disabled", false);
    } else {
        $("#salvarBtn").attr("disabled", true);
    }
}

function salvarItemRequisicao() {

    var idRequisicao = $("#idRequisicaoTxt").val();
    var descricaoRequisicao = $("#descricaoRequisicaoTxt").val();
    var descricaoItemRequisicao = $("#descricaoItemRequisicaoTxt").val();
    var idUnidade = $("#unidadeItemRequisicaoTxt").val();
    var quantidadeItemRequisicao = $("#quantidadeItemRequisicaoTxt").val();

    if (descricaoItemRequisicao != null || quantidadeItemRequisicao != null || idUnidade != null ) {
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "onclick": null,
            "timeOut": "7000",
            "showDuration": "400",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
        toastr.warning('Prencha todos os campos', 'Atenção');
        return;
    }

    $.post(appURL + "requisicao/salvarItem",
            {"requisicao.idRequisicao": idRequisicao
                , "requisicao.descricao": descricaoRequisicao
                , "itemRequisicao.descricao": descricaoItemRequisicao
                , "itemRequisicao.unidade.idUnidade": idUnidade
                , "itemRequisicao.quantidade": quantidadeItemRequisicao
            }, function (data) {

        if (data.retornoBean.status == 1) {
            preencherTabela(data.retornoBean.lista);
            toastr.options = {
                "closeButton": true,
                "debug": true,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "onclick": null,
                "timeOut": "7000",
                "showDuration": "400",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };
            toastr.success('Registro Incluido com sucesso.', 'Sucesso!');
        } else {
            toastr.options = {
                "closeButton": true,
                "debug": false,
                "progressBar": true,
                "positionClass": "toast-top-right",
                "onclick": null,
                "timeOut": "7000",
                "showDuration": "400",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };
            toastr.error('Erro ao incluir registro.', 'Atenção');
        }

    }, "json");

}

function removerItemRequisicao(id) {

    swal({
        title: "",
        text: "Confirma retirada?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sim!",
        closeOnConfirm: false
    }, function () {
        $("#idItemRequisicaoRemoverTxt").val(id);
        $("#removerItemForm").submit();
        $("#modalProcessando").modal("show");
    });
}


function preencherTabela(lista) {

    $("#itemRequisicaoTbl tbody").remove();

    $("#modalProcessando").modal("hide");

    for (var i in lista) {
        var html = '';
        var idItem = lista[i].idItemRequisicao;
        var descricaoItem = lista[i].descricao;
        var qtdItem = lista[i].quantidade;
        var unidadeItem = lista[i].unidade.descricao;

        html += '<tr>';
        html += '<td>' + idItem + '</td>';
        html += '<td>' + descricaoItem + '</td>';
        html += '<td>' + qtdItem + '</td>';
        html += '<td>' + unidadeItem + '</td>';
        html += '<td><a title="Excluir" href="JavaScript:removerItemRequisicao(' + idItem + ')"><i class="glyphicon glyphicon-trash"></i></a></td>';
        html += '</tr>';
        $('#itemRequisicaoTbl').append(html);
    }
    $('[data-toggle="tooltip"]').tooltip();
//    var table = $('#itemRequisicaoTbl').DataTable({
//        destroy: true,
//        'columnDefs': [{
//                'targets': 0,
//                'searchable': false,
//                'orderable': false,
//                'className': 'dt-body-center'
//            }],
//        'order': [0, 'desc']
//    });
}

function removerAnexo(id) {

    swal({
        title: "",
        text: "Confirma retirada?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sim!",
        closeOnConfirm: false
    }, function () {
        $("#idAnexoRequisicaoRemoverTxt").val(id);
        $("#removerAnexoForm").submit();
        $("#modalProcessando").modal("show");
    });
}

function removerParticipanteRequisicao(id) {

    swal({
        title: "",
        text: "Confirma retirada?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sim!",
        closeOnConfirm: false
    }, function () {
        $("#idParticipanteRequisicaoRemoverTxt").val(id);
        $("#removerParticipanteForm").submit();
        $("#modalProcessando").modal("show");
    });
}

function enviarRequisicao() {

    swal({
        title: "Confirma envio?",
        text: "Após envio do convite ao fornecedor, não será possivel alterar nenhum parametro.",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sim!",
        closeOnConfirm: false
    }, function () {
        var id = $("#idRequisicaoTxt").val();
        $("#idRequisicaoEnviarRequisicaoTxt").val(id);
        $("#enviarRequisicaoForm").submit();
    });
}