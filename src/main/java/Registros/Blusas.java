package Registros;
/**
 *
 * @author ice
 */
          
public class Blusas extends Produto{
    //INCLUI CAMISAS e CAMISETAS
    private String tamanho;

    
    public Blusas(){
        tamanho = null;
    }
    
    public String getTamanho(){
        return tamanho;
    }
    
    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }
}
