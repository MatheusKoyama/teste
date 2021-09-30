/*

 */
package BuscaClassificacao;

import java.util.Arrays;


public class BubbleSort {
    public static void main(String[] args){
        
         int []vetor = {55,35,45,70,22,10,12,14,28,89};
         bolha(vetor);
         System.out.println(Arrays.toString(vetor));
    } 
    
    
    private static void bolha(int []vetor){
           for(int ultimo=vetor.length-1 ; ultimo>0; ultimo--){
                for(int i = 0; i<ultimo; i++){
                     if(vetor[i] > vetor[i+1])
                         troca(vetor,i,i+1);
                        
                }
           }
    }
    
    private static void troca(int[]vetor, int i, int j){
         
          int aux = vetor[i];
          vetor[i] = vetor[j];
          vetor[j] = aux;
    }
}
