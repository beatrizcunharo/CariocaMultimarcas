package Arquivo;

import Registros.Blusas;
import Registros.Calcas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
public class ArquivoEstoque {
    List<Blusas> blusas;
    List<Calcas> calcas;
    
    public ArquivoEstoque(){
        this.blusas = new ArrayList<>();
        this.calcas = new ArrayList<>();
    }
    
    public void cadastraBlusas(int codigo, String nome, String tipo, String tamanho, String sexo, int quant,double valor, String dataRegis){
        Blusas b = new Blusas();
        
        b.setCodigo(codigo);
        b.setNome(nome);
        b.setTipo(tipo);
        b.setTamanho(tamanho);
        b.setSexo(sexo);
        b.setQtde(quant);
        b.setValor(valor);
        b.setDataRegistro(dataRegis);
        blusas.add(b);
        
    }
    public void cadastraCalcas(int codigo, String nome, String tipo, int num, String sexo, int quant,double valor, String dataRegis){
        Calcas c = new Calcas();
        
        c.setCodigo(codigo);
        c.setNome(nome);
        c.setTipo(tipo);
        c.setNumero(num);
        c.setSexo(sexo);
        c.setQtde(quant);
        c.setValor(valor);
        c.setDataRegistro(dataRegis);
        calcas.add(c);
        
    }

    public boolean inputBlusas() throws IOException{
        Type tipoLista = new TypeToken<List<Blusas>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(blusas, tipoLista);
        
        File file = new File("arquivoBlusas.json");
          
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
    public boolean inputCalcas() throws IOException{
        Type tipoLista = new TypeToken<List<Calcas>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(calcas, tipoLista);
        
        File file = new File("arquivoCalcas.json");
          
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
