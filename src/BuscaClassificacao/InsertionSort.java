

package BuscaClassificacao;

import java.util.Arrays;



public class InsertionSort {
    public static void main(String[] args){
           
        int [] vetor = {8,2,4,9,3,6};
        insertionSort(vetor);
        System.out.println(Arrays.toString(vetor));
    }

    private static void insertionSort(int[] vetor) {
            int x,j;
            for(int i = 1;i<vetor.length;i++){
                  x = vetor[i];
                  j = i -1;
                  
                  while((j>=0) && (vetor[j] > x)){
                      vetor[j+1]= vetor[j];
                           j = j-1;
                   }
                  vetor[j+1] = x;    
            }
            
                 
            
    }
    
    
    
}
