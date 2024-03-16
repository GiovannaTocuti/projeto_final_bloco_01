package produto.controller;

import java.util.ArrayList;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);
		if(produto != null)
			produto.visualizar();
		else
			System.out.println("\nO produto ID: " + id + " não foi encontrado!");
	}

	@Override
	public void listarTodos() {
		for(var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto ID: " + produto.getId() + " foi cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());
		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto ID: " + produto.getId() + " foi atualizado com sucesso!");
		} else
			System.out.println("\nO produto ID: " + produto.getId() + " não foi encontrado!");	
	}

	@Override
	public void deletar(int Id) {
		var produto = buscarNaCollection(id);
		if(produto != null) {
			if(listaProdutos.remove(produto) == true)
				System.out.println("\nO produto ID: " + id + " foi deletado com sucesso!");
		} else
			System.out.println("\nO produto ID: " + id + " não foi encontrado!");
	}

	@Override
	public void vender(int id, int qtd) {
		var produto = buscarNaCollection(id);
		if(produto != null) {
			if(produto.vender(qtd) == true)
				System.out.println("\nA venda do produto ID: " + id + " foi efetuada com sucesso!");
		} else
		System.out.println("\nO produto ID: " + id + " não foi encontrado!");
	}

	@Override
	public void entrar(int id, int qtd) {
		var produto = buscarNaCollection(id);
		if(produto != null) {
			produto.entrar(qtd);
			System.out.println("\nA entrada do produto ID: " + id + " foi efetuado com sucesso!");
		} else
			System.out.println("\nO produto ID: " + id + " não foi encontrado!");		
	}
	
	public int gerarId() {
		return ++ id;
	}
	
	public Produto buscarNaCollection(int id) {
		for(var produto : listaProdutos) {
			if(produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

}
