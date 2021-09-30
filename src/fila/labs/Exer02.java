package fila.labs;

import fila.Fila;



public class Exer02 {

	public static void main(String[] args) {
		
		Fila<String> regular = new Fila<>();
		Fila<String> prioridade = new Fila<>();
		
		final int MAX_PRIORIDADE = 3;
		
		regular.enfileira("Pessoa 1");
		regular.enfileira("Pessoa 2");
		regular.enfileira("Pessoa 3");
		prioridade.enfileira("Pessoa 1P");
		prioridade.enfileira("Pessoa 2P");
		prioridade.enfileira("Pessoa 3P");
		prioridade.enfileira("Pessoa 4P");
		prioridade.enfileira("Pessoa 5P");

                regular.enfileira("Pessoa 4");
		regular.enfileira("Pessoa 5");
		regular.enfileira("Pessoa 6");
		regular.enfileira("Pessoa 7");
		regular.enfileira("Pessoa 8");
               
                
		while (!regular.estaVazia() || !prioridade.estaVazia()) {
			
			int cont = 0;
		/*
                Que no caso são 3 pessoas com prioridades atendidas.
                        
                        */
			while(!prioridade.estaVazia() && cont < MAX_PRIORIDADE) {
				atendePessoa(prioridade);
				cont++;
                                
			}
			
			if (!regular.estaVazia()) {
				atendePessoa(regular);
			}
		
//Verificar se a fila de prioridade esta vazia, caso esteja podemos atender a de regular
			if (prioridade.estaVazia()) {
				while (!regular.estaVazia()) {
					atendePessoa(regular);
				}
			}
		}
	}
	
	public static void atendePessoa(Fila<String> fila) {
		String pessoaAtendida = fila.desenfileira();
		System.out.println(pessoaAtendida + " foi atendida.");
	}

}
