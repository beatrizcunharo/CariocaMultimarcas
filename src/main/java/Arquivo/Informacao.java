package Arquivo;

import Registros.Logins;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
public class Informacao {
    public List<Logins> logins = new ArrayList<>();
    
    
    public void inputLogin(){
        Type tipoLista = new TypeToken<List<Logins>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(logins, tipoLista);
        
        try{
            
            FileWriter input = new FileWriter("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json");
            
            input.write(json);
            input.close();
            System.out.println(json);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    /*
    public void outputLogin(){ 
        Gson gson = new Gson();
 
        try {
 
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Beatr\\Documents\\arquivo.json"));
 
            //Converte String JSON para objeto Java
            Login obj = gson.fromJson(br, Login.class);
 
            System.out.println(obj);
 
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    */  
}
