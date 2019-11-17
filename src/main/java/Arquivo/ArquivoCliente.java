package Arquivo;

import Registros.Endereco;
import Registros.Pessoa;
import Registros.PessoaFisica;
import Registros.PessoaJuridica;
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
import java.util.Date;
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

public class ArquivoCliente {
    public List<PessoaFisica> clientef;
    public List<PessoaJuridica> clientej;
    
    
    public ArquivoCliente(){
        this.clientef = new ArrayList<>();
        this.clientej = new ArrayList<>();
    }
    
    public void cadastraPessoaFisica(String tipo, String nome, String cpf, String sexo, String telefone, String dataNasc, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero){
        PessoaFisica p = new PessoaFisica();
        ArquivoEndereco ender = new ArquivoEndereco();
        Endereco e = new Endereco();
        p.setTipo(tipo);
        p.setCpf(cpf);
        p.setDataNasc(dataNasc);
        p.setDataRegistro(dataRegis);
        p.setNome(nome);
        p.setNumCompras(numero);
        p.setSexo(sexo);
        p.setTelefone(telefone);
        e.setBairro(bairro);
        e.setCEP(CEP);
        e.setCidade(cidade);
        e.setComplemento(complemento);
        e.setEstado(estado);
        e.setNumero(numero);
        e.setPais(pais);
        e.setRua(rua);
        p.setEndereco(e);
        ender.cadastra(e);
        clientef.add(p);
    }
    
    public void cadastraPessoaJuridica(String tipo, String nome, String cnpj, String ie, String telefone, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero){
        PessoaJuridica p = new PessoaJuridica();
        ArquivoEndereco ender = new ArquivoEndereco();
        Endereco e = new Endereco();
        p.setTipo(tipo);
        p.setCnpj(cnpj);
        p.setIe(ie);
        p.setDataRegistro(dataRegis);
        p.setNome(nome);
        p.setNumCompras(numero);
        p.setTelefone(telefone);
        e.setBairro(bairro);
        e.setCEP(CEP);
        e.setCidade(cidade);
        e.setComplemento(complemento);
        e.setEstado(estado);
        e.setNumero(numero);
        e.setPais(pais);
        e.setRua(rua);
        p.setEndereco(e);
        ender.cadastra(e);
        clientej.add(p);
    }
    
    public void inputPessoaFisica() throws IOException{
        Type tipoLista = new TypeToken<List<PessoaFisica>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(clientef, tipoLista);
        
        File file = new File("arquivoClienteFisico.json");
          
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
    public void inputPessoaJuridica() throws IOException{
        Type tipoLista = new TypeToken<List<PessoaJuridica>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(clientej, tipoLista);
        
        File file = new File("arquivoClienteJuridico.json");
          
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
