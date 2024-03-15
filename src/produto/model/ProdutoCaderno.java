package produto.model;

public class ProdutoCaderno extends Produto {
	
	private int numFolhas;

	public ProdutoCaderno(int id, int tipo, String nome, float preco, int qtdEstoque, int numFolhas) {
		super(id, tipo, nome, preco, qtdEstoque);
		this.numFolhas = numFolhas;
	}

	public int getNumFolhas() {
		return numFolhas;
	}

	public void setNumFolhas(int numFolhas) {
		this.numFolhas = numFolhas;
	}
	
	@Override
	public boolean vender(int qtd) {
		if(this.getQtdEstoque() < qtd) {
			System.out.println("\nQuantidade de cadernos insuficiente no estoque!");
			return false;
		}
		this.setQtdEstoque(this.getQtdEstoque() - qtd);
		return true;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Quantidade de folhas: " + this.numFolhas);
	}

}
