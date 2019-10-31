package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Beatr
 */
public class Informacao {
    public void inputLogin(List<String> info){
        Type tipoLista = new TypeToken<List<String>>() {}.getType();
        List<String> lista = new LinkedList<String>();
        lista.addAll(info);

        Gson gson = new Gson();
        String json = gson.toJson(lista, tipoLista);
        List<String> lista2 = gson.fromJson(json, tipoLista);
        try{
            FileWriter input = new FileWriter("C:\\Users\\Beatr\\Documents\\GitHub\\TrabalhoOO\\arquivoLogin.json");
            input.write(json);

            input.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println(json);
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
