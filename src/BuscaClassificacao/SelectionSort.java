

package BuscaClassificacao;

import java.util.Arrays;
import java.util.Random;



public class SelectionSort {
    public static void main(String[] args){
      
        int []vetor = gerarVetor(10);
       
        selectionSort(vetor);
        System.out.println(Arrays.toString(vetor));
       
    }
  
    private static void selectionSort(int[] vetor) {
          
        for(int i=0; i<vetor.length;i++){
              int menor = i;
           for(int j = i+1; j<vetor.length;j++){
                 if(vetor[j] < vetor[menor])
                     menor = j;
           }
             troca(vetor,i,menor);
        }   
    }      
      
     private static void troca(int[] vetor, int i, int menor) {
                
         int aux = vetor[i];
         vetor[i] = vetor[menor];
         vetor[menor] = aux;
     
     }
    
   
    
    private static int[] gerarVetor(int n) {
        int [] vetor =  new int[n];  
        Random gerador = new Random();
        
        for(int i=0; i<n;i++){
           vetor[i] = gerador.nextInt(10);
        }
          return vetor;
    }
 
}
