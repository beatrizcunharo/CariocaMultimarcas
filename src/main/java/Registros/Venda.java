package Registros;

import java.util.Date;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Venda{
    private int qtde;
    private double valor;
    private Pessoa pessoa;
    private Date data;
    private Estoque estoque;
    
    public Venda(){
        qtde = 0;
        valor = 0.0;
        pessoa = null;
        data = null;
        estoque = null;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }  

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}



