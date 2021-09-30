package fila.teste;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Aula25 {

	public static void main(String[] args) {
            
 /*
Em alguns casos, a possibilidade de não termos na classe Paciente o método
            de compareTo, que seria o método que está comparando. Ou seja
            no casos, vamos fazer essa prioridade neste programa, msotrando uma forma
            simples de realizar.
            
 */
		
            Queue<Paciente> filaComPrioridade = new PriorityQueue<>(
			new Comparator<Paciente>() {
					@Override
			public int compare(Paciente p1, Paciente p2) {
			    //Método seria de uma maneira mais simplificada.
                            return Integer.valueOf(p1.getPrioridade()).compareTo(p2.getPrioridade());
					}
				}
		);
		
		filaComPrioridade.add(new Paciente("A", 2));
		filaComPrioridade.add(new Paciente("B", 1));
		
		System.out.println(filaComPrioridade);

	}

}
