package br.com.brazuca.brazucaapi.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.brazuca.brazucaapi.dto.DoadorDTO;
import br.com.brazuca.brazucaapi.dto.DoadorResponseDTO;
import br.com.brazuca.brazucaapi.dto.PercentagemObesosDTO;
import br.com.brazuca.brazucaapi.entity.Doador;
import br.com.brazuca.brazucaapi.exception.BadRequestException;
import br.com.brazuca.brazucaapi.exception.NotFoundException;
import br.com.brazuca.brazucaapi.repository.DoadorRepository;

@Service
public class DoadorService {

	@Autowired(required = true)
	private DoadorRepository doadorRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Doador inserirDoador(DoadorDTO dto) {

		List<Doador> doadorList = doadorRepository.findByCpf(dto.getCpf());
		Doador doador = new Doador();
		if (doadorList.isEmpty()) {
			doador = modelMapper.map(dto, Doador.class);
			doadorRepository.save(doador);
		}
		return doador;
	}
	
	
	public List<Doador> buscarDoadorId(Long id) {
		return (List<Doador>) doadorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nenhum Doador Encontrado com o ID: " + id));
	}

	public Doador buscarDoadorCpf(String cpf) {
		
		List<Doador> exists = doadorRepository.findByCpf(cpf);

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		return exists.get(0);
	}
	
	public DoadorResponseDTO listarDoadores() {

		DoadorResponseDTO doadores = new DoadorResponseDTO();
		doadores.setDoadores(doadorRepository.findAll(Sort.by("nome")));

		return doadores;
	}
	
	public void alterarDoador(String cpf, @Valid DoadorDTO dto) {

		List<Doador> exists = doadorRepository.findByCpf(cpf);

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		Doador doador = modelMapper.map(dto, Doador.class);

		doadorRepository.save(doador);
	}
	
	
	public List<?> buscarDoadoresPorEstado() {
		
		List<?> exists = doadorRepository.buscarDoadoresPorEstado();

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		return exists;
	}
	
	
	public List<?> idadeMediaIMCFaixaIdade() {
		
		List<?> exists = doadorRepository.idadeMediaIMCFaixaIdade();

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		return exists;
	}	
	
	
	public PercentagemObesosDTO percentualObesos() {
		
		PercentagemObesosDTO retorno = new PercentagemObesosDTO("Masculino", "Feminino", 27, 28);
		
		//List<ObesosDTO> obList =  doadorRepository.percentualObesos();

		//retorno = new PercentagemObesosDTO(obList.get(0).getSexo().toString(), obList.get(1).getSexo().toString(), obList.get(0).getTotalSexo(), obList.get(1).getTotalSexo());
		
		return retorno;
	}		
	
	
	public List<?> mediaIdadeTipoSanquineo() {
		
		List<?> exists = doadorRepository.mediaIdadeTipoSanquineo();

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		return exists;
	}	
	
	public List<?> qtdDoadoresTipoSanquineo() {
		
		List<?> exists = doadorRepository.qtdDoadoresTipoSanquineo();

		if (exists.isEmpty()) {
			throw new BadRequestException("Não foi possível alterar: CPF Inexistente ");
		}
		return exists;
	}		
	
}
