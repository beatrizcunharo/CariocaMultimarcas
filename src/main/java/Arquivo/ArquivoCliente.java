package Arquivo;

import Registros.Endereco;
import Registros.Pessoa;
import Registros.PessoaFisica;
import Registros.PessoaJuridica;
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
    public List<Pessoa> cliente;
    public List<PessoaFisica> clientef;
    public List<PessoaJuridica> clientej;
    
    
    public ArquivoCliente(){
        this.cliente = new ArrayList<>();
        this.clientef = new ArrayList<>();
        this.clientej = new ArrayList<>();
    }
    
    
        
    
    
}
