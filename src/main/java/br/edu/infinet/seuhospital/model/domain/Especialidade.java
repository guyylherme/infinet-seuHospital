package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public abstract class Especialidade implements IPrinter {
	
	private Integer id; 
	private String nome;
	private int codigo;
	private boolean status;	
	private float valorHora; 
	 
	public abstract float calcularValorHora(); 
	
	@Override
	public String toString() {
		return "Especialista=" + nome + ", codigo=" + codigo + ", valorHora=" + calcularValorHora()  + ", ativo=" + status;
	}
	
	//public float calcularValorHora(){
	//	return valorHora;
	//}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if (getClass() != obj.getClass())
		//	return false;
		Especialidade other = (Especialidade) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
		

}
