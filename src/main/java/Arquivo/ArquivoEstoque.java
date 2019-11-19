package Arquivo;

import Registros.Blusas;
import Registros.Calcas;
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
    
    public List<Blusas> outputBlusas(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Blusas>>() {}.getType();
        File nome = new File("arquivoBlusas.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<Blusas> lista = gson.fromJson(collect, tipo);
            
            blusas.clear();
            blusas.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    public List<Calcas> outputCalcas(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Calcas>>() {}.getType();
        File nome = new File("arquivoCalcas.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<Calcas> lista = gson.fromJson(collect, tipo);
         
            calcas.clear();
            calcas.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    
    public boolean excluir(String nome) throws IOException{
        Type tipoB = new TypeToken<List<Blusas>>() {}.getType();
        Type tipoC = new TypeToken<List<Calcas>>() {}.getType();
        File fileB = new File("arquivoBlusas.json");
        File fileC = new File("arquivoCalcas.json");
        Gson gson = new Gson();
        List<Blusas> b = outputBlusas();
        List<Calcas> c = outputCalcas();
        boolean valida = false;
        for(int i=0;i<b.size();i++){
            if(b.get(i).getNome().equals(nome)){
                blusas.remove(i);
                b.remove(i);
                fileB.delete();
                FileWriter input = new FileWriter(fileB);
                String json = gson.toJson(b, tipoB);
                input.write(json);
                input.close();
                valida = true;
            }
        }
        for(int i=0;i<c.size();i++){
            if(c.get(i).getNome().equals(nome)){
                calcas.remove(i);
                c.remove(i);
                fileC.delete();
                FileWriter input = new FileWriter(fileC);
                String json = gson.toJson(c, tipoC);
                input.write(json);
                input.close();
                valida = true;
            }
        }
        return valida;
    }
    
    public void alterarBlusas(String nome, String tipo, String tamanho, String sexo, int quant,double valor, String dataRegis, int pos) throws IOException{
        
        Type tipoLista = new TypeToken<List<Blusas>>() {}.getType();
        Gson gson = new Gson();
        List<Blusas> lista = outputBlusas();
        lista.get(pos).setNome(nome);
        lista.get(pos).setTipo(tipo);
        lista.get(pos).setTamanho(tamanho);
        lista.get(pos).setSexo(sexo);
        lista.get(pos).setQtde(quant);
        lista.get(pos).setValor(valor);
        lista.get(pos).setDataRegistro(dataRegis);
        
        blusas.addAll(lista);
        String json = gson.toJson(lista, tipoLista);
        File file = new File("arquivoBlusas.json");
        file.delete();
        FileWriter input = new FileWriter(file);
        input.write(json);
        input.close(); 
        
    }
    public void alterarCalcas(String nome, String tipo, int num, String sexo, int quant,double valor, String dataRegis, int pos) throws IOException{
        
        Type tipoLista = new TypeToken<List<Calcas>>() {}.getType();
        Gson gson = new Gson();
        List<Calcas> lista = outputCalcas();
        lista.get(pos).setNome(nome);
        lista.get(pos).setTipo(tipo);
        lista.get(pos).setNumero(num);
        lista.get(pos).setSexo(sexo);
        lista.get(pos).setQtde(quant);
        lista.get(pos).setValor(valor);
        lista.get(pos).setDataRegistro(dataRegis);
        
        calcas.addAll(lista);
        String json = gson.toJson(lista, tipoLista);
        File file = new File("arquivoCalcas.json");
        file.delete();
        FileWriter input = new FileWriter(file);
        input.write(json);
        input.close(); 
        
    }
}
