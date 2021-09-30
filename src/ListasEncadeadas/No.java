/*
 
1- Parte do Programa
 */
package ListasEncadeadas;


public class No<T extends Comparable<T>> {

    
	private T valor;
	private No proximo;
	
	public No(T valor) {
		this.valor = valor;
		proximo = null;
	}
	
	/**obtém o próximo nó */

        public No<T> ObtFrente(){
            return this.proximo;
        }
        
	/**inserir o próximo nó */
	public T ObterDado(){
            return this.valor;
        }
        
	/**inserir o valor no nó */
	  public void InsereValor(T valor){
               this.valor = valor;
        
	}
	/**obter o valor do nó */
	public void InsereProximo(No proximo){
            this.proximo = proximo;
        }
	
	//métod toString para exibir o nó
	public String toString() {
		return this.valor.toString();
	}
	
}