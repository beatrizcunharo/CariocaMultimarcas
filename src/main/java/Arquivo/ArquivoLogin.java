package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    
    public boolean input(){
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
        }
        return false;
    }
     
   
    public void output(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Login>>() {}.getType();
        File nome = new File("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            String collect = br.lines().collect(Collectors.joining());
            List<Login> lista = gson.fromJson(collect, tipo);
            for (Login lista1 : lista) {
                System.out.println(lista1.getUsuario());
                System.out.println(lista1.getSenha());
                System.out.println(lista1.getTipo());
            }
        }catch (IOException e){
            e.printStackTrace();
        }        
 
    }
}
