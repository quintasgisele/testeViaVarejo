package br.com.gisele.via.varejo.vo;

public class ViaVarejoRequest {

	private Produto produto;
	private CondicaoPagto condicaoPagamento;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CondicaoPagto getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagto condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

}
