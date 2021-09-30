
package ListaDuplamenteEncadeada;



public class ListaDuplamente< T extends Comparable<T>> {
    
    
    No<T> primeiro;
    No<T> no_atual = primeiro;
	

/*   
      ATENÇÃO: Leia ! 
    
 A Lista duplamente encadeada, diferentemente da simplesmente, possui dois links para Nós,
 um para o próximo nó e outro para o nó anterior. Mas para quê? Com a Lista Simplesmente Encadeada
 já resolvemos os problemas do vetor, mas ainda assim queremos melhorar nosso algoritmo de busca.

Vamos pensar um pouco: temos uma lista como 1.000 Nós (1,2,3,4... 1000). 
Desejamos buscar o item número 30, logo varemos 30 interações (nó a nó). Agora queremos buscar o 
item 29, e novamente faremos mais 29 interações, partindo do início. Agora se em uma lista pudéssemos
sair do 30 e voltar para o 29. Nesse caso, só teríamos 1 interação. Legal, não é?

A esta altura você deve está se perguntando: mais uma lista para aprender?! 
Não necessariamente, podemos apenas modificar o código da simplesmente encadeada, facilitando a 
nossa vida. Vejamos pela estrutura a seguir:   
    
    
 */
    
    
    
	public void inserir(T  valor) {
		No<T> novo_no = new No<T>(valor);
		No<T> auxiliar = primeiro;
		
		if(this.primeiro == null) { 
			this.primeiro = novo_no;
		
		}else
		{
			while((auxiliar.obterProximo() != null) && 
			( auxiliar.obterValor().compareTo( novo_no.obterValor() ) == -1 ) )
			{
				auxiliar = auxiliar.obterProximo();
			}
			
			if(auxiliar == this.primeiro) {
				
				if(this.primeiro.obterValor().compareTo( novo_no.obterValor() ) == -1 ) {
					
					this.primeiro.inserirProximo(novo_no);
					novo_no.inserirAnterior(this.primeiro);

				}else {
					
					novo_no.inserirProximo(this.primeiro);
					this.primeiro.inserirAnterior(novo_no);
					this.primeiro = novo_no;
				}
				
			}else {
				
				if(auxiliar.obterProximo() == null) {
					novo_no.inserirAnterior(auxiliar);
					auxiliar.inserirProximo(novo_no);
				}else {
				novo_no.inserirProximo(auxiliar);
				novo_no.inserirAnterior(auxiliar.obterAnterior());
	            auxiliar.obterAnterior().inserirProximo(novo_no);
	            auxiliar.inserirAnterior(novo_no);
				}
			}
			
		}
	
	}
        
   
        /*
        
   A remoção na lista duplamente é como a lista simples, no entanto temos que ter uma atenção 
   para o novo parâmetro do nó: o anterior.   
        
        
        */
	public No<T> remover(T valor) {//arrumada 
		
		No<T> auxiliar = primeiro;
		
                No<T> retorno =null;

		while((auxiliar != null) && (auxiliar.obterValor().compareTo( valor ) != 0)  )
		{
			auxiliar = auxiliar.obterProximo();
		}
		
		
		if(auxiliar == this.primeiro) {
			
			retorno = this.primeiro;
                        retorno.inserirProximo(null);
			this.primeiro = this.primeiro.obterProximo();
                        this.primeiro.inserirAnterior(null);
			
		
		}else if(auxiliar != null)
			
                auxiliar.obterAnterior().inserirProximo(auxiliar.obterProximo());
                auxiliar.obterProximo().inserirAnterior(auxiliar.obterAnterior());
                auxiliar.inserirProximo(null);
                auxiliar.inserirAnterior(null);
	
		
		return retorno;
		
	}
	
/*

  A busca por valor não tem nada de diferente da busca por valor na lista simples.
No entanto, caso a sua lista esteja ordenada, nós podemos otimizar essa busca.
Imagine que a sua lista possui 10 elementos de valores inteiros e vocês quer
buscar o elemento de valor 6, é muito provável que ela esteja no meio da lista.
Mas não temos uma variável que guarda o meio da lista. Bem, poderíamos criá-
la? Sim! Mas imagine que você quer buscar o elemento de valor 9 ou o de valor
2, seria muito custoso e nada generalista ter um atributos para cada setor da
lista.

        Com base nisso, podemos abordar o problema de uma outra forma: imagine
que você tenha criado um novo atributo que fica na posição da último nó
buscado e com base nele você irá fazer as operações.
        
        
  
 Ok, mas isso não melhorou em nada a nossa busca, pelo contrário, eu tenho
agora uma operação de comparação e outra de atribuição. Bem, para isso
precisamos fazer a seguinte abordagem: dado o último nó buscado, verificamos
se o valor é maior ou menor que ele, se for maior, vamos para o próximo, se for
menor vamos para o anterior.      
        
        */	
	public No<T> buscar(T valor) {
		
			
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
	
			
		}
		
	
		
		return no_atual;
	}
	
	
	public String buscarCount(T valor) {
		
		int count = 0;
		
		if(no_atual== null)
			no_atual = primeiro;
		
		while((no_atual != null) && (no_atual.obterValor().compareTo( valor )) != 0  )
		{
			count++;
            if (no_atual.obterValor().compareTo(valor)==-1){
                no_atual = no_atual.obterProximo();
            }
            else 
                no_atual=no_atual.obterAnterior();
		}
		
		
		return "Achou "+no_atual.obterValor()+" com "+count + " passos";
	}
	

	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			
			s+= auxiliar.obterValor().toString() + " - ";

			auxiliar = auxiliar.obterProximo();
		}
		
		return s;
	} 
	
}