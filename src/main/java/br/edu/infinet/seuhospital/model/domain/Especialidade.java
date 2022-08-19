package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public abstract class Especialidade implements IPrinter {
	
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
