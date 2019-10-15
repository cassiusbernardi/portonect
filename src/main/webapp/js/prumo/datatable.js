
$(document).ready(function () {   
    
    $('.prumo-table').DataTable({
        destroy: true,
        'columnDefs': [{
                'targets': 0,
                'searchable': false,
                'orderable': false,
                'className': 'dt-body-center'
            }],
        'order': [0, 'desc'],
        "responsive": true,
        "paging": true,
        "ordering": true,
        "info": true,
        "searching": true,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "lengthMenu": [[5, 10, -1], [5, 10, "All"]]
    });
    
    $('.prumo-table-10').DataTable({
        destroy: true,
        'columnDefs': [{
                'targets': 0,
                'searchable': false,
                'orderable': false,
                'className': 'dt-body-center'
            }],
        'order': [0, 'desc'],
        "responsive": true,
        "paging": true,
        "ordering": true,
        "info": true,
        "searching": true,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "pageLength": 10,
        "lengthMenu": [[5, 10, -1], [5, 10, "All"]]
    });
    /*
    $('.prumo-no-order').DataTable({
        "responsive": true,
        "paging": true,
        "info": true,
        "searching": true,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "lengthMenu": [[10,25,50, -1], [10,25,50, "All"]],
        "order": [[ 0, "desc" ]],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ]
    });
    
    $('.prumo2-table').DataTable({
        "responsive": true,
        "destroy": true,
        "paging": true,
        "ordering": true,
        "info": true,
        "searching": false,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "lengthMenu": [[5, 10, -1], [5, 10, "All"]]
    });
    
    $('.prumo3-table').DataTable({
        "destroy": true,
        "paging": true,
        "ordering": true,
        "info": false,
//        "searching": true,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "dom": '<"html5buttons">lTfgtBp',
        "buttons": [
//            'selectAll',
//            'selectNone',
            {extend: 'copy'},
            {extend: 'excel', title: 'ExampleFile'}
            ],
        "lengthMenu": [[5, 10, -1], [5, 10, "All"]],
        "scrollX": true
        
    });
    
    
    
    $('.prumo-table-order-desc').DataTable({
//        "responsive": true,
        "destroy": true,
        "paging": true,
        "ordering": true,
        "info": false,
        "searching": true,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "dom": '<"html5buttons">lTfgtBp',
        "buttons": [
                {extend: 'copy'},
                {extend: 'excel', title: 'ExampleFile'}
            ],
        "lengthMenu": [[5,10, 25, -1], [5,10, 25, "All"]],
        "order": [[ 0, "desc" ]]
    });
    
     $('.modal-table').DataTable({
         "responsive": true,
        "paging": true,
        "ordering": false,
        "searching": false,
        "info": false,
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "lengthMenu": [[5,10, 25, -1], [5,10, 25, "All"]],
    });
    
    $('.prumo-col6-table').DataTable({    
        "responsive": true,
            "pageLength": 5,
            "lengthMenu": [5, 10, 20, 25, 50],
            "info": false,
            "dom": '<"html5buttons">lTfgtBp',
            "buttons": [
                {extend: 'copy'},
                {extend: 'excel', title: 'ExampleFile'}
            ],
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
            },
            "order": [[0, "desc"]]
    });  
    
    */
});
