package Arquivo;

import Registros.PessoaFisica;
import Registros.Produto;
import Registros.VendaAPrazo;
import Registros.VendaAVista;
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

    public void cadastraVendaPrazo(int codigoVenda,String tipoVenda,String tipoPessoa, String cpf, String cnpj, int codProd, String tipoProduto,String dataRegis, int qtde, double valorTotal, int parcelas, double valorParcela){
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
}
