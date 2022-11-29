package br.com.brazuca.brazucaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brazuca.brazucaapi.dto.DoadorResponseDTO;
import br.com.brazuca.brazucaapi.dto.PercentagemObesosDTO;
import br.com.brazuca.brazucaapi.entity.Doador;
import br.com.brazuca.brazucaapi.exception.StandardError;
import br.com.brazuca.brazucaapi.service.DoadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API de Doadores")
@RestController
@RequestMapping("/api/v1/doador")
public class DoadorController {

	@Autowired
	
	
	private DoadorService doadorService;

	@ApiOperation(value = "Buscar doador por CPF")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Doador.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/{id}")
	public ResponseEntity<Doador> buscarEquipeId(@PathVariable("id") String cpf) {

		return ResponseEntity.ok().body(doadorService.buscarDoadorCpf(cpf));
	}

	@ApiOperation(value = "Listar Doadores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = DoadorResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping
	public ResponseEntity<DoadorResponseDTO> listarDoadores() {

		return ResponseEntity.ok().body(doadorService.listarDoadores());

	}

	@ApiOperation(value = "Listar Doadores por Estado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/listarPorEstado")
	public ResponseEntity<?> listarDoadoresPorEstado() {

		return ResponseEntity.ok().body(doadorService.buscarDoadoresPorEstado());

	}
	
	
	@ApiOperation(value = "Listar IMC médio em cada faixa de idade de dez em dez anos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/listarImcMedioFaixaEtaria")
	public ResponseEntity<?> idadeMediaIMCFaixaIdade() {

		return ResponseEntity.ok().body(doadorService.idadeMediaIMCFaixaIdade());

	}
	

	@ApiOperation(value = "Listar percentual de obesos entre os homens e entre as mulheres")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/listarPercentObesos")
	public ResponseEntity<PercentagemObesosDTO> percentualObesos() {

		return ResponseEntity.ok().body(doadorService.percentualObesos());

	}
	
	

	@ApiOperation(value = "Listar a média de idade para cada tipo sanguíneo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/mediaIdadeTipoSanquineo")
	public ResponseEntity<?> mediaIdadeTipoSanquineo() {

		return ResponseEntity.ok().body(doadorService.mediaIdadeTipoSanquineo());

	}
	

	@ApiOperation(value = "Listar quantidade de possíveis doadores para cada tipo sanguíneo receptor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Fordiben", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class), })
	@GetMapping("/qtdDoadoresTipoSanquineo")
	public ResponseEntity<?> qtdDoadoresTipoSanquineo() {

		return ResponseEntity.ok().body(doadorService.qtdDoadoresTipoSanquineo());

	}	
	
}
