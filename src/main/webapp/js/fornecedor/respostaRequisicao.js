$(document).ready(function () {

//    $('.dinheiro').keypress(somenteNumeros);
//    $('#itemSelecionadoValorTotal').maskMoney({symbol:'R$ ', 
//        showSymbol:true, thousands:',', decimal:'.', symbolStay: true});
    
    var editavel = $('#editavel').val();
    if (editavel < 1) {
        $('#salvarBtn').attr("disabled",true);
        $('#salvarBtn').hide();
        $('#uploadDiv').attr("disabled",true);
        $('#uploadDiv').hide();
        $('.valorClass').attr("disabled",true);
    } 
//    else {
//        
//        $('#salvarBtn').attr("disabled",true);
//        $('#salvarBtn').hide();
//        $('#uploadPropostaTecnica').attr("disabled",true);
//        $('#uploadPropostaTecnica').hide();
//        $('#uploadPropostaComercial').attr("disabled",true);
//        $('#uploadPropostaComercial').hide();
//
//    }

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

//    $("#uploadArquivo").change(function () {
//        var f = this.files; // SELECIONA OS ARQUIVOS
//        var qtde = f.length; // CONTA QUANTOS TEM
//        var totalSize = 0;
//        var maxSize = 209715200; // LIMITE DE TAMANHO NO UPLOAD  
//        var arrayExtensions = ["jpg", "jpeg", "png", "bmp", "pdf"]; //EXTENSOES PERMITIDAS
//        var extCorreta = true;
//        for (var i = 0; i <= f.length - 1; i++) {
//            var ext = f.item(i).name.split(".");
//            ext = ext[ext.length - 1].toLowerCase();
//            totalSize = totalSize + f.item(i).size;
//            if (arrayExtensions.lastIndexOf(ext) === -1) {
//                extCorreta = false;
//            }
//        }
//        if (!extCorreta) {
//            toastr.error('Permitidas: ' + arrayExtensions.join(', .'), 'Extensões de arquivo Inválida !');
//
//        } else if (qtde > 20 || totalSize > maxSize) { // VERIFICA SE É MAIOR DO QUE 20    
//            toastr.error('Você está excedendo em tamanho ou quantidade de arquivos por vez!', 'Atenção !');
//
//            $(this).val("");
//            return false;
//        } else { // SE NÃO FOR MAIS DO QUE 20 ELE CONTINUA.
//            $("#dropzoneForm").submit();
//        }
////            $("#confirmarRegistro").submit();     
//
//    });

});

function downloadAnexo(id) {

    $("#idAnexoDownload").val(id);
    $("#downloadAnexoForm").submit();

}

function downloadAnexoParticipante(id) {
    $("#idAnexoParticipanteDownload").val(id);
    $("#downloadAnexoParticipanteForm").submit();

}

function uploadFile(idTipoAnexo) {
    $("#tipoAnexoParticipanteRequisicaoTxt").val(idTipoAnexo);
    $("#dropzoneForm").submit();
    $("#modalProcessando").modal("show");
}

function removerAnexoParticipante(idAnexo) {
    swal({
        title: "",
        text: "Confirma retirada?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sim!",
        closeOnConfirm: false
    }, function () {
        $("#idAnexoParticipanteRemoverTxt").val(idAnexo);
        $("#removerAnexoForm").submit();
        $("#modalProcessando").modal("show");
    });
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

function salvarValor(id) {
    var item = id;
    var valor = $("#itemSelecionadoValor").val();
}