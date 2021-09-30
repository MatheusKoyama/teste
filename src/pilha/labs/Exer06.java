package pilha.labs;


import pilha.Pilha;

public class Exer06 {

	public static void main(String[] args) {
		
		imprimeResultado("A + B");
		imprimeResultado("A + B + (C - D)");
		imprimeResultado("{[()]}[](){()}");
		imprimeResultado("{[(]}[](){()}");
		imprimeResultado("A + B + C - D)");
	}
	
	public static void imprimeResultado(String expressao){
		System.out.println(expressao + " está balanceado? " + 
				verificaSimbolosBalanceados(expressao));
	}
	
	//Criamos 2 constantes finais
        //Constante sempre sao letras maiusculas
        final static String ABRE = "([{";
	final static String FECHA = ")]}";

	
        
        public static boolean verificaSimbolosBalanceados(String expressao){
		
            
             /*
              Estamos recebendo uma String como parâmetro e vamos analisar caractere, por
            caractere !
            
            */
		Pilha<Character> pilha = new Pilha<Character>();
		int index = 0;
		char simbolo, topo;
		
                /*
                podemos fazer durante um for ou while, vai depender como será realizado!
                
                */
		while (index < expressao.length()){
		 simbolo = expressao.charAt(index);//obter caractere pegar caracter no determinado indice
			
			/*
                        ABRE.indexOf(simbolo) > -1 nesta parte
                        verificamos se o indicie existe, se existir então iremos empilhar.
                        
                        Se o caractere não for de abertura, logo vamos ignorar e ir pra
                        próxima posição.  Nessa caso vamos verificar se a pilha esta vazia.
                        Vamos return false, pois podemos ter expressões como A + B ) + C e no
                        casso estaria incorreto esssa expressão.
                        
                        
                        Caso a pilha não esteja vazia, vamos desimpilhar.
                        E nesse caso ABRE.indexOf(topo) != FECHA.indexOf(simbolo)
                        vamos verificar se o índice, no caso tanto do ABRE e FECHA são iguais
                        quer dizer que está balanceado  e se tiver desbalanceado retornamos false;
                        
                        
                        
                        */
                        if (ABRE.indexOf(simbolo) > -1){
				pilha.empilha(simbolo);
				
			} else if(FECHA.indexOf(simbolo) > -1){
				
                            //Se no caso for A , B ou não começando com ( ou [ ou { ignoramos e vamos pra
                            // outra posição
                            
				if (pilha.estaVazia()){
					return false;
				} else {
					topo = pilha.desempilha();
					/*
                                        Camos verificar se o indice do fecha se encontra na mesma posicao
                                        do topo.
                                        */
					if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)){
						return false;// no caso o algoritmo vai parar a execução
					}
				}
			}
			
			index++;
		}
		
		return true;
	}
}
