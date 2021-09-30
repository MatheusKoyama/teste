/*
#Codigo – Arvores Binárias de Busca

 */
package Arvores;


public class AppQueUsaArvore{
    public static void main(String args[]){
      
        //Parte 1
        Elemento elem = new Elemento(0);
       
    //    Arvore arvore = new Arvore(new Elemento(20));
       
    Arvore arvore = new Arvore(new Elemento(10));
       
   
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(2));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(12));
        
        arvore.inserir(new Elemento(18));
     
        
        arvore.imprimirInOrdem();
        //Parte 2  
      /*
        arvore.imprimirInOrdem();
        System.out.println();
        
        System.out.println("O elemento 5 " + (arvore.busca(15)? "existe " : "nao existe"));
        
        System.out.println();
        
        arvore.ImprimirInvertida();
        
       */
      
      
        /*
        System.out.println("");
            elem.setValor(38);
       
            arvore = arvore.remover(elem);
       
            System.out.println("Nova arvore....");
            arvore.imprimirInOrdem();
        
            System.out.println("");
            elem.setValor(35);
       
            arvore = arvore.remover(elem);
            System.out.println("Nova arvore....");
        
            arvore.imprimirInOrdem();
           System.out.println("");
           
            elem.setValor(20);
            arvore = arvore.remover(elem);
        
            System.out.println("Nova arvore....");
            arvore.imprimirInOrdem();
        
            System.out.println("");        
    */
        
        
 
        
        //3 Parte da Remoção da Arvore
        elem.setValor(5);
        arvore = arvore.remover(elem);
        System.out.println("Nova Arvore .....");
        arvore.imprimirInOrdem();
        System.out.println("");
        
        
        
      
    }
}