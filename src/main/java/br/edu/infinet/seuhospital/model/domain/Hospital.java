package br.edu.infinet.seuhospital.model.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infinet.seuhospital.interfaces.IPrinter;
import br.edu.infinet.seuhospital.model.exceptions.EnderecoNuloException;
import br.edu.infinet.seuhospital.model.exceptions.EspecialidadeNulaVaziaException;

@Entity
@Table()
public class Hospital implements IPrinter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	private String descricao;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="idEndereco")
	private Endereco endereco;
	
	@ManyToMany(cascade = CascadeType.DETACH) 
	private Set<Especialidade> especialidades;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario; 
	
	public Hospital() { 
	}

	public void impressao() {
		System.out.println("#Hospital");
		System.out.println(this);
	}

	public Hospital(String nome, String cnpj, String descricao, Endereco endereco, Set<Especialidade> especialidades, Usuario usuario)
			throws EnderecoNuloException, EspecialidadeNulaVaziaException {
		if (endereco == null) {
			throw new EnderecoNuloException("Endereço do Hospital não pode ser nulo.");
		}

//		if (especialidades.size() < 1 || especialidades.isEmpty()) {
//			throw new EspecialidadeNulaVaziaException("Especialidade não pode ser vazia ou nula.");
//		}

		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.endereco = endereco;
		this.especialidades = especialidades;
		this.usuario = usuario;
	}	

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", descricao=" + descricao + ", endereco="
				+ endereco + ", Totalespecialidades=" + especialidades.size() + ", usuario=" + usuario + "]";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
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
