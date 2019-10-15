$(document).ready(function () {
    
//    $('#tabelaMinhasVisitas').dataTable({
//        responsive: true,
//        "pageLength": 25,
//        "lengthMenu": [5, 10, 20, 25, 50, 100],
//        "dom": '<"html5buttons"B>lTfgitp',
//        "buttons": [
//            {extend: 'copy'},
//            {extend: 'csv'},
//            {extend: 'excel', title: 'ExampleFile'},
//            {extend: 'pdf', title: 'ExampleFile'},
//
//            {extend: 'print',
//                customize: function (win) {
//                    $(win.document.body).addClass('white-bg');
//                    $(win.document.body).css('font-size', '10px');
//
//                    $(win.document.body).find('table')
//                            .addClass('compact')
//                            .css('font-size', 'inherit');
//                }
//            }
//        ],
//        "language": {
//            "search": "Pesquisar: ",
//            "lengthMenu": "_MENU_",
//            "info": "&nbsp Exibindo de _START_ até _END_ de um total de _MAX_ registros",
//            "paginate": {
//                "first": "Primeira Página",
//                "last": "Última Página",
//                "previous": "Anterior",
//                "next": "Próxima"
//            }
//        },
//        "columnDefs": [
//            {"orderable": false, "targets": [6]}
//        ],
//        "order": [[0, "desc"]]
//    });

//    var rollVisitantes = $("#verVisitantesRoll").val();
//    if (rollVisitantes == "true") {
//
//        var tabela = $('#tabelaMinhasVisitas').DataTable();
//        var currentPag = $("#currentPag").val();
//
//        for (var int = 0; int < currentPag; int++) {
//            tabela.page('next').draw('page');
//        }
//
//
//        $('html, body').animate({
//            scrollTop: $('#tabelaVisitantes').offset().top
//        }, 0);
//    }

//    $('#tabelaVisitantes').dataTable({
//        responsive: true,
//        searching: true,
//        "pageLength": 5,
//        "lengthMenu": [5, 10, 20, 25, 50],
//        "language": {
//            "search": "Pesquisar: ",
//            "lengthMenu": "_MENU_",
//            "info": "&nbsp Exibindo de _START_ até _END_ de um total de _MAX_ registros",
//            "paginate": {
//                "first": "Primeira Página",
//                "last": "Última Página",
//                "previous": "Anterior",
//                "next": "Próxima"
//            }
//        },
//        "columnDefs": [
//            {"orderable": false, "targets": [4]}
//        ],
//    });

});

function abrirProjeto(idProjeto) {
    var url = appURL + 'projeto/exibir/' + idProjeto;
    window.location.href = url;

}