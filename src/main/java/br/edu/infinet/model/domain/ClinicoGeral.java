package br.edu.infinet.model.domain;

/**
 * @author Guylherme
 *
 */
public class ClinicoGeral extends Especialidade{
	
	public String turno; 
	public String descricao;
	public boolean diarista;
	
	@Override
	public float calcularValorHora() {
		
		float valorDiarista = diarista ? valorHora * 0.7f : valorHora * 0.3f;
		float adicionalNoturno = adicionalNoturno() ? valorHora *0.7f : valorHora *0.3f;
		
		return getValorHora() + valorDiarista + adicionalNoturno;
	}
	
	@Override
	public String toString() {
		return "ClinicoGeral [turno=" + turno + ", diarista=" + diarista + ", descricao=" + descricao + ", " + super.toString() + "]";
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

	public boolean isDiarista() {
		return diarista;
	}

	public void setDiarista(boolean diarista) {
		this.diarista = diarista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public void impressao() {
		System.out.println("#ClinicoGeral");
		System.out.println(this);
		
	}
	
	
	
	
}
