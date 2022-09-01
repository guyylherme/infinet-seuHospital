package br.edu.infinet.seuhospital.model.domain;

import java.util.Set;

import br.edu.infinet.seuhospital.interfaces.IPrinter;
import br.edu.infinet.seuhospital.model.exceptions.EnderecoNuloException;
import br.edu.infinet.seuhospital.model.exceptions.EspecialidadeNulaVaziaException;

public class Hospital implements IPrinter {

	private Integer id;
	private String nome;
	private String cnpj;
	private String descricao;
	private Endereco endereco;
	private Set<Especialidade> especialidades;
	
	
	public void impressao() {
		System.out.println("#Pedido");
		System.out.println(this);
	}
	
	
	public Hospital(String nome, String cnpj, String descricao, Endereco endereco , Set<Especialidade> especialidades) throws EnderecoNuloException, EspecialidadeNulaVaziaException {
if(endereco == null) {
			throw new EnderecoNuloException("Endereço do Hospital não pode ser nulo.");
		}
		
		
		if(especialidades.size() < 1 || especialidades.isEmpty()) {
			throw new EspecialidadeNulaVaziaException("Especialidade não pode ser vazia ou nula.");
		}
		
		
		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.endereco = endereco;
		this.especialidades = especialidades;
	}
	 
	
	 
	public Set<Especialidade> getEspecialidades() {
		return especialidades;
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	} 
	

}
