/**
 * It is not uncommon for non-English speaking countries to use a comma for a
 * decimal place. This sorting plug-in shows how that can be taken account of in
 * sorting by adding the type `numeric-comma` to DataTables. A type detection 
 * plug-in for this sorting method is provided below.
 * 
 * Please note that the 'Formatted numbers' type detection and sorting plug-ins
 * offer greater flexibility that this plug-in and should be used in preference
 * to this method.
 *
 *  @name Commas for decimal place
 *  @summary Sort numbers correctly which use a comma as the decimal place.
 *  @deprecated
 *  @author [Allan Jardine](http://sprymedia.co.uk)
 *
 *  @example
 *    $('#example').dataTable( {
 *       columnDefs: [
 *         { type: 'numeric-comma', targets: 0 }
 *       ]
 *    } );

 */


jQuery.extend( jQuery.fn.dataTableExt.oSort, {
	"numeric-comma-pre": function ( a ) {
		var x = (a == "-") ? 0 : a.replace( /,/, "." );
		
		var totalPontos = (x.split(".").length - 1);

		if (totalPontos > 1) {
			//acha o primeiro ponto do x.
			var n = x.indexOf(".");
			var parte1 = x.slice(0,n);
			var parte2 = x.slice(n+1, x.length);
			var valor = parte1 + parte2;
			x = valor;
		}
		
		return parseFloat( x );
	},

	"numeric-comma-asc": function ( a, b ) {
		return ((a < b) ? -1 : ((a > b) ? 1 : 0));
	},

	"numeric-comma-desc": function ( a, b ) {
		return ((a < b) ? 1 : ((a > b) ? -1 : 0));
	}
} );

function countOcurrences(str, value){
	   var regExp = new RegExp(value, "gi");
	   return str.match(regExp) ? str.match(regExp).length : 0;  
	}

function getFloat(text) {
    var regex = /\d+|\./g,
        matches,
        num = "";

    while(matches = regex.exec(text)) {
        num += matches[0];
    }
    return parseFloat(num) || 0;
}