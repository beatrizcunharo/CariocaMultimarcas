package Registros;

/**
 *
 * @author Beatriz Cunha Rodrigues - Matricula 201776038
 */
public class VendaAPrazo extends Venda{
    private int parcelas;
    private double valor;
    private double juros;
    
    public VendaAPrazo(){
        parcelas = 0;
        valor = 0.0;
        juros = 0.0;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }    
}
