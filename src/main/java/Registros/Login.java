package Registros;


/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Login {
    private String usuario;
    private String senha;
    private String tipo;
    
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
    
    /*public boolean cadastraLogin(){
        Login login = new Login();
        JSONObject loginJ = new JSONObject();
    }*/
}





