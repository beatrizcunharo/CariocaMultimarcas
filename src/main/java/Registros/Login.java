package Registros;
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
    public boolean cadastra(List<String> lista){
        for(int i=0;i<lista.size();i++){
            info.add(lista.get(i));
        }
        if(info.isEmpty())
            return false;
        else
            return true;
    }
    
    public void imprime(){
        JOptionPane.showMessageDialog(null,info);
    }
    
}





