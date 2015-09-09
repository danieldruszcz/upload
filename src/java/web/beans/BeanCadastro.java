package web.beans;

import bd.io.GeralDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import org.jboss.weld.logging.Category;
import web.util.JSFUtil;
 
@ManagedBean
public class BeanCadastro {
     
    private String nome;
    private String sobrenome;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrar() throws SQLException, IOException, ClassNotFoundException{
        GeralDAO dao = new GeralDAO();
        dao.inserirUser(this);
        cleanAll();
        JSFUtil.addInfoMessage("Sua solicitação foi registrada. Aguarde a validação do ADM.");
    }
    
    private void cleanAll(){
     this.nome = null;
     this.sobrenome = null;
     this.senha = null;
    }
}