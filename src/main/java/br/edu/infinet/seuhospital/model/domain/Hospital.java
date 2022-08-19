package br.edu.infinet.seuhospital.model.domain;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class Hospital implements IPrinter {

	private String nome;
	private String cnpj;
	private String descricao;	
	
	public Hospital(String nome, String cnpj, String descricao) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
	}
	
	public void impressao() {
		System.out.println("#Pedido");
		System.out.println(this);
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
