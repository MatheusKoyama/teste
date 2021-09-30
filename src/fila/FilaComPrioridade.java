package fila;

public class FilaComPrioridade<T> extends Fila<T>{

	public void enfileira(T elemento){
		
		Comparable<T> chave = (Comparable<T>) elemento;
		
int i;
for (i=0; i<this.tamanho; i++){
 if (chave.compareTo(this.elementos[i]) < 0){//for elemento no caso menor ou maior
 break;
 }
}
this.adiciona(i, elemento);
	}
	
}
