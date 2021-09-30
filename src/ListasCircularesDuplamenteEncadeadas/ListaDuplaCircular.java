/*


 */
package ListasCircularesDuplamenteEncadeadas;

public class ListaDuplaCircular{
	
    private CaixinhaDupla inicio;

	public ListaDuplaCircular(){
		this.inicio = null;
	}

        /*
        Cria a lista vazia.
        */
	public boolean isEmpty(){
		return (this.inicio == null);
	}
        
      /*  
        Na linha27 utlizamos o set elemento para setar cada valor inserido dentro da Lista,
        fazendo a sua verificação. E set
        */
	public void inserir(int elemento){
		CaixinhaDupla novo = new CaixinhaDupla();
		novo.setElemento(elemento);

                //Se estiver vazia
                //Seguindo o caso que a caixinha aponta pra ela mesma se estiver vazia
		if (isEmpty()){
			novo.setProximo(novo);
			novo.setAnterior(novo);
			inicio = novo;
		}
		else{
			CaixinhaDupla tmp = inicio;
			while(tmp.getProximo() != inicio){//Ou seja o proximo nosso,não pode ser o início
				tmp = tmp.getProximo();
			}
			inicio.setAnterior(novo);//Ou seja o inicio tem que apontar pro novo
			tmp.setProximo(novo);
			novo.setAnterior(tmp);
			novo.setProximo(inicio);
		}

	} 
	public void exibirNaOrdem(){
		CaixinhaDupla tmp;
		tmp = inicio;
		do{
			System.out.println("Elemento da lista = "+tmp.getElemento());
			tmp = tmp.getProximo();

		} while(tmp != inicio);
	}

	public void exibirNaOrdemInversa(){
		CaixinhaDupla tmp;
		tmp = inicio;
		do{
			System.out.println("Elemento da Lista = "+tmp.getElemento());
			tmp = tmp.getAnterior();

		} while(tmp != inicio);
		
	}
}