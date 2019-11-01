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
public class Login{
    private String usuario;
    private String senha;
    private String tipo;
    List<String> info = new ArrayList<>();
    
    
    public Login(){
        usuario = " ";
        senha = " ";
        tipo = " ";
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public boolean cadastra(String user, String senha, String tipo){
        Informacao i = new Informacao();
        setUsuario(user);
        setSenha(senha);
        setTipo(tipo);
        info.add(user);
        info.add(senha);
        info.add(tipo);
        if(info.isEmpty())
            return false;
        else{
            i.inputLogin(info);
            return true;
        }
    }
}





