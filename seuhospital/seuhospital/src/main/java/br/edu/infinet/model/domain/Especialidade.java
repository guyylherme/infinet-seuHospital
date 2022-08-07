package br.edu.infinet.model.domain;

public class Especialidade {
	
	public String nome;
	public int codigo;
	public boolean status;	
	 
	@Override
	public String toString() {
		return "Especialista=" + nome + ", codigo=" + codigo + ", ativo=" + status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
		

}
