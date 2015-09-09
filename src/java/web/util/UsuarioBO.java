/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.util;

import bd.io.GeralDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import web.beans.BeanLogin;

/**
 *
 * @author DanielDruszcz
 */
public class UsuarioBO {
    public UsuarioLogado isUsuarioReadyToLogin(String email, String senha) { 
            UsuarioLogado login = new UsuarioLogado();
            GeralDAO dao;
        try {
            dao = new GeralDAO();
            login = dao.findUser( email, senha );
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
}
