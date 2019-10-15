/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

//    $("input[type=text]").keyup(function () {
//        if(!$(this).hasClass('mask')) {
//            var str = $(this).val().toUpperCase();
//            
//            str = str.replace(new RegExp("[àáâãäå]", 'g'),"a");
//            str = str.replace(new RegExp("[ÀÁÂÃÄ]", 'g'),"A");
//            str = str.replace(new RegExp("æ", 'g'),"ae");
//            str = str.replace(new RegExp("ç", 'g'),"c");
//            str = str.replace(new RegExp("Ç", 'g'),"C");
//            str = str.replace(new RegExp("[èéêë]", 'g'),"e");
//            str = str.replace(new RegExp("[ÈÉÊË]", 'g'),"E");
//            str = str.replace(new RegExp("[ìíîï]", 'g'),"i");
//            str = str.replace(new RegExp("[ÌÍÎÏ]", 'g'),"I");
//            str = str.replace(new RegExp("ñ", 'g'),"n");
//            str = str.replace(new RegExp("Ñ", 'g'),"N");
//            str = str.replace(new RegExp("[òóôõö]", 'g'),"o");
//            str = str.replace(new RegExp("[ÒÓÔÕÖ]", 'g'),"O");
//            str = str.replace(new RegExp("œ", 'g'),"oe");
//            str = str.replace(new RegExp("[ùúûü]", 'g'),"u");
//            str = str.replace(new RegExp("[ÙÚÛÜ]", 'g'),"U");
//            str = str.replace(new RegExp("[ýÿ]", 'g'),"y");
//            str = str.replace(new RegExp("[Ý]", 'g'),"Y");
//            str = str.replace(new RegExp("[!#$%¨&*()_-§¹²³£¢¬{}[ªº°<>,.:;?/|]", 'g'),"");
//            str = str.replace("+","");
//            str = str.replace("=","");
//            str = str.replace("]","");
//            str = str.replace("'","");
//            str = str.replace("´","");
//            str = str.replace("'","");
//            str = str.replace('"',"");
//            str = str.replace("^","");
//            str = str.replace("\\","");
//
//            $(this).val(str);
//        }
//    });
    
//    $("textarea").keyup(function () {
//        var str = $(this).val().toUpperCase();
//            
//        str = str.replace(new RegExp("[àáâãäå]", 'g'),"a");
//        str = str.replace(new RegExp("[ÀÁÂÃÄ]", 'g'),"A");
//        str = str.replace(new RegExp("æ", 'g'),"ae");
//        str = str.replace(new RegExp("ç", 'g'),"c");
//        str = str.replace(new RegExp("Ç", 'g'),"C");
//        str = str.replace(new RegExp("[èéêë]", 'g'),"e");
//        str = str.replace(new RegExp("[ÈÉÊË]", 'g'),"E");
//        str = str.replace(new RegExp("[ìíîï]", 'g'),"i");
//        str = str.replace(new RegExp("[ÌÍÎÏ]", 'g'),"I");
//        str = str.replace(new RegExp("ñ", 'g'),"n");
//        str = str.replace(new RegExp("Ñ", 'g'),"N");
//        str = str.replace(new RegExp("[òóôõö]", 'g'),"o");
//        str = str.replace(new RegExp("[ÒÓÔÕÖ]", 'g'),"O");
//        str = str.replace(new RegExp("œ", 'g'),"oe");
//        str = str.replace(new RegExp("[ùúûü]", 'g'),"u");
//        str = str.replace(new RegExp("[ÙÚÛÜ]", 'g'),"U");
//        str = str.replace(new RegExp("[ýÿ]", 'g'),"y");
//        str = str.replace(new RegExp("[Ý]", 'g'),"Y");
//
//        $(this).val(str.toUpperCase());
//    });
    
    $(".onlyNumber").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
        // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
        // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    
    
    
//    $(".dinheiro").keyup(function () {
//        $(this).val(new Number($(this).val()).format(2, 1, '.', ','));
//    });
//    $('.dinheiro').maskMoney();
    $('.dinheiro').maskMoney({symbol:'R$ ', 
        showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
});

function mostraAguarde() {
    $("#aguardeModal").modal("show");
}

function escondeAguarde() {
    $("#aguardeModal").modal("hide");
}

function removerAcentos( newStringComAcento ) {
  var string = newStringComAcento;
	var mapaAcentosHex 	= {
		a : /[\xE0-\xE6]/g,
		e : /[\xE8-\xEB]/g,
		i : /[\xEC-\xEF]/g,
		o : /[\xF2-\xF6]/g,
		u : /[\xF9-\xFC]/g,
		c : /\xE7/g,
		n : /\xF1/g
	};

	for ( var letra in mapaAcentosHex ) {
		var expressaoRegular = mapaAcentosHex[letra];
		string = string.replace( expressaoRegular, letra );
	}

	return string;
}
/**
 * Number.prototype.format(n, x, s, c)
 * 
 * @param integer n: length of decimal
 * @param integer x: length of whole part
 * @param mixed   s: sections delimiter
 * @param mixed   c: decimal delimiter
 */
Number.prototype.format = function(n, x, s, c) {
    var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\D' : '$') + ')',
        num = this.toFixed(Math.max(0, ~~n));

    return (c ? num.replace('.', c) : num).replace(new RegExp(re, 'g'), '$&' + (s || ','));
};

function dataAtualFormatada() {
    var data = new Date();
    var dia = data.getDate();
    if (dia.toString().length == 1)
      dia = "0"+dia;
    var mes = data.getMonth()+1;
    if (mes.toString().length == 1)
      mes = "0"+mes;
    var ano = data.getFullYear();  
    return dia+"/"+mes+"/"+ano;
}