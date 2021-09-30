 package pilha.labs;

import java.util.Stack;

public class Exer08 {

	public static void main(String[] args) {
		
		Stack<Integer> original = new Stack<>();
		Stack<Integer> dest = new Stack<>();
		Stack<Integer> aux = new Stack<>();

               
		original.push(3);
		original.push(2);
		original.push(1);
		
		
                torreDeHanoi(original.size(), original, dest, aux);
	}

        
        //Quantidade de discos que estamos trabalhando
	public static void torreDeHanoi(int n, Stack<Integer> original, 
			Stack<Integer> dest, Stack<Integer> aux){
		
              //Recursividade
              //n-1 seria a movimentação no caso do nosso disco.
              /*
              A torre(1) é a torre original
              A torre(2) é  a torre de destino
              A torre(3) é a torre auxiliar
              
              Ou seja,quando passamos os dados no caso de 3 valores na torre 2
              estamos transformando a pilha de destino e pilha auxiliar.Na segunda vez
              que fazemos a jogada, a torre 3 passa a ser a orginal,  pois vamos pega no caso
              a torre(1) pra jogar no destino e a orginal, vai sr no caso a nossa auxiliar.
              
              
              
              */
             
		while (n > 0){
			torreDeHanoi(n-1, original, aux, dest);
			dest.push(original.pop());
			System.out.println("------");
			System.out.println("Original: " + original);
			System.out.println("Destino: " + dest);
			System.out.println("Aux: " + aux);
			torreDeHanoi(n-1, aux, dest, original);
		}
		
	}
}
