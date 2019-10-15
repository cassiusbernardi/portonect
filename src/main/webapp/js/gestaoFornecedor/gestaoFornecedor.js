$(document).ready(function () {

    $("#cadastroFornecedorForm").validate({
        rules: {
            required: true
        }
    });
    $('#txtNumeroDocumentoFornecedor').keypress(somenteNumeros);
    $("#txtNumeroDocumentoFornecedor").mask("99.999.999/9999-99");

});

