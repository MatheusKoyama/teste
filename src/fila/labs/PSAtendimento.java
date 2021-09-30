package fila.labs;


import fila.FilaComPrioridade;

public class PSAtendimento implements Runnable {
	
	private FilaComPrioridade<Pessoa> fila;
	
	public PSAtendimento(FilaComPrioridade<Pessoa> fila) {
		super();
		this.fila = fila;
	}

      /*
        Condição a cada x(segundos)/ verificar se a lista esta vazia
        
        */
	@Override
	public void run() {
		
		while (!fila.estaVazia()) {
			try {
				System.out.println(fila.desenfileira() + " atendida.");
				Thread.sleep(5000);//5 segundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Atendimento concluído.");
		
	}

}
