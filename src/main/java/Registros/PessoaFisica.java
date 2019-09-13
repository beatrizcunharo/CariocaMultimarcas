package Registros;
import java.util.Date;

/**
 *
 * @author Beatr
 */
public class PessoaFisica extends Pessoa{
    private String cpf;
    private Date dataDeNasc;
    private String sexo;
    
    public PessoaFisica(){
        cpf = null;
        dataDeNasc = null;
        sexo = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNasc() {
        return dataDeNasc;
    }

    public void setDataDeNasc(Date dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
