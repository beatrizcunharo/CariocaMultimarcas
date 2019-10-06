package Registros;

import java.util.Date;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Pessoa {
    private String nome;
    private String telefone;
    private Date dataRegistro;
    private Endereco endereco;
    private int numCompras;
    
    public Pessoa(){
        nome = null;
        telefone = null;
        dataRegistro = null;
        endereco = null;
        numCompras = 0;
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

    public int getNumCompras() {
        return numCompras;
    }
    
    public void setNumCompras(int numVendas) {
        this.numCompras = numVendas;
    }
}

