package Registros;

import java.util.Date;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Estoque {
    private int qtde;
    private double valor;
    private String nome;
    private String tamanho;
    private String sexo;
    private Date dataRegistro;
    
    public Estoque(){
        qtde = 0;
        valor = 0.0;
        nome = null;
        tamanho = null;
        sexo = null;
        dataRegistro = null;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }    
}
