package Registros;
/**
 *
 * @author ice
 */
import com.google.gson.*;
          
public class Blusas extends Produto{
    //INCLUI MOLETONS, CAMISAS e CAMISETAS
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
