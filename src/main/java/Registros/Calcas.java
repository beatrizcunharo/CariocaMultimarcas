package Registros;

/**
 *
 * @author ice
 */
public class Calcas extends Produto{
    //INCLUI CALÇAS, BERMUDAS E SHORTS
    private int numero;
    
    public Calcas(){
        numero = 0;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
}
