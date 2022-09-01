package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.model.exceptions.ValorHoraZeradoException;

public class Dentista extends Especialidade{
	
	public String turno;
	public boolean atendeCrianca;
	public boolean cirurgia;
	
	@Override
	public float calcularValorHora() throws ValorHoraZeradoException {
		
		float valorHora = getValorHora();
		
		if(valorHora < 0) {
			throw new ValorHoraZeradoException("Valor Hora não pode ser menor que zero.");
		} 
		
		float adicionalCirurgia = cirurgia ? valorHora * 0.7f : valorHora * 0.3f;
		float adicionalCrianca = atendeCrianca ? valorHora * 0.6f : valorHora * 0.3f;
		float adicionalNoturno = adicionalNoturno() ? valorHora *0.4f : valorHora *0.1f;
		
		return adicionalCrianca + adicionalNoturno + adicionalCirurgia;
	}
	
	@Override
	public void impressao() {
		System.out.println("#ClinicoGeral");
		System.out.println(this);
		
	}
	
	
	@Override
	public String toString() { 
		return "Dentista [turno=" + turno + ", atendeCrianca=" + atendeCrianca + ", cirurgia=" + cirurgia + ", " + super.toString() + "]";
	}
	
	public boolean adicionalNoturno() {			
		if (getTurno() == "Noturno"){
				return true;
		}		
		return false;
	}


	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}



	public boolean isAtendeCrianca() {
		return atendeCrianca;
	}



	public void setAtendeCrianca(boolean atendeCrianca) {
		this.atendeCrianca = atendeCrianca;
	}



	public boolean isCirurgia() {
		return cirurgia;
	}



	public void setCirurgia(boolean cirurgia) {
		this.cirurgia = cirurgia;
	}
	 

}
