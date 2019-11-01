package Registros;

import java.util.Date;

/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class Produto {
    private int codigo;
    private int qtde;
    private double valor;
    private String nome;
    private String sexo;
    private Date dataRegistro;
    
    public Produto(){
        codigo = 0;
        qtde = 0;
        valor = 0.0;
        nome = null;
        sexo = null;
        dataRegistro = null;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int cod){
        this.codigo = cod;
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
