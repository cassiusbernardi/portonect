package com.prumo.portonect.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import com.prumo.portonect.entity.Login;

@Intercepts
@RequestScoped
public class RequestIncerptor {

    @Inject
    private HttpServletRequest request;

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
        System.out.println("Interceptando " + request.getRequestURI());
        Session sessao = SecurityUtils.getSubject().getSession();
        if (sessao != null) {
            Login login = (Login) sessao.getAttribute("usuarioLogado");
            if (login != null) {
                request.setAttribute("alertTitle", "Atenção");
            }
            //request.setAttribute("idioma", login.getIdioma().getIdIdioma());
        }
        stack.next(); // continua a execução
    }

}
