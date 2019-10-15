package com.prumo.portonect.security;

import com.prumo.portonect.entity.Login;
import com.prumo.portonect.entity.PerfilAcessoLogin;
import com.prumo.portonect.enums.TipoLoginEnum;
import com.prumo.portonect.repository.LoginRepository;
import com.prumo.portonect.service.LoginService;
import com.prumo.portonect.service.impl.LoginServiceImpl;
import com.prumo.portonect.util.JpaUtil;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.activedirectory.ActiveDirectoryRealm;
import org.apache.shiro.realm.ldap.LdapContextFactory;
import org.apache.shiro.realm.ldap.LdapUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import java.util.*;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.ldap.AbstractLdapRealm;
import org.apache.shiro.session.Session;
//ActiveDirectoryRealm

public class LdapRealm extends AbstractLdapRealm {

    private Logger logger = LoggerFactory.getLogger(LdapRealm.class);
    private static final String ROLE_NAMES_DELIMETER = ",";
//    @Inject private LoginService loginService;

    /**
     * Mapping from fully qualified active directory group names (e.g.
     * CN=Group,OU=Company,DC=MyDomain,DC=local) as returned by the active
     * directory LDAP server to role names.
     */
    private Map<String, String> groupRolesMap;

    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        // Perform context search
        //LdapContext ldapContext = ldapContextFactory.getSystemLdapContext();

        Set<String> permNames = null;

        /*
        try
        {
            permNames = getPermNamesForRole( roleString, ldapContext );
        }
        catch (NamingException ne)
        {
            log.error( "nameingexception=" + ne );
        }
        finally
        {
            LdapUtils.closeContext(ldapContext);
        }
         */
        //return permNames;
        return null;
    }

    private Set<String> getPermNamesForRole(String roleName, LdapContext ldapContext) throws NamingException {
        Set<String> permNames;
        permNames = new LinkedHashSet<String>();

        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        //String userPrincipalName = username;
        //if (principalSuffix != null) {
        //    userPrincipalName += principalSuffix;
        //}
        //SHIRO-115 - prevent potential code injection:
        //String searchFilter = "(&(objectClass=*)(userPrincipalName={0}))";
        String searchFilter = "(&(objectClass=*)(ftRoles={0}))";
        Object[] searchArguments = new Object[]{roleName};

        NamingEnumeration answer = ldapContext.search("OU=Sites,DC=prumologistica,DC=local", searchFilter, searchArguments, searchCtls);

        while (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();

            if (logger.isDebugEnabled()) {
                logger.debug("Retrieving group names for perm [" + sr.getName() + "]");
            }

            Attributes attrs = sr.getAttributes();

            if (attrs != null) {
                NamingEnumeration ae = attrs.getAll();
                while (ae.hasMore()) {
                    Attribute attr = (Attribute) ae.next();

                    if (attr.getID().equals("ftRoles")) {
                        //if (attr.getID().equals("memberOf")) {

                        Collection<String> groupNames = LdapUtils.getAllAttributeValues(attr);

                        if (logger.isDebugEnabled()) {
                            logger.info("Perms found for role [" + roleName + "]: " + groupNames);
                        }

                        //Collection<String> rolesForGroups = getRoleNamesForGroups(groupNames);
                        //roleNames.addAll(rolesForGroups);
                    }
                }
            }
        }
        return permNames;
    }

    @Override
    public boolean hasRole(PrincipalCollection arg0, String hole) {
        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            Login login = (Login) sessao.getAttribute("usuarioLogado");

            if (login != null) {
                if (login.getPerfilAcesso() != null) {
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

//    @Override
//    protected AuthenticationInfo queryForAuthenticationInfo(AuthenticationToken token, LdapContextFactory ldapContextFactory) throws NamingException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    protected AuthenticationInfo queryForAuthenticationInfo(AuthenticationToken token, LdapContextFactory ldapContextFactory) throws NamingException {
        AuthenticationInfo info = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // Binds using the username and password provided by the user.
        LdapContext ctx = null;
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            
            LoginRepository loginDAO = new LoginRepository(entityManager);
            LoginService loginService = new LoginServiceImpl(loginDAO);

            entityManager.getTransaction().begin(); // Inicia transação;
            Login login = loginService.porChave(upToken.getUsername(),TipoLoginEnum.INTERNO.getTipo());
            entityManager.getTransaction().commit(); // Finaliza transação;
            entityManager.close();
            JpaUtil.closeEntityManagerFactory();
            loginService = null;
            if (login == null) {
                throw new AuthenticationException("Usuario nao encontrado");
            }
            
            ctx = ldapContextFactory.getLdapContext(upToken.getUsername() + principalSuffix, String.valueOf(upToken.getPassword()));
            info = new SimpleAuthenticationInfo(upToken.getUsername(), upToken.getCredentials(), getName());
            
            Session sessao = SecurityUtils.getSubject().getSession();
            sessao.setAttribute("usuarioLogado", login);
        } catch (Exception ex) {

            logger.error(String.format("Erro durante autenticação: %s \n", ex.getMessage()));
            throw new AuthenticationException(String.format("Erro durante autenticação: %s", ex.getMessage()));

        } finally {
            LdapUtils.closeContext(ctx);
        }

        return info;
    }

//    @Override
//    protected AuthorizationInfo queryForAuthorizationInfo(PrincipalCollection principal, LdapContextFactory ldapContextFactory) throws NamingException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     * Builds an {@link org.apache.shiro.authz.AuthorizationInfo} object by
     * querying the active directory LDAP context for the groups that a user is
     * a member of. The groups are then translated to role names by using the
     * configured {@link #groupRolesMap}.
     * <p/>
     * This implementation expects the <tt>principal</tt> argument to be a
     * String username.
     * <p/>
     * Subclasses can override this method to determine authorization data
     * (roles, permissions, etc) in a more complex way. Note that this default
     * implementation does not support permissions, only roles.
     *
     * @param principals the principal of the Subject whose account is being
     * retrieved.
     * @param ldapContextFactory the factory used to create LDAP connections.
     * @return the AuthorizationInfo for the given Subject principal.
     * @throws NamingException if an error occurs when searching the LDAP
     * server.
     */
    @Override
    protected AuthorizationInfo queryForAuthorizationInfo(PrincipalCollection principals, LdapContextFactory ldapContextFactory) throws NamingException {
        AuthorizationInfo info = null;
        String username = (String) getAvailablePrincipal(principals);
        Login login = new Login();
        try {

            EntityManager entityManager = JpaUtil.getEntityManager();
            LoginRepository loginRepository = new LoginRepository(entityManager);
            LoginService loginService = new LoginServiceImpl(loginRepository);
            
            String loginTratado = null;
            if(username.contains("@")) {
                username = username.substring(0, username.indexOf("@"));
            } 
            
            login = loginService.porChave(username,TipoLoginEnum.INTERNO.getTipo());
            
            if (login == null) {
                throw new AuthenticationException("E-Mail inválido!");
            }
            Session sessao = SecurityUtils.getSubject().getSession();
            sessao.setAttribute("usuarioLogado", login);
            
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LdapRealm.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Set<String> roleNames = new LinkedHashSet();
        
        for (PerfilAcessoLogin perfilAcessoLogin : login.getPerfilAcesso()) {
            roleNames.add(perfilAcessoLogin.getPerfilAcesso().getDescricao());
            
        }
//        Set<String> roleNames;
//
//        try {
//            roleNames = getRoleNamesForUser(username, ldapContext);
//        } finally {
//            LdapUtils.closeContext(ldapContext);
//        }
        info = new SimpleAuthorizationInfo(roleNames);

        return info;
    }
    
//    private Set<String> getRoleNamesForUser(String username, LdapContext ldapContext) throws NamingException {
//        Set<String> roleNames;
//        roleNames = new LinkedHashSet<String>();
//
//        SearchControls searchCtls = new SearchControls();
//        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//
//        String userPrincipalName = username;
//        if (principalSuffix != null) {
//            userPrincipalName += principalSuffix;
//        }
//
//        //SHIRO-115 - prevent potential code injection:
//        //String searchFilter = "(&(objectClass=*)(userPrincipalName={0}))";
//        String searchFilter = "(&(objectClass=*)(entryDN={0}))";
//        Object[] searchArguments = new Object[]{userPrincipalName};
//
//        NamingEnumeration answer = ldapContext.search(searchBase, searchFilter, searchArguments, searchCtls);
//
//        while (answer.hasMoreElements()) {
//            SearchResult sr = (SearchResult) answer.next();
//
//            if (logger.isDebugEnabled()) {
//                logger.debug("Retrieving group names for user [" + sr.getName() + "]");
//            }
//
//            Attributes attrs = sr.getAttributes();
//
//            if (attrs != null) {
//                NamingEnumeration ae = attrs.getAll();
//                while (ae.hasMore()) {
//                    Attribute attr = (Attribute) ae.next();
//
//                    if (attr.getID().equals("ftRA")) {
//                        //if (attr.getID().equals("memberOf")) {
//
//                        Collection<String> groupNames = LdapUtils.getAllAttributeValues(attr);
//
//                        if (logger.isDebugEnabled()) {
//                            logger.debug("Groups found for user [" + username + "]: " + groupNames);
//                        }
//
//                        Collection<String> rolesForGroups = getRoleNamesForGroups(groupNames);
//                        roleNames.addAll(rolesForGroups);
//                    }
//                }
//            }
//        }
//        return roleNames;
//    }
    /**
     * This method is called by the default implementation to translate Active
     * Directory group names to role names. This implementation uses the
     * {@link #groupRolesMap} to map group names to role names.
     *
     * @param groupNames the group names that apply to the current user.
     * @return a collection of roles that are implied by the given role names.
     */
//    @Override
//    protected Collection<String> getRoleNamesForGroups(Collection<String> groupNames) {
//        return groupNames;
//    }
}
