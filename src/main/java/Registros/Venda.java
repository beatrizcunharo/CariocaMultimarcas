package Registros;

import Arquivo.ArquivoCliente;
import Arquivo.ArquivoEstoque;

/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public abstract class Venda{
    private int codigo;
    private int qtde;
    private double valor;
    private String tipoVenda;
    private String tipoPessoa;
    private String cpf;
    private String cnpj;
    private String data;
    private int codigoProduto;
    private String tipoProduto;
    private ArquivoCliente cliente;
    private ArquivoEstoque estoque;
    
    public Venda(){
        codigo = 0;
        qtde = 0;
        valor = 0.0;
        tipoVenda = "";
        tipoPessoa = "";
        cpf = "";
        cnpj = "";
        data = "";
        codigoProduto = 0;
        tipoProduto = "";
        cliente = new ArquivoCliente();
        estoque = new ArquivoEstoque();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the tipoVenda
     */
    public String getTipoVenda() {
        return tipoVenda;
    }

    /**
     * @param tipoVenda the tipoVenda to set
     */
    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the cliente
     */
    public ArquivoCliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ArquivoCliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the estoque
     */
    public ArquivoEstoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(ArquivoEstoque estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the tipoProduto
     */
    public String getTipoProduto() {
        return tipoProduto;
    }

    /**
     * @param tipoProduto the tipoProduto to set
     */
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    
}