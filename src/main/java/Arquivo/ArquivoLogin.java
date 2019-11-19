package Arquivo;

import Registros.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
    

    public boolean input() throws IOException{
        Type tipoLista = new TypeToken<List<Login>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(logins, tipoLista);
        
        File file = new File("arquivoLogin.json");
          
            if(file.exists()){
                
                Writer fw = new OutputStreamWriter( new FileOutputStream(file) ) ;
                fw.write(json);
                fw.close();
            }else{
                
                FileWriter input = new FileWriter(file);
            
                input.write(json);
                input.close();
                return true;
            }
            return false;
        }   
    
    public void alterar(String user, String senha, String tipo, int pos) throws IOException{
        
        Type tipoLista = new TypeToken<List<Login>>() {}.getType();
        Gson gson = new Gson();
        List<Login> lista = output();
        lista.get(pos).setUsuario(user);
        lista.get(pos).setSenha(senha);
        lista.get(pos).setTipo(tipo);
        logins.addAll(lista);
        String json = gson.toJson(lista, tipoLista);
        File file = new File("arquivoLogin.json");
        file.delete();
        FileWriter input = new FileWriter(file);
        input.write(json);
        input.close(); 
        
    }   
    
    public List<Login> output(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Login>>() {}.getType();
        File nome = new File("arquivoLogin.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<Login> lista = gson.fromJson(collect, tipo);
         
            logins.clear();
            logins.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    
    public boolean excluir(String user) throws IOException{
        Type tipoLista = new TypeToken<List<Login>>() {}.getType();
        File file = new File("arquivoLogin.json");
        Gson gson = new Gson();
        List<Login> l = output();
        for(int i=0;i<logins.size();i++){
            if(logins.get(i).getUsuario().equals(user)){
                logins.remove(i);
                l.remove(i);
                file.delete();
                FileWriter input = new FileWriter(file);
                String json = gson.toJson(l, tipoLista);
                input.write(json);
                input.close();
                return true;
            }
        }
        return false;
    }
}
