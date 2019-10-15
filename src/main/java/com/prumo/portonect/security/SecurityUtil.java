package com.prumo.portonect.security;

//import org.apache.shiro.SecurityUtils;
import com.prumo.portonect.entity.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

//import org.apache.shiro.session.Session;
//import br.com.senior.crm.entity.Funcao;
//import br.com.senior.crm.entity.Perfil;
//import br.com.senior.crm.entity.Usuario;
public class SecurityUtil {

    public static boolean temPermissao(String nomeFuncao) {
        try {
            Session sessao = SecurityUtils.getSubject().getSession();
            Login usuario = (Login) sessao.getAttribute("usuarioLogado");

            String[] funcoesTela = nomeFuncao.split(":");

            if (usuario != null) {
                if (usuario.getPerfilAcesso() != null) {
//                    for (Perfil perfil : usuario.getPerfils()) {

//                        if (usuario.getPerfilAcessoLogin().getPerfilAcessoLoginPK().perfil.getFuncaos() != null) {
//                            for (Funcao funcao : perfil.getFuncaos()) {
//                                for (String check : funcoesTela) {
//                                    if (funcao.getCodigo().contains(check)) {
//                                        return true;
//                                    }
                    if (usuario.getPerfilAcesso().get(0).getPerfilAcesso().getDescricao().contains(nomeFuncao)) {
                        return true;
                    }
//                                }
//                            }
//                        }
//                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
