package vetor.labs;

import vetor.teste.Contato;
import java.util.Scanner;
import vetor.Lista;



public class Exer06 {

	public static void main(String[] args) {

		//Parte (1)criação das variáveis
		Scanner scan = new Scanner(System.in);

		//Parte (2)criar vetor com 20 de capacidade
		Lista<Contato> lista = new Lista<Contato>(20);

		/*criar e adicionar X contatos
                
                Nesta parte estamos criando métodos dinamicos(Chamandos os métodos)
                
                No caso passamos 5 Contatos
                */
                criarContatosDinamicamente(5, lista);

		
               //Parte(3) criar um menu para que o usuário escolha a opção
		int opcao = 1;
                while (opcao != 0){
                        
                        //Chamando o  método dinâmicamente!
			opcao = obterOpcaoMenu(scan);
                        
                        /*
                        No caso utilizamos switch case, pois temos vários opções, sendo de melhor forma
                        utilizavel. Mais se quisermos utilizamos if,else
                        */
			switch (opcao) {
			case 1:
				adicionarContatoFinal(scan, lista);
				break;
			case 2:
				adicionarContatoPosicao(scan, lista);
				break;
			case 3: 
				obtemContatoPosicao(scan, lista);
				break;
			case 4: 
				obtemContato(scan, lista);
				break;
			case 5: 
				pesquisarUltimoIndice(scan, lista);
				break;
			case 6: 
				pesquisarContatoExiste(scan, lista);
				break;	
			case 7: 
				excluirPorPosicao(scan, lista);
				break;	
			case 8: 
				excluirContato(scan, lista);
				break;	
			case 9:
				imprimeTamanhoVetor(lista);
				break;
			case 10:
				limparVetor(lista);
				break;
			case 11:
				imprimirVetor(lista);
				break;	
			default:
				break;
			}
		}

		System.out.println("Usuário digitou 0, programa terminado");
	}
	
	/*
        Parte (17)
        */
        private static void imprimirVetor(Lista<Contato> lista){

		System.out.println(lista);
	}

	/*
        
        Parte (16)
        */
        private static void limparVetor(Lista<Contato> lista){

		lista.limpar();
		
		System.out.println("Todos os contatos do vetor foram excluídos");
	}

	/*
        Parte(15)
        
        */
        private static void imprimeTamanhoVetor(Lista<Contato> lista){

		System.out.println("Tamanho do vetor é de: " + lista.tamanho());
	}

	/*
        
        Parte (13)
        */
        private static void excluirPorPosicao(Scanner scan, Lista<Contato> lista){

		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			lista.remove(pos);

			System.out.println("Contato excluído");

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

        /*
          
        Parte(14)
        
         */
	private static void excluirContato(Scanner scan, Lista<Contato> lista){

		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			Contato contato = lista.busca(pos);

			lista.remove(contato);

			System.out.println("Contato excluído");

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	   /*
          Parte (12)
        */
        
        private static void pesquisarContatoExiste(Scanner scan, Lista<Contato> lista){

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.busca(pos);

			boolean existe = lista.contem(contato);

			if (existe){
				System.out.println("Contato existe, seguem dados:");
				System.out.println(contato);
			} else {
				System.out.println("Contato não existe");
			}

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}
 
        /*
          Parte (11)
        */
	private static void pesquisarUltimoIndice(Scanner scan, Lista<Contato> lista){

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.busca(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do último índice do contato encontrado:");
			pos = lista.ultimoIndice(contato);

			System.out.println("Contato encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}
      
        
        /*
        Parte (9)
        */
	private static void obtemContato(Scanner scan, Lista<Contato> lista){

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

                //Utilizaremos também o Try/Catch
		try {

			Contato contato = lista.busca(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do contato encontrado:");
			pos = lista.busca(contato);

			System.out.println("Contato encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

        /*
        Parte(10)
          
        */
	private static void obtemContatoPosicao(Scanner scan, Lista<Contato> lista){
int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.busca(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	/*
        Parte (5)
        
        Cada parte lendo o scan = scanner !
        */
        private static void adicionarContatoFinal(Scanner scan, Lista<Contato> lista){

		System.out.println("Criando um contato, entre com as informações:");
		String nome = leInformacao("Entre com o nome", scan);
		String telefone = leInformacao("Entre com o telefone", scan);
		String email = leInformacao("Entre com o email", scan);

		Contato contato = new Contato(nome, telefone, email);

		lista.adiciona(contato);

		System.out.println("Contato adicionado com sucesso!");
		System.out.println(contato);
	}
        
        /*
        
        Parte (6)
        
        */
	protected static String leInformacao(String msg, Scanner scan){

                System.out.println(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

        /*
         
        Parte (7)
        */
	private static void adicionarContatoPosicao(Scanner scan, Lista<Contato> lista){

		System.out.println("Criando um contato, entre com as informações:");
		String nome = leInformacao("Entre com o nome", scan);
		String telefone = leInformacao("Entre com o telefone", scan);
		String email = leInformacao("Entre com o email", scan);

		Contato contato = new Contato(nome, telefone, email);

		int pos = leInformacaoInt("Entre com a posição a adicionar o contato", scan);//Parte(8)

		try {
			lista.adiciona(pos, contato);

			System.out.println("Contato adicionado com sucesso!");
			System.out.println(contato);

		} catch (Exception e){
			System.out.println("Posição inválida, contato não adicionado");
		}
	}
   
      
        /*
          
        Parte(8) - Continuação da parte <7>
        */
	protected static int leInformacaoInt(String msg, Scanner scan){

		boolean entradaValida = false;
		int num = 0;

		while (!entradaValida){

			try {

				System.out.println(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e){
				System.out.println("Entrada inválida, digite novamente");
			}
		}

		return num;
	}

        /*
        Parte(4) - Menu 
        
        Esta parte seria, o método que utilizamos dentro da Lista,
        ou seja adiciona, posicação, Etc ....
        
        
        */
	protected static int obterOpcaoMenu(Scanner scan){

		boolean entradaValida = false;
		int opcao = 0;
		String entrada;

		while (!entradaValida){

			System.out.println("Digite a opção desejada:");
			System.out.println("1: Adiciona contato no final do vetor");
			System.out.println("2: Adiciona contato em uma posição específica");
			System.out.println("3: Obtém contato de uma posição específica");
			System.out.println("4: Consulta contato");
			System.out.println("5: Consulta último índide do contato");
			System.out.println("6: Verifica se contato existe");
			System.out.println("7: Excluir por posição");
			System.out.println("8: Excluir contato");
			System.out.println("9: Verifica tamanho do vetor");
			System.out.println("10: Excluir todos os contatos do vetor");
			System.out.println("11: Imprime vetor");
			System.out.println("0: Sair");

			try {

				entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);/*
                                Nesta parte precisamos fazer a conversão de String pra inteiro, pois o nosso
                                método, vai retorna do tipo (Int), como podemos ver 
                                -- > protected static int obterOpcaoMenu(Scanner scan)
                                
                                Se o úsuario colocar qualuqer número inteiro, ou uma String, ou outro tipo
                                teremos uma exeção, ou seja é preciso utilizarmos a "excpetion"| try e catch|
                                
                                */

				if (opcao >= 0 && opcao <= 11){
					entradaValida = true;//Sai do While e pode retornar a opção
				} else {
					throw new Exception();//Lançamos uma exeção e ela é captura no catch
				}

			} catch (Exception e){

				System.out.println("Entrada inválida, digite novamente\n\n");
			}
		}

		return opcao;
	}
        
        /*
          Parte -> 2
        */
	protected static void criarContatosDinamicamente(int quantidade, Lista<Contato> lista){

		Contato contato;

		for (int i=1; i<=quantidade; i++){

			contato = new Contato();
			contato.setNome("Contato " + i);
			contato.setTelefone("1111111"+i);
			contato.setEmail("contato"+i+"@email.com");

			lista.adiciona(contato);
		}
	}
}
