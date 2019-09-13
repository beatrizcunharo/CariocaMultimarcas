package Registros;

/**
 *
 * @author Beatr
 */
public class VendaAVista extends Venda{
    private double desconto;
    
    public VendaAVista(){
        desconto = 0.0;
    }

    public double getDesconto() {
        return desconto;
    }
    
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
