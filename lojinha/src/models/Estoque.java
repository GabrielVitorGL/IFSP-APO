package models;

public class Estoque {
	private int idEstoque;
	private int idProduto;
	private int quantidade;
	private String dataValidade;

	public Estoque() {}

	public Estoque(int idEstoque, int idProduto, int quantidade, String dataValidade) {
		this.idEstoque = idEstoque;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
