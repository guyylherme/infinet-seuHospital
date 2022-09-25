package br.edu.infinet.seuhospital.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.infinet.seuhospital.model.exceptions.PeriodoInvalidoException;

/**
 * @author Guylherme
 *
 */
@Entity
@Table()
public class ClinicoGeral extends Especialidade{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	public String turno; 
	public String descricao;
	public boolean diarista;
	
	@Override
	public float calcularValorHora() throws Exception {
		
		String turno = getTurno(); 
		
		if(!turno.equals("Noturno") && !turno.equals("Diúrno")) {
			throw new PeriodoInvalidoException("Turno não pode ser diferente de Noturno ou Diúrno.");
		}
		
		float valorHora = getValorHora();
		
		float valorDiarista = diarista ? valorHora * 0.7f : valorHora * 0.3f;
		float adicionalNoturno = adicionalNoturno() ? valorHora *0.7f : valorHora *0.3f;
		
		return getValorHora() + valorDiarista + adicionalNoturno;
	}
	
	@Override
	public void impressao() {
		System.out.println();
		System.out.println("#ClinicoGeral");
		System.out.println(this); 	
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
 	
	
	
}
