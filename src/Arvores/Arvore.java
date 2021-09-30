/*
#Codigo – Arvores Binárias de Busca

 */
package Arvores;

  public class Arvore{
    
      /*
      1- Parte
      */
    private Elemento ele;
    private Arvore   dir;
    private Arvore   esq;
    
    /* 1- Parte 
    */
    public Arvore(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
    }
    
    /* 1- Parte
    */
    
    public Arvore(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
      
        //System.out.println("Criei a arvore com o elemento "+elem.getValor  
    }
    
    
    
    
    /*
    10- Parte remocao do no da arvore
      
    */
    public Arvore remover(Elemento elem){
        /*
        1- Parte  realizou o caso simples, caso 2 e caso 3.
        
        2- Parte ele realizou o caso 4
        */
        // primeiro caso - achei o elemento
      
        if (this.ele.getValor() == elem.getValor()){
           
     
            // caso mais simples - o elemento está em um nó folha
            if (this.dir == null && this.esq == null){
                return null;
            }
            else{    
                
                // caso 2 - eu tenho filhos à esquerda, porém não tenho à direita
                if (this.esq != null && this.dir == null){
                    return this.esq;    
                }
                
               // caso 3 - eu tenho filhos à direita, porém não tenho à esquerda
                else if (this.dir != null && this.esq == null){
                    return this.dir;
                }
                // caso 4 - tenho filhos dos dois lados (esquerda e direita)
                else{
                    
                    // vamos adotar a estratégia do maior dentre os menores?
                    Arvore aux = this.esq;
                    while (aux.dir != null){ // enquanto houver filhos à direita
                      
                        aux = aux.dir;
                    }
                    
                     // troco os elementos da árvore
                    this.ele = aux.getElemento();  // o nó atual recebe o elemento do aux
                                                   // o maior dentre os menores
                    aux.setElemento(elem);   //Ou seja ele pega o numero 8 e subs no caso pro 10     
                    this.esq = esq.remover(elem); // insiro no nó folha (lá embaixão) o elmento a ser eliminado
                }
            }
        }
        /*
        1-Parte feita, lembrando de delegar as rsponsabilidades;
         
         É  situação de remoção tanto o elemento podendo ser a sua esquerda ou o elemento
        podendo ser a sua direita
        */
        else if (elem.getValor() < this.ele.getValor()){
            
            // delegar a responsabilidade à sub-arvore da esquerda
            this.esq = this.esq.remover(elem);
        }
        else if (elem.getValor() > this.ele.getValor()){
            
            // delegar a responsabilidade à sub-arvore da direita
            this.dir = this.dir.remover(elem);
        }
        return this;
    }
   
   /*
    2- Parte
    */
    // metodos de controle;
    public boolean isEmpty(){
    
        return (this.ele == null);
    }
    
    /* 5- Parte
    
    */
    public void imprimirPreOrdem(){
    
        if (!isEmpty()){//verifica se a lista esta vazia ?
        
            System.out.print(this.ele.getValor() + "  ");
            
            if (this.esq != null){
                this.esq.imprimirPreOrdem();
            }
            
            if (this.dir != null){
                this.dir.imprimirPreOrdem();
            }
        }
    }
    
    /* 6- Parte
    
    */  
    public void imprimirInOrdem(){
    
        if (!isEmpty()){
        
            if (this.esq != null){//Esquerda
                this.esq.imprimirInOrdem();
            }
            
            System.out.print(this.ele.getValor() + "  ");//Raiz
            if (this.dir != null){//Direita
                this.dir.imprimirInOrdem();
            }
        }
    }
   
    /* 7- Parte
    
    */
    public void imprimirPosOrdem(){
    
        if (!isEmpty()){
        
            if (this.dir != null){
                this.dir.imprimirPosOrdem();
            }
            
            if (this.esq != null){
                this.esq.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
        }
    }
    
    /*
    8- Parte
    */
    public void ImprimirInvertida(){
        
         if(!isEmpty()){
              
             if(this.dir != null){
                 this.dir.ImprimirInvertida();
                
             }
             System.out.println(this.ele.getValor()+ " ");
             
             if(this.esq != null){
                 this.esq.ImprimirInvertida();
             }
         }
    }
 
    /*
    3 - Parte
    */
    public void inserir(Elemento novo){
    
        if (isEmpty()){
            this.ele = novo;
        }
        else{
            
            Arvore novaArvore = new Arvore(novo);
        
            if (novo.getValor() < this.ele.getValor()){ // vou inserir na descendencia esquerda
                if (this.esq == null){ // sou um nó folha?
                    this.esq = novaArvore;
            
                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " à esquerda de "+this.ele.getValor());
                }
                else{//Nesse caso se tiver já descendencia a sua esqueda.
                    
                    this.esq.inserir(novo); // repassei a resposnabilidade pra sub-árvore esquerda
                }
            }
            else if (novo.getValor() > this.ele.getValor()){ // vou inserir na descendenia direita
                
                if (this.dir == null){
                    this.dir = novaArvore;
                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " à direita de "+this.ele.getValor());
                }
                else{
                    this.dir.inserir(novo);
                }
            }
        }
    }
  
    /*
    4- Parte
    */
    public boolean busca(int valor){
 
        //Verifica se a arvore esta vazia ?
        if (isEmpty()){
            return false;
        }
        
        if (this.ele.getValor() == valor){
            return true;
        }
        else{
            if (valor < this.ele.getValor() ){//começa pela esquerda
                if (this.esq == null){//Verificamos se a esquerda é null
                    return false;
                }
                else{
                    return this.esq.busca(valor); // repassei a responsabilidade para a subarvore esquerda
                }
            }
            else if (valor > this.ele.getValor()){
                if (this.dir == null){
                    return false;
                }
                else{
                    return this.dir.busca(valor);
                }
            }
        }
             return false;
    }
    
    /*
    1- Parte
    */
    // gets e sets
    public void setElemento(Elemento ele){
    
        this.ele = ele;
    }
    
    public void setDir(Arvore dir){
         this.dir = dir;
    }
    
    public void setEsq(Arvore esq){
    
        this.esq = esq;
    }
    
    public Arvore getDireita(){
    
        return this.dir;
    }
   
    public Arvore getEsquerda(){
    
        return this.esq;
    }
    
    public Elemento getElemento(){
    
        return this.ele;
    }
}