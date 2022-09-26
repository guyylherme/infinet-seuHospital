package br.edu.infinet.seuhospital.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infinet.seuhospital.interfaces.IPrinter;

@Entity
@Table()
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Especialidade implements IPrinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String nome;
	private String codigo;
	private boolean status;	
	private float valorHora; 
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "especialidades")
	private List<Hospital> hospitais;
	
	public Especialidade() {}
	 
	public abstract float calcularValorHora() throws Exception; 
	
	@Override
	public String toString() {
		return "Especialidade [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", status=" + status
				+ ", valorHora=" + valorHora + ", usuario=" + usuario + "]";
	}
	
	//public float calcularValorHora(){
	//	return valorHora;
	//} 
	
	@Override
	public void impressao() {
		System.out.println("#Especialidade");
		System.out.println(this);		
	}
	
	public Integer getId() {
		return id;
	}

	public List<Hospital> getHospitais() {
		return hospitais;
	}

	public void setHospitais(List<Hospital> hospitais) {
		this.hospitais = hospitais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidade other = (Especialidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
		

}
