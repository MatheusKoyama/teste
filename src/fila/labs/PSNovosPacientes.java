package fila.labs;
/*

Essa classe seria a 3 parte onde vedemos criar os métodos de retornas as pessoas

Runnable é da classe Thread
*/
import java.util.Random;

import fila.FilaComPrioridade;
import fila.labs.Pessoa;

public class PSNovosPacientes implements Runnable {

	private FilaComPrioridade<Pessoa> fila;
	private int cont = 7;
	private Random prioridade = new Random();//valores aleaotorios
        

	public PSNovosPacientes(FilaComPrioridade<Pessoa> fila) {
		super();
		this.fila = fila;
	}

        /*
        ultima parte da lógica desenvolvida
        */
	@Override
	public void run() {
		
		for (int i=0; i<8; i++) {
			try {
				Thread.sleep(8000);//8 segundos
				Pessoa p = new Pessoa("" + cont, prioridade.nextInt(3));//no caso queremos valores, 0,1 ou 2
				fila.enfileira(p);
				cont++;
				System.out.println(p + " enfileirada.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
