package Registros;

/**
 *
 * @author Beatr
 */
public class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String ie;
    
    public PessoaJuridica(){
        cnpj = null;
        ie = null;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
}
