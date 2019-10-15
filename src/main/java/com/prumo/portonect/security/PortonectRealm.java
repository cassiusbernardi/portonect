package com.prumo.portonect.security;

import com.prumo.portonect.entity.Login;
import com.prumo.portonect.enums.TipoLoginEnum;
import com.prumo.portonect.repository.LoginRepository;
import com.prumo.portonect.service.LoginService;
import com.prumo.portonect.service.impl.LoginServiceImpl;
import com.prumo.portonect.util.CipherUtil;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prumo.portonect.util.JpaUtil;
import javax.inject.Inject;

public class PortonectRealm implements Realm, Authorizer {

    private Logger logger = LoggerFactory.getLogger(PortonectRealm.class);
//    @Inject private LoginService loginService;

    @Override
    public void checkPermission(PrincipalCollection arg0, String arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub
    }

    @Override
    public void checkPermission(PrincipalCollection arg0, Permission arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkPermissions(PrincipalCollection arg0, String... arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkPermissions(PrincipalCollection arg0,
            Collection<Permission> arg1) throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkRole(PrincipalCollection arg0, String arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkRoles(PrincipalCollection arg0, Collection<String> arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkRoles(PrincipalCollection arg0, String... arg1)
            throws AuthorizationException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasAllRoles(PrincipalCollection arg0, Collection<String> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasRole(PrincipalCollection arg0, String hole) {
        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            Login login = (Login) sessao.getAttribute("usuarioLogado");

            if (login != null) {
                if (login.getPerfilAcesso()!= null) {
                    if (login.getPerfilAcesso().get(0).getPerfilAcesso().getDescricao().contains(hole)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean[] hasRoles(PrincipalCollection arg0, List<String> arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermitted(PrincipalCollection arg0, String nomeFuncao) {

        return SecurityUtil.temPermissao(nomeFuncao);

        //return SecurityUtil.temPermissao(nomeFuncao);
    }

    @Override
    public boolean isPermitted(PrincipalCollection arg0, Permission arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection arg0, String... arg1) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection arg0, List<Permission> arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection arg0, String... arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection arg0,
            Collection<Permission> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Autenticação do usuário.
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AuthenticationInfo info = null;

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            String chave = (String) token.getPrincipal();

            logger.info(String.format("Autenticando credenciais para o email %s ", chave));

//            LoginDAO loginDAO = new LoginDAOImpl(entityManager);
//            LoginService loginService = new LoginServiceImpl(loginDAO, null);
//
//            entityManager.getTransaction().begin(); // Inicia transação;
            LoginRepository loginDAO = new LoginRepository(entityManager);
            LoginService loginService = new LoginServiceImpl(loginDAO);

            entityManager.getTransaction().begin(); // Inicia transação;
            Login login = loginService.porChave(chave,TipoLoginEnum.EXTERNO.getTipo());
            entityManager.getTransaction().commit(); // Finaliza transação;
            entityManager.close();
            JpaUtil.closeEntityManagerFactory();
            loginService = null;
//            LoginService loginService = new LoginServiceImpl();
//            Login login = loginService.porChave(chave);

            String senhaUsuario = CipherUtil.decodeDES(CipherUtil.WEB_KEY,login.getSenha());

            info = new SimpleAuthenticationInfo(chave, senhaUsuario, getName());
            SimpleCredentialsMatcher cmatcher = new SimpleCredentialsMatcher();

            boolean credentialsMatch = cmatcher.doCredentialsMatch(token, info);

            // Credenciais não corresponderam, a autenticação falhou.
            if (!credentialsMatch) {
                throw new AuthenticationException("E-Mail inválido!");
            }

            Session sessao = SecurityUtils.getSubject().getSession();
            sessao.setAttribute("usuarioLogado", login);

            logger.info("Usuário informado na sessão.\n");
            logger.info(String.format("%s autenticado com sucesso", chave));

        } catch (Exception ex) {

            logger.error(String.format("Erro durante autenticação: %s \n", ex.getMessage()));
            throw new AuthenticationException(String.format("Erro durante autenticação: %s", ex.getMessage()));

        } finally {

            if (entityManager.isOpen()) {
                entityManager.close();
                JpaUtil.closeEntityManagerFactory();
            }

        }

        return info;
    }

    @Override
    public String getName() {
        return "PortoNect - Portal";
    }

    @Override
    public boolean supports(AuthenticationToken arg0) {
        return true;
    }

}
