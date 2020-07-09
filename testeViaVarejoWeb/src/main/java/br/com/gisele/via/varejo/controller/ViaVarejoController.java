package br.com.gisele.via.varejo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gisele.via.varejo.service.ParcelaService;
import br.com.gisele.via.varejo.vo.ResultadoParcela;
import br.com.gisele.via.varejo.vo.ViaVarejoRequest;

@RestController
@RequestMapping("/calculo")
public class ViaVarejoController {

	@Autowired
	private ParcelaService parcelaService;
	
	@PostMapping(value = "/calcularParcela")
	public List<ResultadoParcela> consultarToken(@RequestBody final ViaVarejoRequest request) {
		
		return parcelaService.efetuaCalculoParcela(request);

	}

	
}
