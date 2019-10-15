$(document).ready(function() {
//
//	var title = "Atenção!";
//	var idioma = $("#txtLanguageDif").val();
//	var language = $("#txtLanguageRec").val();
//	
//	if (idioma == 'en_US') {
//		title = "Attention";
//	}else if (language == 'en') {
//		title = "Attention";
//	}
//	
//	if (mensagem != "") {
//		swal(title, mensagem, "success");
//	}
//	
//	if (mensagemErro != "") {
//		swal(title, mensagemErro, "warning");
//	}
//	
//	$("#logarForm").submit(function( event ) {
//		$("#txtLanguageForm").val("pt");
//		if (idioma == 'en_US') {
//			$("#txtLanguageForm").val("en");
//		}else if (language == 'en'){
//			$("#txtLanguageForm").val("en");
//		}
//	});
//	
});

function recuperarSenha(){
	
	var title = "Atenção!";
	var idioma = $("#txtLanguageDif").val();
	var txtRecuperar = "Favor preencher o campo E-mail!";
	
	var language = $("#txtLanguageRec").val();
	
	$("#txtLanguage").val("pt");
	
	if (idioma == 'en_US') {
		title = "Attention";
		txtRecuperar = "Please fill in the Email field!";
		$("#txtLanguage").val("en");
	}else if (language == 'en'){
		title = "Attention";
		txtRecuperar = "Please fill in the Email field!";
		$("#txtLanguage").val("en");
	}
	
	var email = $("#emailUsuario").val();
	if (email != null && email != "") {
		$("#emailRecuperacao").val(email);
		$("#urlRecuperacao").val(appURL);
		
		$("#formRecuperarSenha").submit();
		$("#modalProcessando").modal("show");
	}else {
		swal(title, txtRecuperar, "warning");
	}
	
}