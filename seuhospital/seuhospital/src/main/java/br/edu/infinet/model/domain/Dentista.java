package br.edu.infinet.model.domain;

public class Dentista extends Especialidade{
	
	public String turno;
	public boolean atendeCrianca;
	public boolean cirurgia;
	
	
	@Override
	public String toString() { 
		return "Dentista [turno=" + turno + ", atendeCrianca=" + atendeCrianca + ", cirurgia=" + cirurgia + ", " + super.toString() + "]";
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
