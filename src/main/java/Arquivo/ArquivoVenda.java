package Arquivo;

import Registros.PessoaFisica;
import Registros.Produto;
import Registros.VendaAPrazo;
import Registros.VendaAVista;
import java.io.IOException;
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
    List<VendaAVista> vendaVista;
    List<VendaAPrazo> vendaPrazo;
    
    public ArquivoVenda(){
        this.vendaVista = new ArrayList<>();
        this.vendaPrazo = new ArrayList<>();
    }
    
    
    public void cadastraVendaVista(int codigoVenda,String tipoVenda,String tipoPessoa, String cpf, String cnpj, String dataRegis, int qtde, double valorTotal, double desconto) throws IOException{
        VendaAVista vv = new VendaAVista();
        
        vv.setCodigo(codigoVenda);
        vv.setTipoVenda(tipoVenda);
        vv.setTipoPessoa(tipoPessoa);
        vv.setCpf(cpf);
        vv.setCnpj(cnpj);
        vv.setData(dataRegis);
        vv.setQtde(qtde);
        vv.setValor(valorTotal);
        vv.setDesconto(desconto);
        vendaVista.add(vv);        
    }

    public void cadastraVendaAPrazo(int codigoVenda,String tipoVenda,String tipoPessoa, String cpf, String cnpj, String dataRegis, int qtde, double valorTotal, int parcelas, double valorParc) throws IOException{
        VendaAPrazo vp = new VendaAPrazo();
        
        vp.setCodigo(codigoVenda);
        vp.setTipoVenda(tipoVenda);
        vp.setTipoPessoa(tipoPessoa);
        vp.setCpf(cpf);
        vp.setCnpj(cnpj);
        vp.setData(dataRegis);
        vp.setQtde(qtde);
        vp.setValor(valorTotal);
        vp.setParcelas(parcelas);
        vp.setValorParc(valorParc);
        vendaPrazo.add(vp);        
    }
}
