package Registros;
import Arquivo.Informacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class Logins{
    private String usuario;
    private String senha;
    private String tipo;
    
    public Logins(){
        usuario = "";
        senha = "";
        tipo = "";
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void cadastra(String user, String senha, String tipo){
        Logins l = new Logins();
        Informacao i = new Informacao();
        l.setUsuario(user);
        l.setSenha(senha);
        l.setTipo(tipo);
        i.logins.add(l);
        i.inputLogin();
    }
}





