package br.edu.infinet.seuhospital.model.domain;

import java.util.Set;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

public class Hospital implements IPrinter {

	private String nome;
	private String cnpj;
	private String descricao;
	private Endereco endereco;
	private Set<Especialidade> especialidades;
	
	
	public void impressao() {
		System.out.println("#Pedido");
		System.out.println(this);
	}
	
	
	public Hospital(String nome, String cnpj, String descricao) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
	}
	 
	 
	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
		return "Hospital [nome=" + nome + ", cnpj=" + cnpj + ", descricao=" + descricao + ", endereco=" + endereco
				+ ", totalEspecialidade=" + especialidades.size() + "]";
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
