package pilha.labs;


import pilha.Pilha;

public class Exer05 {

	public static void main(String[] args) {
		
		imprimeResultado("ADA");
		
		imprimeResultado("ABCD");
		
		imprimeResultado("ABCCBA");
		
		imprimeResultado("Maria");
	}
	
	public static void imprimeResultado(String palavra){
		System.out.println(palavra + " é palindromo? " + testaPalindromo(palavra));
	}

	public static boolean testaPalindromo(String palavra){
		
		Pilha<Character> pilha = new Pilha<Character>(); 
		
                //Vamos pegar cada caractere dentro da String
                /*
               Método charAt seria, a opção que podemos obter uma determinada
               palavra em uma posição.
                
                */
		for (int i=0; i<palavra.length(); i++){
			pilha.empilha(palavra.charAt(i));
		}
		
                /*
                Depois vamos desimpilhar. Palavra inversa seria no caso
                pra por a palavra dentro e podendo depois fazer a comparacao
                e depois faremos a comparação
                */
		String palavraInversa = "";
		while (!pilha.estaVazia()){
			palavraInversa += pilha.desempilha();
		}
		
		if (palavraInversa.equalsIgnoreCase(palavra)){
			return true;
		}
		
		return false;
	}
}
