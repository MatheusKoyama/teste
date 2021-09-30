package pilha;

import base.EstruturaEstatica;


public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha(){
		
         super();
	}
	
	
	
	public Pilha(int capacidade){
		super(capacidade);
	}
	
        /*
         
          #02Aula 
        
        #14: Pilhas: Empilhar elemento (push)
        
        OBS: Pra podermos utilizar estes metodos na classe Pilha
        devemos por proteced os métodos que estão dentro da EstruturaEstatica
        ou seja, pra conseguirmos utilizar nesta classe !
        */
	public void empilha(T elemento){
		super.adiciona(elemento);
                
	}
	
        
        /*
           #03Aula
        
        #16: Pilhas: Espiar/Verificar elemento do topo (peek)
          
        */
	public T topo(){
		
		if (this.estaVazia()){
			return null;
		} 
		
		return this.elementos[tamanho-1];
	}
	
	public T desempilha(){
		
		if (this.estaVazia()){
			return null;
		}
		
		/*T elemento = this.elementos[tamanho-1];
		tamanho--;
		
		return elemento;*/
		
		return this.elementos[--tamanho];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
