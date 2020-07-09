package br.com.gisele.via.varejo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gisele.via.varejo.vo.ResultadoParcela;
import br.com.gisele.via.varejo.vo.ViaVarejoRequest;

@Service
public class ParcelaService {

	public List<ResultadoParcela> efetuaCalculoParcela(final ViaVarejoRequest request) {

		if(!validaRequisicao(request)) {
			return null;
		}
		
		Double valorProduto = request.getProduto().getValor();
		Double valorEntrada = request.getCondicaoPagamento().getValorEntrada();
		Integer qtdParcelas = request.getCondicaoPagamento().getQtdeParcelas();

		List<ResultadoParcela> listaParcela = new ArrayList<ResultadoParcela>();
		Double valorTotalParcelado = valorProduto - valorEntrada;

		Double valorParcela = valorTotalParcelado / qtdParcelas;

		for (int i = 0; i < qtdParcelas; i++) {

			if (qtdParcelas > 6) {

				Double valorJuros = (valorParcela * 1.15) / 100;
				ResultadoParcela parcela = new ResultadoParcela();
				parcela.setNumeroParcela(i + 1);
				parcela.setValor(valorParcela + valorJuros);
				parcela.setTaxaJurosAoMes(1.15);
				listaParcela.add(parcela);
			} else {
				ResultadoParcela parcela = new ResultadoParcela();
				parcela.setNumeroParcela(i + 1);
				parcela.setValor(valorParcela);
				parcela.setTaxaJurosAoMes(0.0);
				listaParcela.add(parcela);
			}

		}

		return listaParcela;
	}

	public boolean validaRequisicao(ViaVarejoRequest request) {
		if (request == null || request.getProduto() == null || request.getCondicaoPagamento() == null) {
			return false;
			
		} else if (request.getProduto().getValor() == null || request.getProduto().getValor() <= 0) {
			return false;
			
		} else if (request.getCondicaoPagamento().getValorEntrada() == null || request.getCondicaoPagamento().getValorEntrada() >= request.getProduto().getValor()) {
			return false;
			
		} else if (request.getCondicaoPagamento().getQtdeParcelas() == null || request.getCondicaoPagamento().getQtdeParcelas() <= 0) {
			return false;
		}

		return true;
	}
}
