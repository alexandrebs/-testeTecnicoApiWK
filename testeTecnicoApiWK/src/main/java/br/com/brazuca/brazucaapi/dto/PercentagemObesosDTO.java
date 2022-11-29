package br.com.brazuca.brazucaapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class PercentagemObesosDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String masculino;
	private String feminimo;
	private int totalF;
	private int totalM;
	private int totalMF;
	private double perM;
	private double perF;
	
	
	
	public PercentagemObesosDTO() {}



	public PercentagemObesosDTO(String masculino, String feminimo, int totalF, int totalM) {
		super();
		this.masculino = masculino;
		this.feminimo = feminimo;
		this.totalF = totalF;
		this.totalM = totalM;
		this.totalMF = totalF+totalM;
		this.perM = (totalM*100)/totalMF;
		this.perF = (totalF*100)/totalMF;
	}



	public String getMasculino() {
		return masculino;
	}



	public void setMasculino(String masculino) {
		this.masculino = masculino;
	}



	public String getFeminimo() {
		return feminimo;
	}



	public void setFeminimo(String feminimo) {
		this.feminimo = feminimo;
	}



	public int getTotalF() {
		return totalF;
	}



	public void setTotalF(int totalF) {
		this.totalF = totalF;
	}



	public int getTotalM() {
		return totalM;
	}



	public void setTotalM(int totalM) {
		this.totalM = totalM;
	}



	public int getTotalMF() {
		return totalMF;
	}



	public void setTotalMF(int totalMF) {
		this.totalMF = totalMF;
	}



	public double getPerM() {
		return perM;
	}



	public void setPerM(float perM) {
		this.perM = perM;
	}



	public double getPerF() {
		return perF;
	}



	public void setPerF(float perF) {
		this.perF = perF;
	}

	

	
	
	
	
}
