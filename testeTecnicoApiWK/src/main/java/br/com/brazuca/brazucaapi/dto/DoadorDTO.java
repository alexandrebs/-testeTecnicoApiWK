package br.com.brazuca.brazucaapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoadorDTO implements Serializable{

	private static final long serialVersionUID = 1L;



	@JsonProperty("nome-cpf")
	private String cpf;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("rg")
	private String rg;
	
	@JsonProperty("data_nasc")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	private Date data_nasc;
	
	@JsonProperty("sexo" )
	private String sexo;
	
	@JsonProperty("mae")
	private String mae;
	
	@JsonProperty("pai")
	private String pai;
	
	@JsonProperty("email")
	@Email
	private String email;
	
	@JsonProperty("cep")
	@Pattern(regexp = "^[0-9]-[0-9]$")
	private String cep;
	
	@JsonProperty("endereco")
	private String endereco;
	
	@JsonProperty("numero")
	private String numero;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("estado")
	private String estado;
	
	@Pattern(regexp ="(\\d{2}) \\d{4}-\\d{4}")
	@JsonProperty("telefone_fixo")
	private String telefone_fixo;
	
	@JsonProperty("celular")
	private String celular; 
	
	@JsonProperty("altura")
	private String altura;
	
	@JsonProperty("peso")
	private String peso;
	
	@JsonProperty("tipo_sanguineo")
	private String tipo_sanguineo;
	
	
	
}
