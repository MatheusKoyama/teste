package fila.labs;

import fila.Fila;
import java.util.Random;



public class Exer04 {

	public static void main(String[] args) {
		
		Fila<Integer> fila = new Fila<>();
		
		for (int i=0; i<10; i++) {
			fila.enfileira(i);
		}
		
		//Gerar um número de 0 a 10
                Random aleatorio = new Random();
		int num = 0;
		while (num == 0) {
			num = aleatorio.nextInt(10);
		}
		
		System.out.println("Número = " + num);
		
                /*
A idéia dessa brincadeira é que fique sobrando uma pessoa na fila, pra que podemos
simular a brincadeira.                
                
                */
		while (fila.tamanho() > 1) {
			for (int i=0; i<num; i++) {
			fila.enfileira(fila.desenfileira());//ponto de inicio e desinfileira
			}
			System.out.println("Eliminado = " + fila.desenfileira());
		}
		
		System.out.println("Ganhador: " + fila.desenfileira());
	}

        /*
Ou seja, a brincadeira funciona da seguinte forma. Inserimos o valor que seria
        aleatorio, e após essa ocorrência, vamos contando até que chega o eliminado,
        apos ele ser excluido, desinfileiramos a fila e continuamos até que a sobre apenas
        1 ganhador.
        */
}
