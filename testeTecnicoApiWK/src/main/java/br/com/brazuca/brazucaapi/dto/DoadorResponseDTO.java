package br.com.brazuca.brazucaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import br.com.brazuca.brazucaapi.entity.Doador;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoadorResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Doador> doadores;
}
