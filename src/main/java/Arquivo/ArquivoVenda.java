package Arquivo;

import Registros.VendaAPrazo;
import Registros.VendaAVista;
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
public class ArquivoVenda {
    public List<VendaAVista> vendaVista;
    public List<VendaAPrazo> vendaPrazo;
    
    public ArquivoVenda(){
        this.vendaVista = new ArrayList<>();
        this.vendaPrazo = new ArrayList<>();
    }
    
    
    public void cadastraVendaVista(int codigoVenda,String tipoVenda,String tipoPessoa, String cpf, String cnpj, int codProd, String tipoProduto,String dataRegis, int qtde, double valorTotal){
        VendaAVista vv = new VendaAVista();
        
        vv.setCodigo(codigoVenda);
        vv.setTipoVenda(tipoVenda);
        vv.setTipoPessoa(tipoPessoa);
        vv.setCpf(cpf);
        vv.setCnpj(cnpj);
        vv.setCodigoProduto(codProd);
        vv.setTipoProduto(tipoProduto);
        vv.setData(dataRegis);
        vv.setQtde(qtde);
        vv.setValor(valorTotal);
        vendaVista.add(vv);        
    }

    public void cadastraVendaPrazo(int codigoVenda,String tipoVenda,String tipoPessoa, String cpf, String cnpj, int codProd, String tipoProduto,String dataRegis, int qtde, double valorTotal, String parcelas, double valorParcela){
        VendaAPrazo vp = new VendaAPrazo();
        
        vp.setCodigo(codigoVenda);
        vp.setTipoVenda(tipoVenda);
        vp.setTipoPessoa(tipoPessoa);
        vp.setCpf(cpf);
        vp.setCnpj(cnpj);
        vp.setCodigoProduto(codProd);
        vp.setTipoProduto(tipoProduto);
        vp.setData(dataRegis);
        vp.setQtde(qtde);
        vp.setValor(valorTotal);
        vp.setParcelas(parcelas);
        vp.setValorParc(valorParcela);
        vendaPrazo.add(vp);        
    }
    
    public void inputVendaAVista() throws IOException{
        Type tipoLista = new TypeToken<List<VendaAVista>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(vendaVista, tipoLista);
        
        File file = new File("arquivoVendaVista.json");
          
            if(file.exists()){
                
                Writer fw = new OutputStreamWriter( new FileOutputStream(file) ) ;
                fw.write(json);
                fw.close();
            }else{
                
                FileWriter input = new FileWriter(file);
            
                input.write(json);
                input.close();
            }
    }   
    public void inputVendaAPrazo() throws IOException{
        Type tipoLista = new TypeToken<List<VendaAPrazo>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(vendaPrazo, tipoLista);
        
        File file = new File("arquivoVendaPrazo.json");
          
            if(file.exists()){
                
                Writer fw = new OutputStreamWriter( new FileOutputStream(file) ) ;
                fw.write(json);
                fw.close();
            }else{
                
                FileWriter input = new FileWriter(file);
            
                input.write(json);
                input.close();
            }
    }   

    public List<VendaAVista> outputVendaVista(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<VendaAVista>>() {}.getType();
        File nome = new File("arquivoVendaVista.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<VendaAVista> lista = gson.fromJson(collect, tipo);
         
            vendaVista.clear();
            vendaVista.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    public List<VendaAPrazo> outputVendaPrazo(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<VendaAPrazo>>() {}.getType();
        File nome = new File("arquivoVendaPrazo.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<VendaAPrazo> lista = gson.fromJson(collect, tipo);
         
            vendaPrazo.clear();
            vendaPrazo.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    
    public boolean excluir(int cod) throws IOException{
        Type tipoVista = new TypeToken<List<VendaAVista>>() {}.getType();
        Type tipoPrazo = new TypeToken<List<VendaAPrazo>>() {}.getType();
        File fileV = new File("arquivoVendaVista.json");
        File fileP = new File("arquivoVendaPrazo.json");
        Gson gson = new Gson();
        List<VendaAVista> vv = outputVendaVista();
        List<VendaAPrazo> vp = outputVendaPrazo();
        boolean valida = false;
        for(int i=0;i<vv.size();i++){
            if(vv.get(i).getCodigo() == cod){
                vendaVista.remove(i);
                vv.remove(i);
               
                    fileV.delete();
                    FileWriter input = new FileWriter(fileV);
                    String json = gson.toJson(vv, tipoVista);
                    input.write(json);
                    input.close();
                    valida = true;
                    break;
               
               
            }
        }
        for(int i=0;i<vp.size();i++){
            if(vp.get(i).getCodigo() == cod){
                vendaPrazo.remove(i);
                vp.remove(i);
                
                    fileP.delete();
                    FileWriter input = new FileWriter(fileP);
                    String json = gson.toJson(vp, tipoPrazo);
                    input.write(json);
                    input.close();
                    valida = true;
                    break;
                
            }
        }
        return valida;
    }
    
    public void alterarVendaVista(String tipoVenda,String tipoPessoa, String cpf, String cnpj, int codProd, String tipoProduto,String dataRegis, int qtde, double valorTotal, int pos) throws IOException{
        
        Type tipo = new TypeToken<List<VendaAVista>>() {}.getType();
        Gson gson = new Gson();
        List<VendaAVista> vv = outputVendaVista();
        
        vv.get(pos).setTipoVenda(tipoVenda);
        vv.get(pos).setTipoPessoa(tipoPessoa);
        vv.get(pos).setCpf(cpf);
        vv.get(pos).setCnpj(cnpj);
        vv.get(pos).setCodigoProduto(codProd);
        vv.get(pos).setTipoProduto(tipoProduto);
        vv.get(pos).setData(dataRegis);
        vv.get(pos).setQtde(qtde);
        vv.get(pos).setValor(valorTotal);
        vendaVista.addAll(vv);
        String json = gson.toJson(vv, tipo);
        File file = new File("arquivoVendaVista.json");
        file.delete();
        FileWriter input = new FileWriter(file);
        input.write(json);
        input.close(); 
    }  
    public void alterarVendaPrazo(String tipoVenda,String tipoPessoa, String cpf, String cnpj, int codProd, String tipoProduto,String dataRegis, int qtde, double valorTotal, String parcelas, double valorParcela, int pos) throws IOException{
        
        Type tipo = new TypeToken<List<VendaAPrazo>>() {}.getType();
        Gson gson = new Gson();
        List<VendaAPrazo> vp = outputVendaPrazo();
        
        vp.get(pos).setTipoVenda(tipoVenda);
        vp.get(pos).setTipoPessoa(tipoPessoa);
        vp.get(pos).setCpf(cpf);
        vp.get(pos).setCnpj(cnpj);
        vp.get(pos).setCodigoProduto(codProd);
        vp.get(pos).setTipoProduto(tipoProduto);
        vp.get(pos).setData(dataRegis);
        vp.get(pos).setQtde(qtde);
        vp.get(pos).setValor(valorTotal);
        vp.get(pos).setParcelas(parcelas);
        vp.get(pos).setValorParc(valorParcela);
        vendaPrazo.addAll(vp);
        String json = gson.toJson(vp, tipo);
        File file = new File("arquivoVendaPrazo.json");
        file.delete();
        FileWriter input = new FileWriter(file);
        input.write(json);
        input.close(); 
    }
    
}
