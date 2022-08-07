package br.edu.infinet.model.domain;

/**
 * @author Guylherme
 *
 */
public class ClinicoGeral extends Especialidade{
	
	public String turno;
	public boolean diarista;
	public String descricao;
	
	@Override
	public String toString() {
		return "ClinicoGeral [turno=" + turno + ", diarista=" + diarista + ", descricao=" + descricao + ", " + super.toString() + "]";
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
