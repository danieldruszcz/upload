/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.beans;

import bd.io.GeralDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.jboss.logging.Logger;

import static web.util.JSFUtil.addErrorMessage;
import static web.util.JSFUtil.addInfoMessage;
import web.util.SessionContext;
import web.util.UsuarioBO;
import web.util.UsuarioLogado;

/**
 *
 * @author DanielDruszcz
 */
@SessionScoped
@ManagedBean(name = "usuarioLogado")
public class BeanLogin {
    
    private static final long serialVersionUID = 1L;
    
    private static Logger logger = Logger.getLogger(BeanLogin.class);
    private String login;
    private String senha;
    private UsuarioBO userBO = new UsuarioBO();
    
    public UsuarioLogado getUser() {
        return (UsuarioLogado) SessionContext.getInstance().getUsuarioLogado();
    }

    public String doLogin() {
        try {
            UsuarioLogado user =(UsuarioLogado) userBO.isUsuarioReadyToLogin(this.login, this.senha);
            if (user == null) {
                addErrorMessage("Login ou Senha errado, tente novamente !");
                FacesContext.getCurrentInstance().validationFailed();
                return "";
            }
//            GeralDAO dao = new GeralDAO();
//            BeanLogin usuario = dao.findUser(login, senha);
            logger.info("Login efetuado com sucesso");
            SessionContext.getInstance().setAttribute("usuarioLogadoS", user);
            return "/pgs/upload.xhtml?faces-redirect=true";
        } catch (Exception e) {
            addErrorMessage(e.getMessage());
            FacesContext.getCurrentInstance().validationFailed();
            e.printStackTrace();
            return "";
        }
    }

    public String doLogout() {
        logger.info("Fazendo logout com usuário " + SessionContext.getInstance().getUsuarioLogado().getLogin());
        SessionContext.getInstance().encerrarSessao();
        addInfoMessage("Logout realizado com sucesso !");
        return "/security/form_login.xhtml?faces-redirect=true";
    }

//    public void solicitarNovaSenha() {
//        try {
//            getUserBO().gerarNovaSenha(login, email);
//            addInfoMessage("Nova Senha enviada para o email " + email);
//        } catch (Exception e) {
//            addErrorMessage(e.getMessage());
//            FacesContext.getCurrentInstance().validationFailed();
//        }
//    }

    public UsuarioBO getUserBO() {
        return userBO;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String nome) {
        this.login = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
