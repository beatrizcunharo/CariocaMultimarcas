package Registros;

/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class VendaAPrazo extends Venda{
    private String parcelas;
    private double valorParc;
    
    public VendaAPrazo(){
        parcelas = "";
        valorParc = 0.0;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the valorParc
     */
    public double getValorParc() {
        return valorParc;
    }

    /**
     * @param valorParc the valorParc to set
     */
    public void setValorParc(double valorParc) {
        this.valorParc = valorParc;
    }
}
