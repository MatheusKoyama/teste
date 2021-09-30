

package ListasEncadeadas;



public class Lista <T extends Comparable<T>>{

     private No<T> primeiro;


    /*
     Inserir no início é simples, basta apenas:
  
     • Cria um novo nó
     • Dizer que o seu próximo é o que esta agora como primeiro
     • Dizer que ele agora é o novo primeiro
     */
     public void InsereInicial(T valor){
             
         No<T> novo_no = new No<T>(valor);
         novo_no.InsereProximo(primeiro);
         primeiro = novo_no;
     }
     
     /*
      Inserir no final é simples também, basta apenas:
   
     • Cria um novo nó
     • Andar até o último nó
     • Dizer que o próximo desse último nó é o novo nó
     */
     public void InseFinal(T valor){
            
         No<T> novo_no = new No<T>(valor);
         No<T> aux =primeiro;
         if(aux == null){
              
              primeiro = novo_no;
         }else{
               
              while(aux.ObtFrente() != null){
                    
                  aux = aux.ObtFrente();
                  
              }
              
              aux.InsereProximo(novo_no);
         }
     }
     
     
     /*
     Remover um nó é similar à inserção e à busca, podemos remover no início, no
     final ou remover um nó específico baseado em valor ou índice dele.

     - Removendo um nó no início

     Bem, se estamos removendo do início é sinal que o segundo nó será o nosso
     novo início. O segundo nó é o próximo do primeiro, certo? Então que tal
      fazermos isso:
     */
     
     public No<T> RemoveInicial(){
           
         No<T> aux = primeiro;
         primeiro = primeiro.ObtFrente();
         return aux;
     }
     
     
     /*
            - Removendo um nó no final

     Remover no final significa que o penúltimo nó será o novo último. Para ser
     considerado um último nó, na lista, este nó deve ter o seu próximo igual à null
     (não possui próximo). Então, vamos até o penúltimo nó e dizer que o próximo
     dele é null. Mas como fazemos isso? Assim:
     */
     public No<T> RemoveFinal(){
           
          No<T> aux = primeiro;
          if(aux == null){
                
              System.out.println("Erro, lista vazia");
              return null;
          }else{
                
               while(aux.ObtFrente().ObtFrente() != null){
                   
                   aux = aux.ObtFrente();
               }
               
               No<T> aux2 = aux.ObtFrente();
               aux.InsereProximo(null);
               return aux2;
          }
     }
     
     
     /*
     Já sabemos buscar pelo valor do Nó! Temos apenas que considerar algumas
     coisas referentes ao modo de deleção (início,meio  ou final), assim como na
     inserção.
     */
     public No<T> Remove(T valor){
           
           No<T> aux = primeiro;
           No<T> aux2 = null;
            
           while((aux  !=null) && (aux.ObterDado().compareTo(valor))!=0){
               
               aux2 = aux;
               aux = aux.ObtFrente();
           }
           
           if(aux == this.primeiro){
                 
               No retorna = this.primeiro;
               this.primeiro = this.primeiro.ObtFrente();
               return retorna;
           }else if(aux !=null){
                   
                   aux2.InsereProximo(aux.ObtFrente());
           }
           
           return aux2;
     }
     
     /*
     Podemos buscar um nó na lista pelo seu valor ou pelo seu índice. Vamos ver
buscar antes de remover, pois ele irá nos ajudar a remover um Nó.

     - Buscando um nó pelo seu valor
 
     Para buscar é simples, devemos apenas executar o loop com um auxiliar
     percorrendo a lista até que o valor seja encontrado ou até chegar ao final da
     lista:
     */
     public No<T> Busca(T valor){
           
         No<T> aux = primeiro;
         
         while((aux !=null) && (aux.ObterDado().compareTo(valor))!=0){
               
              aux = aux.ObtFrente();
         }
         
         return aux;
     }
     
     
     
     
     
//método toString para exibir a lista
	public String toString() {
		String s = "";
		No<T> auxiliar = primeiro;
		
		while(auxiliar != null)
		{
			//incrementa o valor
			s+= auxiliar.ObterDado().toString() + " - ";
			//pula para o próximo
			auxiliar = auxiliar.ObtFrente();
		}
		
		return s;
	} 
      
}
