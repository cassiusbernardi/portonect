$(document).ready(function () {

    $("#cadastroFornecedorForm").validate({
        rules: {
            required: true
        }
    });
    $('#txtNumeroDocumentoFornecedor').keypress(somenteNumeros);
    $("#txtNumeroDocumentoFornecedor").mask("99.999.999/9999-99");

    $.get("https://servicodados.ibge.gov.br/api/v1/localidades/estados", function (data) {

        $('#txtUfFornecedor').find('option').remove().end();
        data.sort(function (a, b) {
            var textA = a.sigla.toUpperCase();
            var textB = b.sigla.toUpperCase();
            return (textA < textB) ? -1 : (textA > textB) ? 1 : 0;
        });
        for (var i in data) {

            var sigla = data[i].sigla;
            $('#txtUfFornecedor').append($('<option>', {
                value: sigla,
                text: sigla
            }));

        }
        ;
//            if (funcionarioSelecionado == list[i].matricula) {
//                $('#funcionario').val(funcionarioSelecionado);
//                $("#funcionario").append('<option value="' + list[i].matricula + '" selected>' + list[i].nome + '</option>');
//            } else {
//                if (list[i].tp_situacao == 'R')
//                    $("#funcionario").append('<option value="' + list[i].matricula + '" style="color: #FF0000;">' + list[i].nome + '</option>');
//                else
//                    $("#funcionario").append('<option value="' + list[i].matricula + '" >' + list[i].nome + '</option>');
//            }
    }, "json");

});

function validaSenha() {
    var novaSenha = $('#passSenha').val();
    var confirmaSenha = $('#confirmaPassSenha').val();
    if (novaSenha !== confirmaSenha) {
        $('#confirmaPassSenha').css('background', '#F08080');
        $('#btnSalvar').attr("disabled", true);
        $('#confirmaPassSenha').css('border-color', '#e5e6e7');
        $('#passSenha').css('border-color', '#e5e6e7');
    } else {
        $('#confirmaPassSenha').css('background', '#FFFFFF');
        $('#confirmaPassSenha').css('border-color', '#228B22');
        $('#passSenha').css('border-color', '#228B22');
        $('#btnSalvar').attr("disabled", false);
    }
}

function validaEmail() {
    var email = $('#txtEmail').val();
    var confirmaEmail = $('#txtConfirmaEmail').val();
    if (email !== confirmaEmail) {
        $('#txtConfirmaEmail').css('background', '#F08080');
        $('#btnSalvar').attr("disabled", true);
        $('#txtConfirmaEmail').css('border-color', '#e5e6e7');
        $('#txtEmail').css('border-color', '#e5e6e7');
    } else {
        $('#txtConfirmaEmail').css('background', '#FFFFFF');
        $('#txtConfirmaEmail').css('border-color', '#228B22');
        $('#txtEmail').css('border-color', '#228B22');
        $('#btnSalvar').attr("disabled", false);
    }
}

function formatoDoc() {

    $("#txtNumeroDocumentoFornecedor").mask("99.999.999/9999-99");
    $("#txtNumeroDocumentoFornecedor").removeAttr("maxlength");
    $("#txtNumeroDocumentoFornecedor").attr("maxlength", "18");

    $('#txtNumeroDocumentoFornecedor').keypress(somenteNumeros);
}

function somenteNumeros(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}

function verificaCnpj() {
    var cnpj = $('#txtNumeroDocumentoFornecedor').val();
    cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
    $.get(appURL + "fornecedor/cnpj/" + cnpj, function (data) {
        if (data.retornoBean.object != null) {
            swal({
                title: "Atenção!",
                text: "CNPJ cadastrado!",
                type: "warning"
            });
            $('#btnSalvar').attr("disabled", true);
        } else {
            $('#btnSalvar').attr("disabled", false);
        }

    }, "json");

}