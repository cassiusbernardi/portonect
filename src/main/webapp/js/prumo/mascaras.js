
$(document).ready(function () {
    /*
    $(".telefone").inputmask({
        mask: ["(99)9999-9999", "(99)99999-9999"],
        keepStatic: true
    });
    
    $(".matricula").inputmask({
        mask: ["999999999"],
        keepStatic: true
    });
    
    $(".numero").inputmask({
        mask: ["9,99","99,99", "999,99","9999,99"],
        keepStatic: true
    });
    */
});

function somenteNumeros(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}