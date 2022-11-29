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

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObesosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sexo;
	
	private int totalSexo;
	
	
	public ObesosDTO() {};
	
	public ObesosDTO(String sexo, int total, float percentM, float percentF) {
		super();
		this.sexo = sexo;
		this.totalSexo = total;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTotalSexo() {
		return totalSexo;
	}

	public void setTotalSexo(int total) {
		this.totalSexo = total;
	}

	
	
	
}
