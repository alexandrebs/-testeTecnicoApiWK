package br.com.brazuca.brazucaapi.entity;

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

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_doador")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doador implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "cpf")
	@JsonProperty("cpf")
	private String cpf;
	
	
	@Column(name = "nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name = "rg" )
	@JsonProperty("rg")
	private String rg;
	
	@JsonProperty("data_nasc")
	@Column(name = "data_nasc")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data_nasc;
	
	@JsonProperty("sexo" )
	@Column(name = "sexo", nullable=false, length=20)
	private String sexo;
	
	@JsonProperty("mae")
	@Column(name = "mae" , nullable=false, length=50)
	private String mae;
	
	@JsonProperty("pai")
	@Column(name = "pai", nullable=false, length=50)
	private String pai;
	
	@JsonProperty("email")
	@Column(name = "email")
	private String email;
	
	
	@JsonProperty("cep")
	//@Pattern(regexp = "^[0-9]-[0-9]$")
	@Column(name = "cep")
	private String cep;
	
	@JsonProperty("endereco")
	@Column(name = "endereco")
	private String endereco;
	
	@JsonProperty("numero")
	@Column(name = "numero")
	private String numero;
	
	@JsonProperty("bairro")
	@Column(name = "bairro")
	private String bairro;
	
	@JsonProperty("cidade")
	@Column(name = "cidade")
	private String cidade;
	
	@JsonProperty("estado")
	@Column(name = "estado")
	private String estado;
	
	//@Pattern(regexp ="(\\d{2}) \\d{4}-\\d{4}")
	@JsonProperty("telefone_fixo")
	@Column(name = "telefone_fixo")
	private String telefone_fixo;
	
	@JsonProperty("celular")
	@Column(name = "celular")
	private String celular; 
	
	@JsonProperty("altura")
	@Column(name = "altura")
	private String altura;
	
	@JsonProperty("peso")
	@Column(name = "peso")
	private String peso;
	
	@JsonProperty("tipo_sanguineo")
	@Column(name = "tipo_sanguineo")
	private String tipo_sanguineo;
	
	
	
}
