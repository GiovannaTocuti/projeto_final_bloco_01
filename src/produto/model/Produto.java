package produto.model;

public abstract class Produto {
	
	private int id;
	private int tipo;
	private String nome;
	private float preco;
	private int qtdEstoque;
	
	public Produto(int id, int tipo, String nome, float preco, int qtdEstoque) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	public boolean vender(int qtd) {
		if(this.getQtdEstoque() < qtd) {
			System.out.println("\nQuantidade de produto insuficiente no estoque!");
			return false;
		}
		this.setQtdEstoque(this.getQtdEstoque() - qtd);
		return true;
	}
	
	public void entrar(int qtd) {
		this.setQtdEstoque(this.getQtdEstoque() + qtd);
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1: 
			tipo = "Caderno";
			break;
		case 2: 
			tipo = "Caneta";
		}
		System.out.println("\n\n**************************************************");
		System.out.println("Informações do Produto:");
		System.out.println("**************************************************");
		System.out.println("ID do produto: " + this.id);
		System.out.println("Tipo do produto: " + this.tipo);
		System.out.println("Nome do produto: " + this.nome);
		System.out.println("Preço do produto (R$): " + this.preco);
		System.out.println("Quantidade em estoque: " + this.qtdEstoque);
	}

	
	
}
