package produto;

import java.util.Scanner;
import produto.model.Produto;
import produto.model.ProdutoCaderno;
import produto.model.ProdutoCaneta;
import produto.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		// Teste da classe Produto Caderno
		ProdutoCaderno pcad1 = new ProdutoCaderno(2, 1, "Bloco de notas", 10.5f, 5, 100);
		pcad1.visualizar();
		pcad1.vender(2);
		pcad1.visualizar();
		pcad1.entrar(9);
		pcad1.visualizar();
		
		// Teste da classe Produto Caneta
		ProdutoCaneta pcan1 = new ProdutoCaneta(3, 2, "Caneta Esfereográfica", 2.5f, 5, "azul");
		pcan1.visualizar();
		pcan1.vender(3);
		pcan1.visualizar();
		pcan1.entrar(1);
		pcan1.visualizar();

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND + "**************************************************");
			System.out.println("                                                  ");
			System.out.println("                PAPELARIA DA GIGI                 ");
			System.out.println("                                                  ");
			System.out.println("**************************************************");
			System.out.println("                                                  ");
			System.out.println("            1 - Cadastrar produto                 ");
			System.out.println("            2 - Listar produtos                   ");
			System.out.println("            3 - Buscar produto por ID             ");
			System.out.println("            4 - Atualizar informações do produto  ");
			System.out.println("            5 - Excluir produto                   ");
			System.out.println("            6 - Saída do produto do estoque       ");
			System.out.println("            7 - Entrada do produto do estoque     ");
			System.out.println("            8 - Sair do sistema                   ");
			System.out.println("                                                  ");
			System.out.println("**************************************************");
			System.out.println("Escolha a opção desejada:                         ");
			System.out.println("                                                  " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if(opcao == 8) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nPapelaria da Gigi - Os melhores produtos com os melhores preços!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch(opcao) {
			case 1: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Cadastrar produto\n\n");
				break;
			case 2: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todos os produtos\n\n");
				break;
			case 3: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultara informações do produto por ID\n\n");
				break;
			case 4: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar informações do produto\n\n");
				break;
			case 5: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Excluir produto\n\n");
				break;
			case 6: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Computar saída de produto no estoque\n\n");
				break;
			case 7: 
				System.out.println(Cores.TEXT_WHITE_BOLD + "Computar entrada de produto no estoque\n\n");
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!");
				
			}

		}

	}
	
	public static void sobre() {
		System.out.println("\n**************************************************");
		System.out.println("Projeto Desenvolvido por: Giovanna Tocuti");
		System.out.println("Generation Brasil - giovannatocuti@gmail.com");
		System.out.println("https://github.com/GiovannaTocuti");
		System.out.println("**************************************************");
	}
}
