package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class ArquivoLogin {
    public List<Login> logins;
    
    
    public ArquivoLogin(){
        this.logins = new ArrayList<>();
    }
    
    public void cadastra(String user, String senha, String tipo){
        Login l = new Login();      
        l.setUsuario(user);
        l.setSenha(senha);
        l.setTipo(tipo);
        logins.add(l);  
    }
    
    public boolean inputLogin(){
        Type tipoLista = new TypeToken<List<Login>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(logins, tipoLista);
        
        try{
            
            FileWriter input = new FileWriter("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json");
            
            input.write(json);
            input.close();
            return true;
        }catch(IOException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    
    /*public Login outputLogin(){ 
        Gson gson = new Gson();
        
        
        try {
 
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json"));
 
            //Converte String JSON para objeto Java
            Login obj = gson.fromJson(br, Login.class);
 
            System.out.println(obj);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }   
    }
    */
}
