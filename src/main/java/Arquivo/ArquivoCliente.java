package Arquivo;

import Registros.Endereco;
import Registros.PessoaFisica;
import Registros.PessoaJuridica;
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

public class ArquivoCliente {
    public List<PessoaFisica> clientef;
    public List<PessoaJuridica> clientej;
    public List<Endereco> enderecoF;
    public List<Endereco> enderecoJ;


    
    public ArquivoCliente(){
        this.clientef = new ArrayList<>();
        this.clientej = new ArrayList<>();
        this.enderecoF = new ArrayList<>();
        this.enderecoJ = new ArrayList<>();
         
    }
    
    public void cadastraPessoaFisica(String tipo, String nome, String cpf, String sexo, String telefone, String dataNasc, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero) throws IOException{
        PessoaFisica p = new PessoaFisica();
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
        enderecoF.add(e);
        clientef.add(p);
        inputEnderecoF();
    }
    
    public void cadastraPessoaJuridica(String tipo, String nome, String cnpj, String ie, String telefone, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero) throws IOException{
        PessoaJuridica p = new PessoaJuridica();
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
        enderecoJ.add(e);
        clientej.add(p);
        inputEnderecoJ();
        
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
    
    public boolean inputEnderecoF() throws IOException{
        Type tipoLista = new TypeToken<List<Endereco>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(enderecoF, tipoLista);
        
        File file = new File("arquivoEnderF.json");
          
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
    public boolean inputEnderecoJ() throws IOException{
        Type tipoLista = new TypeToken<List<Endereco>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(enderecoJ, tipoLista);
        File file = new File("arquivoEnderJ.json");
          
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
    
    public List<PessoaFisica> outputPessoaFisica(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<PessoaFisica>>() {}.getType();
        File nome = new File("arquivoClienteFisico.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<PessoaFisica> lista = gson.fromJson(collect, tipo);
            
            clientef.clear();
            clientef.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    public List<PessoaJuridica> outputPessoaJuridica(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<PessoaJuridica>>() {}.getType();
        File nome = new File("arquivoClienteJuridico.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<PessoaJuridica> lista = gson.fromJson(collect, tipo);
           
            clientej.clear();
            clientej.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }

    public List<Endereco> outputEnderecoFisico(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Endereco>>() {}.getType();
        File nome = new File("arquivoEnderF.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<Endereco> lista = gson.fromJson(collect, tipo);
            
            enderecoF.clear();
            enderecoF.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }
    public List<Endereco> outputEnderecoJuridico(){
        
        Gson gson = new Gson();
        Type tipo = new TypeToken<List<Endereco>>() {}.getType();
        File nome = new File("arquivoEnderJ.json");
        try{
            BufferedReader br = new BufferedReader(new FileReader(nome));
            
            String collect = br.lines().collect(Collectors.joining());
            
            List<Endereco> lista = gson.fromJson(collect, tipo);
            
            enderecoJ.clear();
            enderecoJ.addAll(lista);
            return lista;
        }catch (IOException e){
            e.printStackTrace();
        }       
        return null;
    }

    public boolean excluirPessoaFisica(String cpf) throws IOException{
        Type tipoLista = new TypeToken<List<PessoaFisica>>() {}.getType();
        Type tipoEnder = new TypeToken<List<Endereco>>() {}.getType();
        File fileP = new File("arquivoClienteFisico.json");
        File fileE = new File("arquivoEnderF.json");
        Gson gson = new Gson();
        List<PessoaFisica> p = outputPessoaFisica();
        List<Endereco> ef = outputEnderecoFisico();
        for(int i=0;i<clientef.size();i++){
            if(clientef.get(i).getCpf().equals(cpf)){
                clientef.remove(i);
                enderecoF.remove(i);
                ef.remove(i);
                p.remove(i);
                fileP.delete();
                fileE.delete();
                FileWriter inputP = new FileWriter(fileP);
                FileWriter inputE = new FileWriter(fileE);
                String jsonP = gson.toJson(p, tipoLista);
                String jsonE = gson.toJson(ef, tipoEnder);
                inputP.write(jsonP);
                inputE.write(jsonE);
                inputP.close();
                inputE.close();
                return true;
            }
        }
        return false;
    }
    public boolean excluirPessoaJuridica(String cnpj) throws IOException{
        Type tipoLista = new TypeToken<List<PessoaJuridica>>() {}.getType();
        Type tipoEnder = new TypeToken<List<Endereco>>() {}.getType();
        File fileP = new File("arquivoClienteJuridico.json");
        File fileE = new File("arquivoEnderJ.json");
        Gson gson = new Gson();
        List<PessoaJuridica> j = outputPessoaJuridica();
        List<Endereco> ej = outputEnderecoJuridico();
        for(int i=0;i<clientej.size();i++){
            if(clientej.get(i).getCnpj().equals(cnpj)){
                clientej.remove(i);
                enderecoJ.remove(i);
                ej.remove(i);
                j.remove(i);
                fileP.delete();
                fileE.delete();
                FileWriter inputP = new FileWriter(fileP);
                FileWriter inputE = new FileWriter(fileE);
                String jsonP = gson.toJson(j, tipoLista);
                String jsonE = gson.toJson(ej, tipoEnder);
                inputP.write(jsonP);
                inputE.write(jsonE);
                inputP.close();
                inputE.close();
                return true;
            }
        }
        return false;
    }
    
    public void alterarFisico(String tipo, String nome, String cpf, String sexo, String telefone, String dataNasc, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero, int pos) throws IOException{
        
        Type tipoF = new TypeToken<List<PessoaFisica>>() {}.getType();
        Type tipoE = new TypeToken<List<Endereco>>() {}.getType();
        Gson gson = new Gson();
        List<PessoaFisica> f = outputPessoaFisica();
        List<Endereco> ef = outputEnderecoFisico();
        f.get(pos).setTipo(tipo);
        f.get(pos).setNome(nome);
        f.get(pos).setCpf(cpf);
        f.get(pos).setSexo(sexo);
        f.get(pos).setTelefone(telefone);
        f.get(pos).setDataNasc(dataNasc);
        f.get(pos).setNumCompras(numCompras);
        f.get(pos).setDataRegistro(dataRegis);
        ef.get(pos).setBairro(bairro);
        ef.get(pos).setRua(rua);
        ef.get(pos).setCEP(CEP);
        ef.get(pos).setComplemento(complemento);
        ef.get(pos).setCidade(cidade);
        ef.get(pos).setPais(pais);
        ef.get(pos).setEstado(estado);
        ef.get(pos).setNumero(numero);
        clientef.addAll(f);
        enderecoF.addAll(ef);
        String jsonP = gson.toJson(f, tipoF);
        File fileP = new File("arquivoClienteFisico.json");
        String jsonE = gson.toJson(ef, tipoE);
        File fileE = new File("arquivoEnderF.json");
        fileP.delete();
        fileE.delete();
        FileWriter inputP = new FileWriter(fileP);
        FileWriter inputE = new FileWriter(fileE);
        inputP.write(jsonP);
        inputE.write(jsonE);
        inputP.close(); 
        inputE.close(); 
    }  
    public void alterarJuridico(String tipo, String nome, String cnpj, String ie, String telefone, int numCompras, String dataRegis, String bairro, String rua, String CEP, String complemento,String cidade, String pais, String estado, int numero, int pos) throws IOException{
        
        Type tipoJ = new TypeToken<List<PessoaJuridica>>() {}.getType();
        Type tipoE = new TypeToken<List<Endereco>>() {}.getType();
        Gson gson = new Gson();
        List<PessoaJuridica> j = outputPessoaJuridica();
        List<Endereco> ej = outputEnderecoJuridico();
        j.get(pos).setTipo(tipo);
        j.get(pos).setNome(nome);
        j.get(pos).setCnpj(cnpj);
        j.get(pos).setIe(ie);
        j.get(pos).setTelefone(telefone);
        j.get(pos).setNumCompras(numCompras);
        j.get(pos).setDataRegistro(dataRegis);
        ej.get(pos).setBairro(bairro);
        ej.get(pos).setRua(rua);
        ej.get(pos).setCEP(CEP);
        ej.get(pos).setComplemento(complemento);
        ej.get(pos).setCidade(cidade);
        ej.get(pos).setPais(pais);
        ej.get(pos).setEstado(estado);
        ej.get(pos).setNumero(numero);
        clientej.addAll(j);
        enderecoJ.addAll(ej);
        String jsonP = gson.toJson(j, tipoJ);
        File fileP = new File("arquivoClienteJuridico.json");
        String jsonE = gson.toJson(ej, tipoE);
        File fileE = new File("arquivoEnderJ.json");
        fileP.delete();
        fileE.delete();
        FileWriter inputP = new FileWriter(fileP);
        FileWriter inputE = new FileWriter(fileE);
        inputP.write(jsonP);
        inputE.write(jsonE);
        inputP.close(); 
        inputE.close(); 
    } 

}
