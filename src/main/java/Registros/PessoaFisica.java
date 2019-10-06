package Registros;
import java.util.Date;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class PessoaFisica extends Pessoa{
    private String cpf;
    private Date dataNasc;
    private String sexo;
    
    public PessoaFisica(){
        cpf = null;
        dataNasc = null;
        sexo = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataDeNasc) {
        this.dataNasc = dataDeNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

