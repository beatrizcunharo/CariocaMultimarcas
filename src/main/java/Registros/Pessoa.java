package Registros;

import java.util.Date;

/**
 *
 * @author Beatr
 */
public class Pessoa {
    private String nome;
    private String telefone;
    private Date dataRegistro;
    private Endereco endereco;
    private int numVendas;//NUMERO DE COMPRAS NA LOJA PARA OS CLIENTES E NUMERO DE VENDAS PARA O FUNCIONARIO
    
    public Pessoa(){
        nome = null;
        telefone = null;
        dataRegistro = null;
        endereco = null;
        numVendas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }    

    public int getNumVendas() {
        return numVendas;
    }
    
    public void setNumVendas(int numVendas) {
        this.numVendas = numVendas;
    }
}
