package fila;

import base.EstruturaEstatica;


public class Fila<T> extends EstruturaEstatica<T>{

        //Esse construtor vai chamar a classe mãe, que seria a EstruturaEstatica
	public Fila(){
		super();
	}
	
        //Essa é a capacidade
	public Fila(int capacidade){
		super(capacidade);
	}
	
	public void enfileira(T elemento){
		//this.elementos[this.tamanho] = elemento;
		//this.tamanho++;
		
		//this.elementos[this.tamanho++] = elemento;
		
		this.adiciona(elemento);
	}
	
	public T espiar(){
		
		if (this.estaVazia()){
			return null;
		}
		
		return this.elementos[0];
	}
	
	public T desenfileira(){
		/*
A palavra-chave final em java é usada para restringir o usuário. 
A palavra-chave java final pode ser usada em muitos contextos. 
Final pode ser:

           Variável
           Método
           Classe

A palavra-chave final pode ser aplicada com as variáveis, uma variável final que não
tem valor é chamada de variável final em branco ou variável final nãonitializada.
Pode ser inicializado apenas no construtor. A variável final em branco também pode 
ser estática que será inicializada apenas no bloco estático. 
Teremos um aprendizado detalhado sobre isso. 
Vamos primeiro aprender o básico da palavra-chave final.

final keyword in java
1) Variável final java
Se você fizer qualquer variável como final, você não pode alterar 
o valor da variável final (será constante).

Exemplo de variável final
Há um limite de velocidade variável final, vamos alterar o valor dessa variável,
mas não pode ser alterada porque a variável final uma vez atribuída um valor nunca
pode ser alterada.
            
            
            */
		final int POS = 0;
		
		if (this.estaVazia()){
			return null;
		}
		
		T elementoASerRemovido = this.elementos[POS];
		
		this.remove(POS);
		
		return elementoASerRemovido;
		
	}
}











