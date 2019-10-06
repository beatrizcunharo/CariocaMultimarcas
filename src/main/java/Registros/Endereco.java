package Registros;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private int numero;
    private String complemento;
    private String CEP;
    
    public Endereco(){
        rua = null;
        bairro = null;
        cidade = null;
        estado = null;
        pais = null;
        numero = 0;
        complemento = null;
        CEP = null;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }    
}
