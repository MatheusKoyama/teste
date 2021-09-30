/*

 2- Parte
 */
package Hash.Espalhamento;

public class Registro{
   
    private int      key;
    private String   value;
    private Registro proximo;// ponteiro
    
    /*
    < private Registro proximo >
    5 - Parte , criação da Lista-Encadeada. Ou seja, vamos fazer o método,
    quando existe colisão na mesma posição, mais que vai apontar para uma lista.
    
*/
    
    public Registro(){
           this.proximo = null;
        }
       
    public Registro(int key, String value){
           this.key     = key;
           this.value   = value;
           this.proximo = null;
        }
   
        public void setKey(int key){
        this.key = key;//resto da divisao 
    }
   
        public void setValue(String value){
        this.value = value;
    }
    
        public void setProximo(Registro proximo){
        this.proximo = proximo;
        }
   
        public int getKey(){
        return this.key;
    }
   
        public String getValue(){
        return this.value;
    }
   
        public Registro getProximo(){
        return this.proximo;
    }
   
        public int hashCode(){
        return key % 100;//Aqui foi um dado aleatorio, pra calcular a hash
    }
}