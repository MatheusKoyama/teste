package vetor;

public class Vetor {

	private String[] elementos; 
	private int tamanho;

	public Vetor(int capacidade){
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
// #02  Aula vai até a Linha12 
        
	
        /*public void adiciona(String elemento){
		for (int i=0; i<this.elementos.length; i++){
			if (this.elementos[i] == null){
				this.elementos[i] = elemento;
				break;
			}
		}
	}*/

	/*public void adiciona(String elemento) throws Exception{

		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");
		}

	}*/

        //#Aula 03 
	public boolean adiciona(String elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} 
		return false;
	}
	
	   //Aula #04
             public int tamanho(){
		return this.tamanho;
	}
        
        
        
       //Aula #05 
       public String busca(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		} 
		return this.elementos[posicao];
	} 


       
       
       //Aula #06 Procura o elemento, e verifica se existe  dentro do array
       //Comparador utilizaremos  o método equals.
       public int busca(String elemento){
		for (int i=0; i<this.tamanho; i++){
			if (this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
       
       
       
       
        //#07: Vetores e Arrays: Add elemento em qualquer posição
        // 0 1 2 3 4 5 6 = tamanho é 5
	// B C E F G + +
	public boolean adiciona(int posicao, String elemento){
		
		//Verificar se a posição é válida
                if (!(posicao >= 0 && posicao < tamanho)){
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
	   
     
        //Adiciona capacidade é um método, que utilizamos pra que o vetor 
        // aumente a capacidade dentro do nosso Array.
        //#08 Vetores e Arrays: Aumentar capacidade do Vetor
	private void aumentaCapacidade(){
		if (this.tamanho == this.elementos.length){
			String[] elementosNovos = new String[this.elementos.length * 2];
			for (int i=0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	

	
	
	
	//#09: Vetores e Arrays: Remover elemento
        // B D E F F -> posição a ser removida é 1 (G)
	// 0 1 2 3 4 -> tamanho é 5
	// vetor[1] = vetor[2]
	// vetor[2] = vetor[3]
	// vetor[3] = vetor[4]
       
	public void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i=posicao; i<this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;//Diminuir o tamanho do vetor
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
