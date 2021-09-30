/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasEncadeadas;

public class Lista2{
    
    
    private Caixinha inicio;
    
   // criando a lista vazia
    public Lista2(){
        this.inicio = null;
    }
    public void inserir(int elemento){
        
        // tenho que criar uma nova caixinha
        Caixinha nova = new Caixinha();
        nova.setElemento(elemento); // inseri o elemento na caixinha
        nova.setProximo(null);    // depois dela nao vem ninguem
        if (inicio == null){ // vai ser a 1a caixinha?
            inicio = nova;
        }
        else{                // ja tem gente na lista, ou seja vamos percorrer esta caixinha
            Caixinha aux;
            aux = inicio;
            while (aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nova);
        }
    }
    
    
    public int retirar(){
        // este método considera que a lista sempre tem elementos
        // alguém na aplicação precisa (antes de remover), testar se a lista não está vazia, ok?
        if (inicio != null){
          Caixinha aux = inicio;
          int elemento = aux.getElemento();
          inicio = aux.getProximo();
          return elemento;
        } 
        else{
            throw new RuntimeException("Lista vazia!");
        }
    }
    
    
    
    public void listar(){
        if (inicio == null){
            System.out.println("Nada a exibir - a lista ta vazia!");
        }
        else{
            Caixinha aux = inicio;
            while (aux != null){
                System.out.println("Elemento visto "+aux.getElemento());
                aux = aux.getProximo();
            }
        }
    }
    
    //retornar um booleano
    public boolean isEmpty(){
        return this.inicio == null;
    }
}