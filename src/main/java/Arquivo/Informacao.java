package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author Beatr
 */
public class Informacao {
    public void input(List <String> info){
        Gson gson = new Gson();
        String g = gson.toJson(info);
        try{
            FileWriter input = new FileWriter("C:\\Users\\Beatr\\Documents\\arquivo.json");
            input.write(g);
            input.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println(g);
    }
    
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
        
}
