package br.edu.infinet.seuhospital.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.infinet.seuhospital.interfaces.IPrinter;
import br.edu.infinet.seuhospital.model.exceptions.RuaNaoPreenchidoException;

@Entity
@Table()
public class Endereco implements IPrinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int numero;
	private String rua; 
	private String estado;
	private String pais;
	private String cep;
	
	public void impressao() {
		System.out.println("#Pedido");
		System.out.println(this);
	}
	
	public Endereco(String rua, int numero, String estado, String pais, String cep) throws Exception { 
		
		if(rua == null || rua.isEmpty()) {
			throw new RuaNaoPreenchidoException("Não é possivel aceitar RUA nulo ou vazio."); 
		} 
		
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}



	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", estado=" + estado + ", pais=" + pais + ", cep=" + cep
				+ "]";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
