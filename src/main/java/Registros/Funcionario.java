package Registros;

/**
 *
 * @author Beatr
 */
public class Funcionario extends PessoaFisica{
    private int matricula;
    
    public Funcionario(){
        matricula = 0;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
}
