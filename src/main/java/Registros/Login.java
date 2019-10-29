package Registros;
import Arquivo.Informacao;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Login{
    private String usuario;
    private String senha;
    private String tipo;
    private List<String> info = new ArrayList<>();
    
    
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
        info.add(getUsuario());
        info.add(getSenha());
        info.add(getTipo());
        if(info.isEmpty())
            return false;
        else{
            i.input(info);
            return true;
        }        
    }
    public void imprime(){
        for(int i=0;i<info.size();i++)
            System.out.println(info.get(i));
    }
}





