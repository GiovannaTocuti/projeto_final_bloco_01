package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produto.controller.ProdutoController;
import produto.model.ProdutoCaderno;
import produto.model.ProdutoCaneta;
import produto.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();

		Scanner leia = new Scanner(System.in);

		int opcao, id, tipo, qtdEstoque, qtdFolhas, qtd;
		float preco;
		String nome, cor;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND
					+ "**************************************************");
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

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite uma opção válida (1 a 8)! ");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 8) {
				System.out.println(
						Cores.TEXT_WHITE_BOLD + "\nPapelaria da Gigi - Os melhores produtos com os melhores preços!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Cadastrar produto\n\n");

				do {
					System.out.println("Digite o tipo do produto (1 - Caderno e 2 - Caneta): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R?");
				nome = leia.nextLine();
				System.out.println("Digite o preço (R$): ");
				preco = leia.nextFloat();
				System.out.println("Digite a quantidade de produtos em estoque: ");
				qtdEstoque = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite a quantidade de folhas do caderno: ");
					qtdFolhas = leia.nextInt();
					produtos.cadastrar(
							new ProdutoCaderno(produtos.gerarId(), tipo, nome, preco, qtdEstoque, qtdFolhas));
				}
				case 2 -> {
					System.out.println("Digite a cor da tinta da caneta: ");
					cor = leia.nextLine();
					produtos.cadastrar(new ProdutoCaneta(produtos.gerarId(), tipo, nome, preco, qtdEstoque, cor));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todos os produtos\n\n");
				produtos.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultara informações do produto por ID\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();

				produtos.procurarPorId(id);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar informações do produto\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				var buscaProduto = produtos.buscarNaCollection(id);
				if (buscaProduto != null) {
					tipo = buscaProduto.getTipo();
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Digite o preço do produto (R$): ");
					preco = leia.nextFloat();
					System.out.println("Digite a quantidade em estoque: ");
					qtdEstoque = leia.nextInt();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite a quantidade de folhas: ");
						qtdFolhas = leia.nextInt();
						produtos.atualizar(new ProdutoCaderno(id, tipo, nome, preco, qtdEstoque, qtdFolhas));
					}
					case 2 -> {
						System.out.println("Digite a cor da tinta: ");
						leia.skip("\\R?");
						cor = leia.nextLine();
						produtos.atualizar(new ProdutoCaneta(id, tipo, nome, preco, qtdEstoque, cor));
					}
					default -> {
						System.out.println("Tipo de produto inválido!");
					}
					}
				} else {
					System.out.println("O produto não foi encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Excluir produto\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				
				produtos.deletar(id);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Computar saída de produto no estoque\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				do {
					System.out.println("Digite a quantidade de produtos vendidos: ");
					qtd = leia.nextInt();
				} while(qtd <= 0);
				
				produtos.vender(id, qtd);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Computar entrada de produto no estoque\n\n");

				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				
				do {
					System.out.println("Digite a quantidade de entrada de produtos: ");
					qtd = leia.nextInt();
				} while(qtd <= 0);
				
				produtos.entrar(id, qtd);
				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!");
				keyPress();
				break;
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

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
}
