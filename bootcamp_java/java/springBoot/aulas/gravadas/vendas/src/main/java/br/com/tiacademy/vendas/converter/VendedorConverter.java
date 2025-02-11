package br.com.tiacademy.vendas.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.dto.VendedorDTO;

@Component
public class VendedorConverter implements CrudConverter<Vendedor, VendedorDTO> {

	@Override
	public VendedorDTO entidadeParaDto(Vendedor entidade) {
		
		var dto = new VendedorDTO();
		
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		
		return dto;
	}

	@Override
	public Vendedor dtoParaEntidade(VendedorDTO dto) {
		
		var vendedor = new Vendedor();
		
		vendedor.setId(dto.getId());
		vendedor.setNome(dto.getNome());
		
		return vendedor;
	}

}
