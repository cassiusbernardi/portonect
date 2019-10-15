<%-- 
    Document   : wrapper
    Created on : 06/02/2019, 08:52:22
    Author     : 120000499
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Notificações" pageEncoding="UTF-8"%>

<c:if test='${success != null}'>
    <script type="text/javascript">
        toastr.options = {
            "debug": true,
            "closeButton": true,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "onclick": null,
            "timeOut": "7000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
        toastr.success('${success}', 'Sucesso');
    </script>
</c:if>

<c:if test='${error != null}'>
    <script type="text/javascript">
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "progressBar": true,
            "preventDuplicates": false,
            "positionClass": "toast-top-right",
            "onclick": null,
            "showDuration": "400",
            "hideDuration": "1000",
            "timeOut": "7000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
        toastr.error('${error}','Atenção');

    </script>
</c:if>