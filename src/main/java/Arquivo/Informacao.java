package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
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
    public boolean inputLogin(){
        String arquivo = "C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json";
        Type tipoLista = new TypeToken<List<String>>() {}.getType();
        List<String> lista = new LinkedList<String>();
        Login l = new Login();
        //lista.addAll(l.info);

        Gson gson = new Gson();
        String json = gson.toJson(lista, tipoLista);
        List<String> lista2 = gson.fromJson(json, tipoLista);
        try{
            
            FileWriter input = new FileWriter("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json");
            
            input.write(json);
            input.close();
            System.out.println(json);
            return true;
        }catch(IOException ex){
            ex.printStackTrace();
            return false;
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
