package base;
/*
Esta aula seria:

#13: Pilhas: Introdução -- #1Aula


Lembrando que a EstruturaEstatica seria a SuperClasse !  
 
O super() serve para chamar o construtor da superclasse. 
Ele sempre é chamado, mesmo quando não está explícito no código, quando for 
explicitado deve ser o primeiro item dentro do construtor.
*/
public class EstruturaEstatica<T> {
 
        /*
        Mudamos a estrutura para protected pra podermos ter acesso a esses
    mesmo elementos dentro da classe (Pilha)
    */
	protected T[] elementos; 
	protected int tamanho;

	@SuppressWarnings("unchecked")
	public EstruturaEstatica(int capacidade){
		this.elementos = (T[]) new Object[capacidade]; //solução do livro effective Java
		this.tamanho = 0;
	}
          
        //Aqui seria uma construtor da estrutura estática
	public EstruturaEstatica(){
		this(10);
	}
	
        
        
        /*
           #03 aula
        
        #15: Pilhas: Verificar se pilha está vazia
        Utilizamos no método EstruturaEstatica, pra que instancie na Classe
        Pilha ja que fizemos extends
        
        
        */
	public boolean estaVazia(){
		return this.tamanho == 0;
	}

       
        
        
        /*
        
        Não vamos deixar public o Adiciona, pois so assim as classes que pertecem
        ao pacote Base e as filhas da estrutura estática, poderam ver estes métodos
        
        A estrutura de dados, pilha e também filha. Não podemos adicionar elementos
        em qualquer posição. Então por isso a gente expõem, somente pras classes fihas
        e nas Classe -> Lista2 a gente expões somente o que sera necessario.
        */
	protected boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}

	protected boolean adiciona(int posicao, T elemento){

		if (posicao < 0 || posicao > tamanho){
			throw new IllegalArgumentException("Posição inválida");
		}

		this.aumentaCapacidade();
                   

		//mover todos os elementos
		for (int i=this.tamanho-1; i>=posicao; i--){
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;

		return true;
	}
	
	protected void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i=posicao; i<tamanho-1; i++){
			elementos[i] = elementos[i+1];
		}
		tamanho--;
	}

	@SuppressWarnings("unchecked")
	private void aumentaCapacidade(){
		if (this.tamanho == this.elementos.length){
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for (int i=0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	public int tamanho(){
		return this.tamanho;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.tamanho-1; i++){
			s.append(this.elementos[i]);
			s.append(", ");
		}
		
		if (this.tamanho>0){
			s.append(this.elementos[this.tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}
