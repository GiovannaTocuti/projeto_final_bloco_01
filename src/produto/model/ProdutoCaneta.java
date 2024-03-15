package produto.model;

public class ProdutoCaneta extends Produto {
	
	private String cor;
	
	public ProdutoCaneta(int id, int tipo, String nome, float preco, int qtdEstoque, String cor) {
		super(id, tipo, nome, preco, qtdEstoque);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public boolean vender(int qtd) {
		if(this.getQtdEstoque() < qtd) {
			System.out.println("\nQuantidade de canetas insuficiente no estoque!");
			return false;
		}
		this.setQtdEstoque(this.getQtdEstoque() - qtd);
		return true;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Cor da tinta: " + this.cor);
	}
	
	

	
	
	

	
	

}
