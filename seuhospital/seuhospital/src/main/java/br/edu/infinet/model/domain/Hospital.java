package br.edu.infinet.model.domain;

public class Hospital {

	private String nome;
	private String cnpj;
	private String descricao;	
	
	public Hospital(String nome, String cnpj, String descricao) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Hospital [nome=" + nome + ", cnpj=" + cnpj + ", descricao=" + descricao + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
