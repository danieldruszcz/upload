/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.io;

import bd.cf.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import web.beans.BeanCadastro;
import web.beans.BeanLogin;
import web.util.UsuarioLogado;

/**
 *
 * @author DanielDruszcz
 */
public class GeralDAO {
     private Connection connection;

    public GeralDAO() throws SQLException, IOException, ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirUser(BeanCadastro cadastro) throws IOException {
        String sql = "insert into users(nome, sobrenome,senha)"
                + "values(?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getSobrenome());
            stmt.setString(3, cadastro.getSenha());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um cliente no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexÃ£o. Ex=" + ex.getMessage());
            };
        }
    }
    public UsuarioLogado findUser(String nome, String senha){
       String sql = "select nome,senha from users where nome = ? and senha = ?";
       UsuarioLogado login = new UsuarioLogado();  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
           
            if(rs.next()){
           
               login.setLogin(rs.getString("nome"));
               login.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um cliente no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexÃ£o. Ex=" + ex.getMessage());
            };
        }
        return login;
    }
}
