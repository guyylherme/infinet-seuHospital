package br.edu.infinet.model.domain;

public abstract class Especialidade {
	
	public String nome;
	public int codigo;
	public boolean status;	
	public float valorHora; 
	
	public abstract void impressao();
	 
	@Override
	public String toString() {
		return "Especialista=" + nome + ", codigo=" + codigo + ", valorHora=" + calcularValorHora()  + ", ativo=" + status;
	}
	
	public float calcularValorHora(){
		return valorHora;
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
	
	
		

}
