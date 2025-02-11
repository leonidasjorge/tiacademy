package br.com.tiacademy.vendas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiacademy.vendas.converter.PedidoConverter;
import br.com.tiacademy.vendas.core.crud.ReadController;
import br.com.tiacademy.vendas.domain.Pedido;
import br.com.tiacademy.vendas.dto.PedidoCriarDTO;
import br.com.tiacademy.vendas.dto.PedidoDTO;
import br.com.tiacademy.vendas.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends ReadController<Pedido, PedidoDTO, Long> {

	private PedidoConverter getConverter() {
		return (PedidoConverter) converter;
	}
	
	private PedidoService getService() {
		return (PedidoService) service;
	}
	
	@PostMapping
	public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoCriarDTO dto) {
		
		var pedido = getConverter().dtoCriarParaEntidade(dto);
		
		var salvo = getService().criarPedido(pedido, dto);
		
		ServletUriComponentsBuilder buider = ServletUriComponentsBuilder.fromCurrentRequest();
		
		var uri = buider.path("/{id}").buildAndExpand(salvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDto(salvo));
	}
	
}
