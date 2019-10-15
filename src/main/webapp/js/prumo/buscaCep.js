/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(".cep").blur(function () {
        pesquisacep($(this).val());
    });
});

function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    $('#ruaTxt').val("");
    $('#bairroTxt').val("");
    $('#cidadeTxt').val("");
    $('#estadoTxt').val("");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        $('#ruaTxt').val(conteudo.logradouro.toUpperCase());
        $('#bairroTxt').val(conteudo.bairro.toUpperCase());
        $('#cidadeTxt').val(conteudo.localidade.toUpperCase());
        $('#estadoTxt').val(conteudo.uf.toUpperCase());
        
        escondeAguarde();
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        escondeAguarde();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep !== "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if (validacep.test(cep)) {

            mostraAguarde();
            
            //Preenche os campos com "..." enquanto consulta webservice.
            $('#ruaTxt').val("...");
            $('#bairroTxt').val("...");
            $('#cidadeTxt').val("...");
            $('#estadoTxt').val("...");

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = '//viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
//        limpa_formulário_cep();
    }
}