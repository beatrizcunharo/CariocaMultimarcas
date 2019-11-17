package Arquivo;

import Registros.Endereco;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class ArquivoEndereco {
    public List<Endereco> endereco;
    
    public ArquivoEndereco(){
        this.endereco = new ArrayList<>();
    }
    
    public void cadastra(Endereco e){
        endereco.add(e);
    }
    
    public boolean input() throws IOException{
        Type tipoLista = new TypeToken<List<Endereco>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(endereco, tipoLista);
        
        File file = new File("arquivoEnder.json");
          
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
}
