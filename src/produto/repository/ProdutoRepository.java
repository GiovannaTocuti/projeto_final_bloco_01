package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {
	
	public void procurarPorId(int id);
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int Id);
	
	public void venderint(int id, int qtd);
	public void entrar(int id, int qtd);
}
